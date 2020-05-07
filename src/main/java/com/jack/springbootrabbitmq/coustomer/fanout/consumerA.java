package com.jack.springbootrabbitmq.coustomer.fanout;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
@Slf4j
@Component
@RabbitListener(queues= "FanoutQueueA")
public class consumerA {

    @RabbitHandler
    public void listenterA(String msg){
      log.info("fanout 模式 A 收到消息:"+ msg);
    }

}
