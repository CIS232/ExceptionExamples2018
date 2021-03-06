package edu.carrollcc.cis232.example4;

import java.io.*;    // For File class and FileNotFoundException
import java.util.*;  // For Scanner and InputMismatchException

/**
 * This program demonstrates how exception handlers can
 * be used to recover from errors.
 */

public class SalesReport2 {
	public static void main(String[] args) {
		String filename = "SalesData2.txt"; // File name
		int months = 0;                    // Month counter
		double oneMonth;                   // One month's sales
		double totalSales = 0.0;           // Total sales
		double averageSales;               // Average sales

		// Attempt to open the file by calling the
		// openfile method.
		Scanner inputFile = openFile(filename);

		// If the openFile method returned null, then
		// the file was not found. Get a new file name.
		while (inputFile == null) {
			Scanner keyboard = new Scanner(System.in);
			System.out.print("ERROR: " + filename +
					" does not exist.\n" +
					"Enter another file name: ");
			filename = keyboard.nextLine();
			inputFile = openFile(filename);
		}

		displayFile(filename);


		// Process the contents of the file.
		while (inputFile.hasNext()) {
			try {
				// Get a month's sales amount.
				oneMonth = inputFile.nextDouble();

				// Accumulate the amount.
				totalSales += oneMonth;

				// Increment the month counter.
				months++;
			} catch (InputMismatchException e) {
				// Display an error message.
				// Nonnumeric data was encountered.
				System.out.println("Nonnumeric data " +
						"encountered in the file: " +
						e.getMessage());

				System.out.println("The invalid record " +
						"will be skipped.");

				// Skip past the invalid data.
				inputFile.nextLine();
			} catch (NoSuchElementException e) {
				System.out.println("No such element!");
				inputFile.nextLine();
			} catch (Exception e) {
				System.out.println("Some error happened? " + e.getMessage());
				inputFile.nextLine();
			}


		}

		// Close the file.
		inputFile.close();

		// Calculate the average.
		averageSales = totalSales / months;

		// Display the results.
		System.out.printf("Number of months: %s\n", months);
		System.out.printf("Total Sales: $%,.2f\n", totalSales);
		System.out.printf("Average Sales: $%,.2f\n", averageSales);
	}

	/**
	 * The openFile method opens the file with the name specified
	 * by the argument. A reference to a Scanner object is
	 * returned.
	 */

	public static Scanner openFile(String filename) {
		Scanner scan;

		// Attempt to open the file.
		try {
			File file = new File(filename);
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			scan = null;
		}

		return scan;
	}

	// This method will not compile!
	public static void displayFile(String name) {
		try {
			// Open the file.
			File file = new File(name);
			Scanner inputFile = new Scanner(file);
			// Read and display the file's contents.
			System.out.println("File contents:");
			while (inputFile.hasNext()) {
				System.out.println(inputFile.nextLine());
			}
			// Close the file.
			inputFile.close();
		} catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}
	}

}
