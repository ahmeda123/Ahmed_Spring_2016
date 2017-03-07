package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	
	private String location;
	private int row;
	private int col;
	
    @Override
    public int getRow()
    {
    	this.row = Integer.parseInt(location.substring(1));
    	return this.row - 1;
    }

    @Override
    public int getCol()
    {
    	this.col = location.charAt(0);
    	return this.col - 65;
    }
  
    
    public SpreadsheetLocation(String cellName)
    {
    this.location = cellName;
    }

}
