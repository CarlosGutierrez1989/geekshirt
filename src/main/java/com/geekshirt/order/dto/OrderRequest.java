package com.geekshirt.order.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


@Getter
@ApiModel(description = "Class representing an order to be processed")
public class OrderRequest {
    @NotBlank
    @NotNull
    @ApiModelProperty(notes = "Account Id", example = "999999", required = true)
    String accountId;

    @ApiModelProperty(notes = "Items included in the order", required = true )
    private List<LineItem> items;

}
