package edu.carrollcc.cis232.example1;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.BufferOverflowException;

public class BadArrayApp {

	public static void main(String[] args) {
		int[] numbers = {1, 2, 3};

		try {
			showAllNumbers(numbers);
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("We caught the out of bound index!");
		}

		System.out.println("Program exiting gracefully");
	}

	private static void showAllNumbers(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}
}
