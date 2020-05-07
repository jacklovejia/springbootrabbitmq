package com.jack.springbootrabbitmq.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fanout")
public class FanoutMsgController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/msg")
    public String sendOne(){
        for (int i = 0; i < 2; i++) {
            rabbitTemplate.convertAndSend("FanoutExchange","","第"+i+"条消息");
        }
        return "ok";
    }


}
