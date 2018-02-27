package edu.carrollcc.cis232.example7;

public class BankAppCavemanTest {
	public static void main(String[] args) {
		// Force a NegativeStartingBalance exception.
		try {
			BankAccount account = new BankAccount(-1, 0.04);
		} catch (NegativeStartingBalance e) {
			System.out.println(e.getMessage());
		} catch (NegativeInterestRate e) {
			System.out.println(e.getMessage());
		}

		// Force a NegativeInterestRate exception.
		try {
			BankAccount account = new BankAccount(100, -0.04);
		} catch (NegativeStartingBalance e) {
			System.out.println(e.getMessage());
		} catch (NegativeInterestRate e) {
			System.out.println(e.getMessage());
		}
	}
}
