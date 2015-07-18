package br.org.cassus.seleniumtools.assist.table;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Defines operations on tables containing headers
 * **/
public abstract class AbstractHeaderTableAssistant extends AbstractTableAssistant implements HeadersTableAssist {
	
	protected Map<String, Integer> colIndexMap;
	/**
	 * A "By" locator that identifies the header column locators 
	 * in order to enable navigating by column names
	 * **/
	protected By headerColLocator = getHeaderColumnLocator();
	
	protected AbstractHeaderTableAssistant(final WebElement table) {
		super(table);
	}


	
	private int getColIndex(final String colName) {
		return colIndexMap.get(colName);
	}
	
	/****
	 * @return a by locator representing all the column header cells
	 */
	protected abstract By getHeaderColumnLocator();

	/**
	 * Retrieves a value by using a column name and value as a reference.	   
	 * @param  referenceCol the name of the column to be used as a reference
	 * @param  referenceVal the value expected to be the reference
	 * @param  actualCol the name of the column to retrieve contents
	 * @return a string with the contents of the cell
	 * **/
	public String getValueByReference(final String refColName, final String referenceVal, final String actualColName) {
		initColumns();
		final int refColIndex = getColIndex(refColName);
		final int actualColIndex = getColIndex(actualColName);
		final int actualRowIndex = getRowIndex(refColIndex,referenceVal);
		return getValueByPosition(actualRowIndex, actualColIndex);
	}
	
	/**
	 * Retrieves the value of a cell by using a column name and line index.
	 * @param  colName the name of the column to have the value retrieved
	 * @param  row the row you want to read
	 * @return a string with the contents of the cell
	 * **/
	public String getValueByColumnAndLine(final String colName,final int row) {
		initColumns();	
		final int colIndex = getColIndex(colName);
		return getValueByPosition(row, colIndex);
	}
	
	protected void initColumns(){
		if(colIndexMap == null){
			colIndexMap = new HashMap<String, Integer>();
			
			final List <WebElement> headers = table.findElements(headerColLocator);
			int index = 1;
			for (final WebElement header : headers) {
				final String text = header.getText();
				colIndexMap.put(text, index);
				index++;
			}
		}
	};
	

	


}
