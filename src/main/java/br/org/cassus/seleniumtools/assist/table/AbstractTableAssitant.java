package br.org.cassus.seleniumtools.assist.table;

import java.text.MessageFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class AbstractTableAssitant {
	
	public AbstractTableAssitant(WebElement table) {
		this.table = table;
	}
	
	public String getValueByPosition(int row, int column) {
		String xpath = "./tbody/tr[{0}]/td[{1}]";
		String formatted_xpath = MessageFormat.format(xpath, row, column);
		return table.findElement(By.xpath(formatted_xpath)).getText();
	}

	protected WebElement table;
	
	public int countRows() {
		int count = table.findElements(By.xpath("./tbody/tr")).size();
		return count;
	}
	
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
