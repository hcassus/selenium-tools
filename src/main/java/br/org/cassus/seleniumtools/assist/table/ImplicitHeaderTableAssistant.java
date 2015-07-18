package br.org.cassus.seleniumtools.assist.table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ImplicitHeaderTableAssistant extends AbstractHeaderTableAssistant {
	
	private final int headerLines;
	
	/**
	 * ImplicitHeaderTableAssistant should be used whenever you don't have a "thead" 
	 * element on your table and your first "tbody" row contains the column names.
	 * 
	 * @param  table the selenium table WebElement you need help dealing with.
	 * **/
	public ImplicitHeaderTableAssistant(final WebElement table) {
		super(table);
		this.headerLines = 1;
	}

	@Override
	protected By getHeaderColumnLocator() {
		return By.xpath("./tbody/tr[1]/*");
	}

	@Override
	public int countRows() {
		return super.countRows()- headerLines;
	}

	@Override
	public String getValueByPosition(final int row,final int column) {		
		return super.getValueByPosition(row + headerLines, column);
	}
	
	@Override
	protected int getRowIndex(final int refColIndex, final String referenceVal) {
		return super.getRowIndex(refColIndex, referenceVal) - headerLines;
	}
}
