package com.jack.springbootrabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 分裂模式配置
 */
@Configuration
public class FanoutMsgConfig {
    // 配置一个 Fanout交换机
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("FanoutExchange");
    }

    // 配置两个队列
    @Bean
    Queue queueA() {
        return new Queue("FanoutQueueA");
    }

    @Bean
    Queue queueB() {
        return new Queue("FanoutQueueB");
    }

    // 绑定
    @Bean
    Binding bindingA() {
        return BindingBuilder.bind(queueA()).to(fanoutExchange());
    }

    @Bean
    Binding bindingB() {
        return BindingBuilder.bind(queueB()).to(fanoutExchange());
    }

}
