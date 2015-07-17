package br.org.cassus.seleniumtools.assist.table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ImplicitHeaderTableAssistant extends AbstractHeaderTableAssistant {
	
	private int headerLines = 1;
	
	/**
	 * ImplicitHeaderTableAssistant should be used whenever you don't have a "thead" element on your table and your first "tbody" row contains the column names.
	 * 
	 * @param  table the selenium table WebElement you need help dealing with.
	 * **/
	public ImplicitHeaderTableAssistant(WebElement table) {
		super(table);
	}

	@Override
	protected By getColumnLocator() {
		return By.xpath("./tbody/tr[1]/*");
	}

	@Override
	public int countRows() {
		return super.countRows()- headerLines;
	}

	@Override
	public String getValueByPosition(int row, int column) {		
		return super.getValueByPosition(row + headerLines, column);
	}
	
	@Override
	protected int getRowIndex(int refColIndex, String referenceVal) {
		return super.getRowIndex(refColIndex, referenceVal) - headerLines;
	}
}
