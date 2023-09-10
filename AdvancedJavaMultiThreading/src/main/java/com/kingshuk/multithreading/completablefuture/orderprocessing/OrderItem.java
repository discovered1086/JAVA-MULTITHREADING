package com.kingshuk.multithreading.completablefuture.orderprocessing;

import java.math.BigDecimal;

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
public class OrderItem {

	private long orderItemId;
	
	private String orderItemName;
	
	private String orderItemDescription;
	
	private BigDecimal amount;

}
