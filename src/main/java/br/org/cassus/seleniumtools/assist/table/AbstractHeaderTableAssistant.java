package br.org.cassus.seleniumtools.assist.table;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class AbstractHeaderTableAssistant extends AbstractTableAssitant {
	
	public AbstractHeaderTableAssistant(WebElement table) {
		super(table);
	}

	protected Map<String, Integer> colIndexMap;
	protected By columnLocator = getColumnLocator(); 
	
	private int getColIndex(String colName) {
		return colIndexMap.get(colName);
	}
	
	protected abstract By getColumnLocator();

	public String getValueByReference(String referenceCol, String referenceVal, String actualCol) {
		initColumns();
		int refColIndex = getColIndex(referenceCol);
		int actualColIndex = getColIndex(actualCol);
		int actualRowIndex = getRowIndex(refColIndex,referenceVal);
		return getValueByPosition(actualRowIndex, actualColIndex);
	}
	
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
