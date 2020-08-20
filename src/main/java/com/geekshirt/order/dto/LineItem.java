package com.geekshirt.order.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel( description = "Class that represent an item in the order")
public class LineItem {
    @ApiModelProperty(notes = "UPC (Universal Product Code), Length 12 digits",
                      example = "123456654321", required = true, position = 0)
    private String upc;
    @ApiModelProperty(notes = "Quantity", example = "5", required = true, position = 1)
    private int quantity;
    @ApiModelProperty(notes = "Price", example = "10.00", required = true, position = 2 )
    private double price;
}
