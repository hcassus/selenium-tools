package br.org.cassus.seleniumtools.assist.table;

import java.text.MessageFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class AbstractTableAssistant implements TableAssist {
	protected final WebElement table;

	protected AbstractTableAssistant(final WebElement table) {
		this.table = table;
	}
	
	/**
	 * Retrieve a value by using a column and row index.
	 * @param  row the index of the row
	 * @param  column the index of the column
	 * @return a string with the contents of the cell
	 * **/
	public String getValueByPosition(final int row, final int column) {
		final String formattedXpath = MessageFormat.format("./tbody/tr[{0}]/td[{1}]", row, column);
		final WebElement cell = table.findElement(By.xpath(formattedXpath)); 
		return cell.getText();
	}

	
	
	/**
	 * @return an integer representing the number of rows in the table
	 * **/
	public int countRows() {
		 final List<WebElement> rows = table.findElements(By.xpath("./tbody/tr"));
		 return rows.size();
	}
	
	/** Retrieve a value by using a column index and value as a reference.
	 * @param  referenceColumnIndex the index of the column to be used as a reference
	 * @param  referenceVal the value expected to be the reference
	 * @param  actualColumnIndex the index of the column that contains the content
	 * @return a string with the contents of the cell
	 * **/
	public String getValueByReference(final int refColIndex, final String referenceVal, final int actualColIndex) {
		final int actualRowIndex = getRowIndex(refColIndex,referenceVal);
		return getValueByPosition(actualRowIndex, actualColIndex);
	}

	protected int getRowIndex(final int refColIndex, final String referenceVal) {
		final List<WebElement> rows = table.findElements(By.xpath("./tbody/tr"));
		int rownum = 0;
		for (final WebElement row : rows) {
			rownum++;
			final WebElement cell = row.findElement(By.xpath("./td["+refColIndex+"]"));
			final String text = cell.getText();
			if(text.equals(referenceVal)){
				break;
			}
		
		}
		return rownum;
	}
	

		

}
