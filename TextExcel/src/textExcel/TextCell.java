package textExcel;

public class TextCell implements Cell {
	private String text;
	
	public TextCell (String text) {
		this.text = text;
	}
	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		if (text.length() > 10) {
			String abbreviatedText = text.substring(0, 11);
			return abbreviatedText;
		}
		
		else {
			return text;
		}
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return text;
	}

}
