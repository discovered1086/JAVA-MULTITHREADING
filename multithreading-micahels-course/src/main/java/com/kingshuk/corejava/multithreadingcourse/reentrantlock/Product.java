package com.kingshuk.corejava.multithreadingcourse.reentrantlock;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@Data
@Builder
public class Product {
    @EqualsAndHashCode.Include
    private String productName;

    @EqualsAndHashCode.Exclude
    private double productPrice;

    private int quantityLeft;
}
