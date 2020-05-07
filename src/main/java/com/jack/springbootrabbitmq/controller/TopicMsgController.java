package com.jack.springbootrabbitmq.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topic")
public class TopicMsgController {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @RequestMapping("/one")
    public String sendOne(){
        return sendMsg("jack.#","问题不严重先杀一个");
    }

    @RequestMapping("/two")
    public String sendTwo(){
        return sendMsg("#.log","问题不小先杀俩个");
    }

    @RequestMapping("/three")
    public String sendThree(){
        return sendMsg("jack.log","问题挺严重先杀三个");
    }

    private String sendMsg(String routingKey, String msg){
        rabbitTemplate.convertAndSend("Jack.TopicExchange",routingKey,msg);
        return "ok"+msg;
    }
}
