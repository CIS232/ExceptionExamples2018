package edu.carrollcc.cis232.example7;

public class NegativeStartingBalance extends Exception {

	public NegativeStartingBalance(){
		super("Error: Negative starting balance");
	}

	public NegativeStartingBalance(double amount){
		super("Error: Negative starting balance: " + amount);
	}
}
