package com.zb.statemachine.service;

import java.util.Map;

import com.zb.statemachine.model.Order;

/**
 * @author: zhaobin
 * @date: 2022/9/28 18:40
 * @Description:
 */
public interface OrderService {
    public Order creat();
    public Order pay(int id);
    public Order deliver(int id);
    public Order receive(int id);
    public Map<Integer, Order> getOrders();
}
