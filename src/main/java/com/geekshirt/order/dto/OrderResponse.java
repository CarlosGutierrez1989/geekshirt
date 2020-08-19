package com.geekshirt.order.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OrderResponse {

    private String orderId;
    private String status;
    private String accountId;
    private Date   transactionDate;
    private Double totalAmount;
    private Double totalTax;

}
