package com.pharmacy.ordermanagement.Service;

import com.pharmacy.ordermanagement.Entity.Order;

import java.util.List;

public interface OrderService {

    public List<Order> getOrder();

    public Order saveOrder(Order order);

    public Order updateOrder(Order order, String id);

    public String deleteOrder(String id);
}
