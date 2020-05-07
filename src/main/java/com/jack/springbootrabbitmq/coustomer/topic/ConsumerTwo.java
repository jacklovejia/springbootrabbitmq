package com.jack.springbootrabbitmq.coustomer.topic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RabbitListener(queues = "JackTwo")
public class ConsumerTwo {

    @RabbitHandler
    public void listenter(String msg){
      log.info("消费者 two 收到消息内容 去杀掉特狼狈小三 "+msg);
    }

}
