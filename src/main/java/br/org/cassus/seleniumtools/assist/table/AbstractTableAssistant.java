package br.org.cassus.seleniumtools.assist.table;

import java.text.MessageFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class AbstractTableAssistant {
	
	protected AbstractTableAssistant(WebElement table) {
		this.table = table;
	}
	
	/**
	 * This method is used to retrieve a value by using a column and row index.
	 * 
	 * The call <b>getValueByPosition(1,2)</b> will return the value of column 2 and the row number 1.
	 * 
	 * @param  row the index of the row
	 * @param  column the index of the column
	 * 
	 * @return a string with the contents of the cell
	 * **/
	public String getValueByPosition(int row, int column) {
		String xpath = "./tbody/tr[{0}]/td[{1}]";
		String formatted_xpath = MessageFormat.format(xpath, row, column);
		return table.findElement(By.xpath(formatted_xpath)).getText();
	}

	protected WebElement table;
	
	/**
	 * @return an integer representing the number of rows in the table
	 * **/
	public int countRows() {
		int count = table.findElements(By.xpath("./tbody/tr")).size();
		return count;
	}
	
	/**
	 * This method is used to retrieve a value by using a column index and value as a reference.
	 * 
	 * The call <b>getValueByReference(1,"John",2)</b> will return the value of column 2 in the row the first column is "John"
	 * 
	 * @param  referenceColumnIndex the index of the column to be used as a reference
	 * @param  referenceVal the value expected to be the reference
	 * @param  actualColumnIndex the index of the column in which the content needs to be retrieved
	 * 
	 * @return a string with the contents of the cell
	 * **/
	public String getValueByReference(int referenceColumnIndex, String referenceVal, int actualColumnIndex) {
		int refColIndex = referenceColumnIndex;
		int actualColIndex = actualColumnIndex;
		int actualRowIndex = getRowIndex(refColIndex,referenceVal);
		return getValueByPosition(actualRowIndex, actualColIndex);
	}

	protected int getRowIndex(int refColIndex, String referenceVal) {
		List<WebElement> rows = table.findElements(By.xpath("./tbody/tr"));
		int rownum = 0;
		for (WebElement row : rows) {
			rownum++;
			String text = row.findElement(By.xpath("./td["+refColIndex+"]")).getText();
			if(text.equals(referenceVal)){
				break;
			}
		
		}
		return rownum;
	}
	

		

}
