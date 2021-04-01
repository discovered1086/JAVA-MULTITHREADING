package com.kingshuk.multithreading;

import java.util.function.Function;

@SuppressWarnings({"unused", "squid:S4276", "squid:S1854", "squid:S1481"})
public class ByteCodeVerification {
	
	public static void main(String[] args) {
		Function<String, Integer> f = Integer::parseInt;
	}

}
