package com.jack.springbootrabbitmq.coustomer.topic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
@Slf4j
@Component
@RabbitListener(queues = "JackOne")
public class ConsumerOne {

    @RabbitHandler
    public void listenter(String msg){
      log.info("消费者 one 收到消息内容 去杀掉特狼狈 "+msg);
    }

}
