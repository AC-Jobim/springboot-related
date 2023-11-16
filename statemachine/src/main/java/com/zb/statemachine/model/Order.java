package com.zb.statemachine.model;

import lombok.Data;

/**
 * @author: zhaobin
 * @date: 2022/9/28 18:37
 * @Description:
 */
@Data
public class Order {
    private int id;
    private OrderStatus status;
}
