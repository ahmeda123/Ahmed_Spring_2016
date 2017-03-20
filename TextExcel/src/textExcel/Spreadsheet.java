package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	Cell[][] Spread = new Cell[getRows()][getCols()];
	
	public Spreadsheet() {
		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j < getCols(); j++) {
				Spread[i][j] = new EmptyCell();
			}
		}
	}
	
	@Override
	public String processCommand(String command)
	{
		//if the command contains clear it wants to clear all or one cell
		if (command.contains("clear")) {
			clearCell(command);
		}
		//if the command contains an "=" it wants to assign a new value to a cell
		else if (command.contains("=")) {
			String[] commandParts = command.split(" ");
			newCell(commandParts[0], commandParts[2]);
		}
		//otherwise command is simply an inspection
		else {
			SpreadsheetLocation inspect = new SpreadsheetLocation(command);
			String value = Spread[inspect.getRow()][inspect.getCol()].fullCellText();
			return value;
		}
		return getGridText();
		
		
		//if the command has an operator in it then it wants to assign a value to a cell
	}

	@Override
	public int getRows()
	{
		return 20;
	}

	@Override
	public int getCols() {
		return 12;
	}

	@Override
	public Cell getCell(Location loc)
	{
		return Spread[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText()
	{
		String text = "   |";
		
		//prints the first row
		for (char alphabet = 'A'; alphabet <= 'L'; alphabet++) {
			text = text + alphabet + "         |";
		}
		
		//prints the lines for the rest of the rows
		for (int i = 1; i <= getRows(); i++) {
			text = text + "\n" + i;
			
			if (i < 10) {
				text = text + "  |";
			}
			//double digit rows have one less space
			else {
				text = text + " |";
			}
			
			for (int j = 0; j < getCols(); i++) {
				text += Spread[i - 1][j].abbreviatedCellText();
			}
		}
		text += "\n";
		return text;
	}

	public void clearCell (String cmd) {
		//if length is greater than 5, it wants to clear one cell
		if (cmd.length() > 5) {
			String[] cmdParts = cmd.split(" ");
			SpreadsheetLocation clear = new SpreadsheetLocation(cmdParts[1]);
			Spread[clear.getRow()][clear.getCol()] = new EmptyCell();
		}
		//otherwise clear the whole spreadsheet
		else {
			for (int i = 0; i < getRows(); i++) {
				for (int j = 0; j < getCols(); j++) {
					Spread[i][j] = new EmptyCell();
				}
			}
		}
	}
	
	public void newCell (String cell, String assignment) {
		SpreadsheetLocation newAssignment = new SpreadsheetLocation(cell);
		Spread[newAssignment.getRow()][newAssignment.getCol()] = new TextCell(assignment);
	}
}