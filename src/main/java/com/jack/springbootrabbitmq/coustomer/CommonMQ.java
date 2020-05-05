package com.jack.springbootrabbitmq.coustomer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
public class CommonMQ {

    @RabbitHandler
    @RabbitListener(queues = "test")
    public void listenter(String s) {
        System.out.println(s);
    }
    @RabbitHandler
    @RabbitListener(queues = "test")
    public void listenter1(String s) {
        System.out.println("aaa:"+s);
    }
}
