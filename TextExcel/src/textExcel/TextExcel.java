package textExcel;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
		Spreadsheet Spread = new Spreadsheet();
		Scanner userInput = new Scanner(System.in);
	    String input = userInput.nextLine();
	   //terminates scanner if user types "quit"
	    if (input == "quit") {
	    	userInput.close();
	    }	
	    	else {
	    		Spread.processCommand(input);
	    }
	}
}
