package com.geekshirt.order.controllers;

import com.geekshirt.order.dto.OrderRequest;
import com.geekshirt.order.dto.OrderResponse;
import com.geekshirt.order.entities.Order;
import com.geekshirt.order.service.OrderService;
import com.geekshirt.order.util.EntityDTOConverter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Api
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private EntityDTOConverter converter;

    @ApiOperation(value="Retrive all existed orders", notes = "This operation returned all stored orders")
    @GetMapping(value = "order")
    public ResponseEntity<List<OrderResponse>> findAll(){
        List<Order> orders = orderService.findAllOrders();
        return new ResponseEntity<>(converter.convertEntityToDto(orders), HttpStatus.OK);
    }

    @ApiOperation(value = "Retrive an order based on Id", notes = "This operation returns an order choosing it's Id")
    @GetMapping(value = "order/{orderId}")
    public ResponseEntity<OrderResponse> findById(@PathVariable String orderId){
        Order order = orderService.findOrderById(orderId);
        return new ResponseEntity<>(converter.convertEntityToDto(order), HttpStatus.OK);
    }

    @ApiOperation( value = "Create an order", notes = "This operation creates a new order")
    @PostMapping(value = "order/create")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest payload){
        Order order = orderService.createOrder(payload);
        return new ResponseEntity<>(converter.convertEntityToDto(order), HttpStatus.CREATED);
    }
}
