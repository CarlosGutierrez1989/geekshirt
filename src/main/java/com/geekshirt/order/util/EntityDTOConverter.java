package com.geekshirt.order.util;

import com.geekshirt.order.dto.OrderResponse;
import com.geekshirt.order.entities.Order;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.modelmapper.Converters.Collection.map;

@Component
public class EntityDTOConverter {
    @Autowired
    private ModelMapper modelMapper;

    public OrderResponse convertEntityToDto(Order order){

        return modelMapper.map(order, OrderResponse.class);
    }

    public List<OrderResponse> convertEntityToDto(List<Order> orders){
        return orders.stream()
                .map(order -> convertEntityToDto(order))
                .collect(Collectors.toList());
    }
}
