package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
		Spreadsheet[][] 1 = new Spreadsheet[getRows()][getCols()];
		Scanner userInput = new Scanner(System.in);
	    String input = userInput.nextLine();
	   //terminates scanner if user types "quit"
	    if (input == "quit") {
	    	userInput.close();
	    }	
	    	else {
	    		1.processCommand(input);	
	    }
	}
}
