package com.kingshuk.multithreading;

import java.util.Arrays;
import java.util.List;

public class InterviewProgram {

	public static void main(String[] args) {
		List<Integer> asList = Arrays.asList(12, 34, 9, 76, 45, 19);

		InterviewProgram i = new InterviewProgram();

		System.out.println(i.findLargestNumber(asList));
	}

	public int findLargestNumber(List<Integer> numbersList) {

		int largest = 0;

		for (Integer integer : numbersList) {
			if(integer > largest) {
				largest = integer;
			}
		}
		
		return largest;
	}

}
