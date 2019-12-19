/**
 * the console menu class is used to create console menu objects, this class is used to create the book console menu
 * @author Abrahim Djordjevic
 */

import java.util.Scanner;
public class ConsoleMenu {
	/**
	 * variables
	 * 		the number of options represented by <numOptions>
	 * 		users choice <choice>
	 * 		an array of options <options>
	 * 		the final option in the menu <finalOption>
	 * 		title <title>
	 */
	private int numOptions;
	private int choice;
	private String[] options;
	private String finalOption;
	private String title;
	public static Scanner In = new Scanner(System.in);
	public ConsoleMenu(String[] options) {
		this.options = options;
		numOptions = options.length;
	}
	
	//a method for adding items to options
	public String[] addItems(String item) {
		String[] tempArray = new String[numOptions + 1];
		//adding values into the new array
		for (int i = 0; i < numOptions; i++ ) {
			options[i] = tempArray[i];
		}
		tempArray[numOptions + 1] = item;
		options = tempArray;
		return options;
	}
	
	//a method for setting the title
	public void setTitle(String title) {
		this.title = title;
	}
	
	//a method for setting the terminator
	public void setFinalOption(String finalOption) {
		this.finalOption = finalOption;
	}
	
	//a method for displaying the table
	public void displayMenu() {
		System.out.println("-------------------------------");
		System.out.println(title + "\n" + "Choose from these options");
		System.out.println("-------------------------------");
		for (int i=0; i < numOptions;i++) {
			System.out.println((i+1) + " - " + this.options[i]);
		}
		System.out.println((numOptions+1) + " - " + finalOption);
	}
	
	//method for taking user selection
	public int userSelection(String promptPhrase) {
		System.out.println(promptPhrase);
		choice = In.nextInt();
		return choice;
	}
	
	//method for selecting an entry in a database
	public int itemSelection() {
		int ID = In.nextInt();
		return ID;
	}
	
}