package br.org.cassus.seleniumtools.assist.table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ExplicitHeaderTableAssistant extends AbstractHeaderTableAssistant {
	
	public ExplicitHeaderTableAssistant(WebElement table) {
		super(table);
	}
	


	@Override
	protected By getColumnLocator() {
		return By.xpath("./thead/tr/*");
	}

}
