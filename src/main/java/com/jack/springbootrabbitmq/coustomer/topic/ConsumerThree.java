package com.jack.springbootrabbitmq.coustomer.topic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ConsumerThree {

    @RabbitHandler
    @RabbitListener(queues = "JackThree")
    public void listenter(String msg){
      log.info("消费者 three 杀手一号 收到消息内容 去杀掉特狼狈媳妇 "+msg);
    }


    @RabbitHandler
    @RabbitListener(queues = "JackThree")
    public void listenter2(String msg){
      log.info("消费者 three 坦克大军 收到消息内容 去杀掉特狼狈媳妇 "+msg);
    }

}
