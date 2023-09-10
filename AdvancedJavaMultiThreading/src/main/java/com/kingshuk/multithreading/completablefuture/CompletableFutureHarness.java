package com.kingshuk.multithreading.completablefuture;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.kingshuk.multithreading.completablefuture.orderprocessing.Address;
import com.kingshuk.multithreading.completablefuture.orderprocessing.OrderEntry;
import com.kingshuk.multithreading.completablefuture.orderprocessing.OrderItem;
import com.kingshuk.multithreading.completablefuture.orderprocessing.PaymentMode;

public class CompletableFutureHarness {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		CompletableFuture<Void> orderProcessing = CompletableFuture.supplyAsync(() -> {
			System.out.println(Thread.currentThread().getName() + " is executing initial order");
			return OrderEntry.builder().orderId(52l)
					.orderItemList(Arrays.asList(
							OrderItem.builder().amount(BigDecimal.valueOf(100.56)).orderItemId(1)
									.orderItemName("Nike Shoe").build(),
							OrderItem.builder().amount(BigDecimal.valueOf(98.56)).orderItemId(2)
									.orderItemName("Addidas Shoe").build()))

					.build();
		}).thenApply(order -> {
			System.out.println(Thread.currentThread().getName() + " is enriching the initial order");
			order.setTotalAmount(BigDecimal.valueOf(order.getOrderItemList().stream()
					.mapToDouble(orderitem -> orderitem.getAmount().doubleValue()).sum()));

			return order;

		}).thenApply(order -> {
			System.out.println(Thread.currentThread().getName() + " is adding payment to the order");
			order.setPaymentMode(PaymentMode.CREDIT_CARD);
			return order;
		}).thenApply(order -> {
			System.out.println(Thread.currentThread().getName() + " is adding shipping details to the order");
			order.setShippingLocation(Address.builder().city("Buffalo Grove").zipCode("60089").build());

			return order;
		}).thenAccept(order -> {
			System.out.println(Thread.currentThread().getName() + " is finalizing order and sending email");
			System.out.println("Order processing completed...email sent");
			System.out.println("The final order is: " + order);
		});
		
		orderProcessing.get();
		
		System.out.println("\n================new order=========================/n");
		
		
		CompletableFuture<Void> orderProcessing2 = CompletableFuture.supplyAsync(() -> {
			System.out.println(Thread.currentThread().getName() + " is executing initial order");
			return OrderEntry.builder().orderId(52l)
					.orderItemList(Arrays.asList(
							OrderItem.builder().amount(BigDecimal.valueOf(100.56)).orderItemId(1)
									.orderItemName("Nike Shoe").build(),
							OrderItem.builder().amount(BigDecimal.valueOf(98.56)).orderItemId(2)
									.orderItemName("Addidas Shoe").build()))

					.build();
		}).thenApplyAsync(order -> {
			System.out.println(Thread.currentThread().getName() + " is enriching the initial order");
			order.setTotalAmount(BigDecimal.valueOf(order.getOrderItemList().stream()
					.mapToDouble(orderitem -> orderitem.getAmount().doubleValue()).sum()));

			return order;

		}).thenApplyAsync(order -> {
			System.out.println(Thread.currentThread().getName() + " is adding payment to the order");
			order.setPaymentMode(PaymentMode.CREDIT_CARD);
			return order;
		}).thenApplyAsync(order -> {
			System.out.println(Thread.currentThread().getName() + " is adding shipping details to the order");
			order.setShippingLocation(Address.builder().city("Buffalo Grove").zipCode("60089").build());

			return order;
		}).thenAcceptAsync(order -> {
			System.out.println(Thread.currentThread().getName() + " is finalizing order and sending email");
			System.out.println("Order processing completed...email sent");
			System.out.println("The final order is: " + order);
		});

		orderProcessing2.get();
	}

}
