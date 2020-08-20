package com.geekshirt.order.controllers;

import com.geekshirt.order.dto.OrderRequest;
import com.geekshirt.order.dto.OrderResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Api
@RestController
public class OrderController {

    @ApiOperation(value="Retrive all existed orders", notes = "This operation returned all stored orders")
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

    @ApiOperation(value = "Retrive an order based on Id", notes = "This operation returns an order choosing it's Id")
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

    @ApiOperation( value = "Create an order", notes = "This operation creates a new order")
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
