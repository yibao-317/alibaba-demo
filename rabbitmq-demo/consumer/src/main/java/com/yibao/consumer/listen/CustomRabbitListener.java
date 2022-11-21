package com.yibao.consumer.listen;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author liyi
 * @create 2022 -11 -21 -15:43
 */
@Component
@Slf4j
public class CustomRabbitListener {

    /**
     * 方法：监听消费 简单队列
     * @param msg
     */
    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueueMsg(String msg) {
        log.info("custom msg : " + msg);
    }

    /**
     * 方法：监听消费 工作队列1  --- 预取机制
     * @param msg
     */
    @RabbitListener(queues = "work.queue")
    public void listenWorkFirstQueueMsg(String msg) {
        log.info("custom msg -- work1 -- : " + msg);
        try {
            Thread.sleep(25);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方法：监听消费 工作队列2  --- 预取机制
     * @param msg
     */
    @RabbitListener(queues = "work.queue")
    public void listenWorkSencondQueueMsg(String msg) {
        log.info("custom msg -- work2 -- : " + msg);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方法：监听消费 广播 1
     * @param msg
     */
    @RabbitListener(queues = "fanout.queue1")
    public void listenFanoutQueueMsg1(String msg) {
        log.info("fanout 1 msg : " + msg);
    }

    /**
     * 方法：监听消费 广播 2
     * @param msg
     */
    @RabbitListener(queues = "fanout.queue2")
    public void listenFanoutQueueMsg2(String msg) {
        log.info("fanout 2 msg : " + msg);
    }


    /**
     * 方法：监听消费 路由 1 -- red | blue
     * @param msg
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue1"),
            exchange = @Exchange(name = "itcast.direct",type = ExchangeTypes.DIRECT),
            key = {"red","blue"}
    ))
    public void listenDirectQueueMsg1(String msg) {
        log.info("direct 1 msg : " + msg);
    }

    /**
     * 方法：监听消费 路由 2 red | yellow
     * @param msg
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue2"),
            exchange = @Exchange(name = "itcast.direct",type = ExchangeTypes.DIRECT),
            key = {"red","yellow"}
    ))
    public void listenDirectQueueMsg2(String msg) {
        log.info("direct 2 msg : " + msg);
    }


    /**
     * 方法：监听消费 通配 1
     * @param msg
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topic.queue1"),
            exchange = @Exchange(name = "itcast.topic",type = ExchangeTypes.TOPIC),
            key = {"yibao.#"}
    ))
    public void listenTopicQueueMsg1(String msg) {
        log.info("topic 1 msg : " + msg);
    }

    /**
     * 方法：监听消费 通配 2
     * @param msg
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topic.queue2"),
            exchange = @Exchange(name = "itcast.topic",type = ExchangeTypes.TOPIC),
            key = {"#.news"}
    ))
    public void listenTopicQueueMsg2(String msg) {
        log.info("topic 2 msg : " + msg);
    }








}
