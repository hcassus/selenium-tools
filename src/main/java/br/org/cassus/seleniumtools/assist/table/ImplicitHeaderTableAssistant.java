package br.org.cassus.seleniumtools.assist.table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ImplicitHeaderTableAssistant extends AbstractHeaderTableAssistant {
	
	private int headerLines;
	
	public ImplicitHeaderTableAssistant(WebElement table) {
		super(table);
		this.headerLines = 1;
	}
	
	public ImplicitHeaderTableAssistant(WebElement table, int headerLines) {
		super(table);
		this.headerLines = headerLines;
	}

	@Override
	protected By getColumnLocator() {
		return (By.xpath("./tbody/tr[1]/*"));
	}

	@Override
	public int countRows() {
		return super.countRows()- headerLines;
	}

	@Override
	public String getValueByPosition(int row, int column) {		
		return super.getValueByPosition(row + headerLines, column);
	}
	
	public String getValueByColumnAndLine(String colName, int row){
		return super.getValueByColumnAndLine(colName, row);
	}
	
	@Override
	protected int getRowIndex(int refColIndex, String referenceVal) {
		return super.getRowIndex(refColIndex, referenceVal) - headerLines;
	}

}
