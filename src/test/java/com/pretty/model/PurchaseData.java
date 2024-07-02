package com.pretty.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PurchaseData {

    private String productName;
    private String size;
    private Integer initialCartCount;
    private Integer cartCount;
    private String subTotal;

    private Long deliveryTotal;
    private Long grandTotal;

}
