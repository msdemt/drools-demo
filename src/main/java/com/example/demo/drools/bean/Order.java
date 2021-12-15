package com.example.demo.drools.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Double originalPrice; //订单原始价格，即优惠前的价格
    private Double realPrice; //订单真实价格，即优惠后的价格
}
