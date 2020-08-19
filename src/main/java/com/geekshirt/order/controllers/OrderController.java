package com.geekshirt.order.controllers;

import com.geekshirt.order.dto.OrderRequest;
import com.geekshirt.order.dto.OrderResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class OrderController {

    //return all orders
    @GetMapping(value = "order")
    public ResponseEntity<List<OrderResponse>> findAll(){

        List<OrderResponse> orderList = new ArrayList<>();

        OrderResponse response = new OrderResponse();
        response.setAccountId("999991");
        response.setOrderId("12345");
        response.setStatus("Pending");
        response.setTotalAmount(100.00);
        response.setTotalTax(10.00);
        response.setTransactionDate(new Date());

        OrderResponse response2 = new OrderResponse();
        response2.setAccountId("999992");
        response2.setOrderId("12346");
        response2.setStatus("Pending");
        response2.setTotalAmount(120.00);
        response2.setTotalTax(12.00);
        response2.setTransactionDate(new Date());

        orderList.add(response);
        orderList.add(response2);

        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @GetMapping(value = "order/{orderId}")
    public ResponseEntity<OrderResponse> findById(@PathVariable String orderId){

        OrderResponse response = new OrderResponse();
        response.setAccountId("999991");
        response.setOrderId(orderId);
        response.setStatus("Pending");
        response.setTotalAmount(100.00);
        response.setTotalTax(10.00);
        response.setTransactionDate(new Date());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "order/create")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest payload){

        OrderResponse response = new OrderResponse();
        response.setAccountId(payload.getAccountId());
        response.setOrderId("9999");
        response.setStatus("Pending");
        response.setTotalAmount(100.00);
        response.setTotalTax(10.00);
        response.setTransactionDate(new Date());

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

}
