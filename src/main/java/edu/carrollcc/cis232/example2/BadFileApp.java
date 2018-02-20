package edu.carrollcc.cis232.example2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BadFileApp {
	public static void main(String[] args) {
		// Create a Scanner object for keyboard input.
		Scanner keyboard = new Scanner(System.in);

		boolean isFileFound = false;
		while(!isFileFound) {
			// Get a file name from the user.
			System.out.print("Enter the name of a file: ");
			String fileName = keyboard.nextLine();

			// Attempt to open the file.
			try {
				// Create a File object representing the file.
				File file = new File(fileName);

				// Create a Scanner object to read the file.
				// If the file does not exist, the following
				// statement will throw a FileNotFoundException.
				Scanner inputFile = new Scanner(file);

				// If the file was successfully opened, the
				// following statement will execute.
				System.out.println("The file was found.");
				isFileFound = true;
			} catch (Exception e) {
				// If the file was not found, the following
				// statement will execute.
				//System.out.println("File not found.");
				System.out.println(e.getMessage());
			}
		}

		System.out.println("Done.");
	}
}
