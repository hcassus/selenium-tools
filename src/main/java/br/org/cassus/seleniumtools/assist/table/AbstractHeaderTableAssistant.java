package br.org.cassus.seleniumtools.assist.table;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class AbstractHeaderTableAssistant extends AbstractTableAssistant {
	
	protected AbstractHeaderTableAssistant(WebElement table) {
		super(table);
	}

	protected Map<String, Integer> colIndexMap;
	protected By columnLocator = getColumnLocator(); 
	
	private int getColIndex(String colName) {
		return colIndexMap.get(colName);
	}
	
	protected abstract By getColumnLocator();

	/**
	 * This method is used to retrieve a value by using a column name and value as a reference.
	 * 
	 * The call <b>getValueByReference("Name","John","E-mail")</b> will return the value of column "E-mail" in the row the column "Name" is "John"
	 * 
	 * @param  referenceCol the name of the column to be used as a reference
	 * @param  referenceVal the value expected to be the reference
	 * @param  actualCol the name of the column in which the content needs to be retrieved
	 * 
	 * @return a string with the contents of the cell
	 * **/
	public String getValueByReference(String referenceCol, String referenceVal, String actualCol) {
		initColumns();
		int refColIndex = getColIndex(referenceCol);
		int actualColIndex = getColIndex(actualCol);
		int actualRowIndex = getRowIndex(refColIndex,referenceVal);
		return getValueByPosition(actualRowIndex, actualColIndex);
	}
	
	/**
	 * This method is used to retrieve a value by using a column name and line index.
	 * 
	 * The call <b>getValueByColumnAndLine("Name",2)</b> will return the value of column "Name" in the row number 2.
	 * 
	 * @param  colName the name of the column to have the value retrieved
	 * @param  row the row you want to read
	 * 
	 * @return a string with the contents of the cell
	 * **/
	public String getValueByColumnAndLine(String colName, int row) {
		initColumns();	
		int colIndex = getColIndex(colName);
		return getValueByPosition(row, colIndex);
	}
	
	protected void initColumns(){
		if(colIndexMap == null){
			colIndexMap = new HashMap<String, Integer>();
			
			List <WebElement> headers = table.findElements(columnLocator);
			int index = 1;
			for (WebElement header : headers) {
				String text = header.getText();
				colIndexMap.put(text, index);
				index++;
			}
		}
	};
	

	


}
