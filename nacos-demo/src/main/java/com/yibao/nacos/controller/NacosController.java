package com.yibao.nacos.controller;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * @author yibao
 * @create 2022 -11 -14
 * @desc nacos 测试代码
 */
@RestController
@RequestMapping("/nacos")
public class NacosController {

    @Value("${mytest.val}")
    private String configVal;

    @Value("${spring.datasource.url}")
    private String url;

    // 注入配置文件上下文
    @Autowired
    private ConfigurableApplicationContext applicationContext;

    /**
     * 方法：测试nacos配置管理是否能获取值
     */
    @GetMapping("/testConfig")
    public void testConfig() {
        try {
            // 1.服务地址
            String serverAddr = "127.0.0.1:8848";
            // 2. data id
            String dataId = "common.yml";
            // 3.group
            String group = "DEFAULT_GROUP";
            // 4.namespace
            String namespace = "33f134a8-bc10-4e97-8eff-1f4c930b732c";
            // 5.获取配置
            Properties properties = new Properties();
            properties.put("serverAddr", serverAddr);
            properties.put("namespace", namespace);
            ConfigService configService = NacosFactory.createConfigService(properties);
            String config = configService.getConfig(dataId, group, 5000);
            // 6.监听 -- 实时获取配置内容
            configService.addListener(dataId, group, new Listener() {
                @Override
                public Executor getExecutor() {
                    return null;
                }
                // 实时获取配置
                @Override
                public void receiveConfigInfo(String s) {
                    System.out.println(s);
                }
            });
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }


    /**
     * 方法：获取在 nacos 中的属性值
     */
    @GetMapping("/test2")
    public void test2() {
        System.out.println("------》》》》 "+configVal);
    }

    /**
     * 方法：使用上下文的方式，动态获取属性值
     */
    @GetMapping("/test3")
    public void test3() {
        String property = applicationContext.getEnvironment().getProperty("mytest.val");
        System.out.println("----》》》 "+property);
    }

    /**
     * 方法：测试共享配置文件
     */
    @GetMapping("/test4")
    public void test4() {
        System.out.println("----》》 "+url);
    }

}
