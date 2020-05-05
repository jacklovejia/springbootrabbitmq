package com.jack.springbootrabbitmq.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 取消订单
 */
@Data
@ToString
public class CancelOrder {
    private String tranId;
    private String orderId;
    private Date createTime;

}
