package com.jack.springbootrabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 主题模式 topic 测试
 */
@Configuration
public class TopicMsgConfig {

    /**
     * 配置三个队列 来测试
     */

    // 配置一个topic 交换机
    @Bean
    Exchange TopicExchange(){
        return new TopicExchange("Jack.TopicExchange");
    }
    // 配置三个队列
    @Bean
    Queue QueueOne(){
        return new Queue("JackOne");
    }
    @Bean
    Queue QueueTwo(){
        return new Queue("JackTwo");
    }
    @Bean
    Queue QueueThree(){
        return new Queue("JackThree");
    }

    // 将队列绑定到交换机并且设置 Routing key
    @Bean
    Binding oneToExchange(){
        return BindingBuilder.bind(QueueOne()).to(TopicExchange()).with("jack.#").noargs();
    }
    @Bean
    Binding twoToExchange(){
        return BindingBuilder.bind(QueueTwo()).to(TopicExchange()).with("#.log").noargs();
    }
    @Bean
    Binding threeToExchange(){
        return BindingBuilder.bind(QueueThree()).to(TopicExchange()).with("jack.log").noargs();
    }

}
