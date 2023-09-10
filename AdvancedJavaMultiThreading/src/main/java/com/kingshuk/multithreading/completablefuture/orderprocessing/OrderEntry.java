package com.kingshuk.multithreading.completablefuture.orderprocessing;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class OrderEntry {

	private long orderId;
	
	private List<OrderItem> orderItemList;
	
	private BigDecimal totalAmount;
	
	private PaymentMode paymentMode;
	
	private Address shippingLocation;
}
