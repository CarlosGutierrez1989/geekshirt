package com.geekshirt.order.service;

import com.geekshirt.order.dto.OrderRequest;
import com.geekshirt.order.dto.OrderResponse;
import com.geekshirt.order.entities.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    public Order createOrder(OrderRequest orderRequest) {

        Order response = new Order();
        response.setAccountId("999999");
        response.setOrderId("9999");
        response.setStatus("PENDING");
        response.setTotalAmount(100.00);
        response.setTotalTax(10.00);
        response.setTransactionDate(new Date());

        return response;
    }

    public List<Order> findAllOrders(){
        List<Order> orderList = new ArrayList<>();

        Order response = new Order();
        response.setAccountId("999991");
        response.setOrderId("12345");
        response.setStatus("Pending");
        response.setTotalAmount(100.00);
        response.setTotalTax(10.00);
        response.setTransactionDate(new Date());

        Order response2 = new Order();
        response2.setAccountId("999992");
        response2.setOrderId("12346");
        response2.setStatus("Pending");
        response2.setTotalAmount(120.00);
        response2.setTotalTax(12.00);
        response2.setTransactionDate(new Date());

        orderList.add(response);
        orderList.add(response2);

        return orderList;
    }

    public Order findOrderById(String orderId){

        Order response = new Order();
        response.setAccountId("999991");
        response.setOrderId(orderId);
        response.setStatus("Pending");
        response.setTotalAmount(100.00);
        response.setTotalTax(10.00);
        response.setTransactionDate(new Date());

        return response;

    }
}
