package com.jack.springbootrabbitmq.controller;

import com.alibaba.fastjson.JSONObject;
import com.jack.springbootrabbitmq.entity.CancelOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

import static com.jack.springbootrabbitmq.config.DelayedRabbitMQConfig.DELAYED_EXCHANGE_NAME;
import static com.jack.springbootrabbitmq.config.DelayedRabbitMQConfig.DELAYED_ROUTING_KEY;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * @param msg       消息
     * @param delayTime 延迟时间
     * @return
     */
    @PostMapping("/testRabbitMQ")
    public String testRabbitMQ(@RequestParam String msg, @RequestParam Integer delayTime) {
        log.info("当前时间：{},收到请求，msg:{},delayTime:{} 秒", new Date(), msg, delayTime);
        CancelOrder order = new CancelOrder();
        order.setTranId(UUID.randomUUID().toString());
        order.setOrderId(UUID.randomUUID().toString());
        order.setCreateTime(new Date());

        rabbitTemplate.convertAndSend(DELAYED_EXCHANGE_NAME, DELAYED_ROUTING_KEY, JSONObject.toJSONString(order), a -> {
            a.getMessageProperties().setDelay(delayTime * 1000);
            return a;
        });
        return "ok";
    }

    @GetMapping("/test")
    public String testRabbitMQ1() {
        return "ok";
    }

}
