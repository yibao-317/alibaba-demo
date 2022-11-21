package com.yibao.publisher.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author yibao
 * @create 2022 -11 -17
 * @desc
 */
@RestController
@RequestMapping("/publisher")
@Slf4j
public class PublisherController {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/test")
    public void test() {
        log.info("-------- publisher is ok -----------");
    }

    /**
     * 方法：简单队列（生产方）
     */
    @GetMapping("testSimpleQueue")
    public void testSimpleQueue() {
        String queueName = "simple.queue";
        String msg = "--- simple queue ---";
        rabbitTemplate.convertAndSend(queueName, msg);
    }

    /**
     * 方法：工作队列（生产方）-- 绑定多个消费者
     */
    @GetMapping("testWorkQueue")
    public void testWorkQueue() {
        String queueName = "work.queue";
        String msg = "--- work queue ---";
        for (int i = 0; i < 50; i++) {
            // 循环发送消息
            rabbitTemplate.convertAndSend(queueName, msg);
            // 睡眠
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 方法：测试广播
     */
    @GetMapping("testFanoutQueue")
    public void testFanoutQueue() {
        // 交换机
        String exchangeName = "itcast.fanout";
        // 消息
        String msg = "---- fanout msg ----";
        // 发送
        rabbitTemplate.convertAndSend(exchangeName, "", msg);
    }


    /**
     * 方法：测试路由
     */
    @GetMapping("testDirectQueue")
    public void testDirectQueue() {
        // 交换机
        String exchangeName = "itcast.direct";
        // 消息
        String msg = "---- direct msg ----";
        // 发送 (red接收)
        rabbitTemplate.convertAndSend(exchangeName, "red", msg);
    }

    /**
     * 方法：测试通配
     */
    @GetMapping("testTopicQueue")
    public void testTopicQueue() {
        // 交换机
        String exchangeName = "itcast.topic";
        // 消息
        String msg = "---- topic msg ----";
        // 发送 (red接收)
        rabbitTemplate.convertAndSend(exchangeName, "yibao.news", msg);
    }

    /**
     * 方法：测试 消息确认机制
     */
    @GetMapping("/testAckCallback")
    public void testAckCallback() {
        // 消息体
        String msg = "---- ack msg ----";
        // 消息 id
        CorrelationData data = new CorrelationData(UUID.randomUUID().toString());
        // 添加 callback
        data.getFuture().addCallback(
                result -> {
                    if (result.isAck()) {
                        log.info("消息发送成功，ID：{}", data.getId());
                    } else {
                        log.error("消息发送失败，ID：{}，原因：{}", data.getId(), result.getReason());
                    }
                },
                ex -> log.error("消息发送异常，ID：{}，原因：{}", data.getId(), ex.getMessage())
        );
        // 发送消息
        rabbitTemplate.convertAndSend("amp.direct", "simple", msg, data);
    }





}
