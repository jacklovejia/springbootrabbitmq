package com.jack.springbootrabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestApp {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    public void sendMSG(){
        int count = 10;
        for (int i = 0; i < count; i++) {
            rabbitTemplate.convertAndSend("test","消息:"+i);
            System.out.println("发送消息"+i);
        }
    }
}
