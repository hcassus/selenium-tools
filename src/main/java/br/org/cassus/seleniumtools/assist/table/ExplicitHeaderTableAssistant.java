package br.org.cassus.seleniumtools.assist.table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ExplicitHeaderTableAssistant extends AbstractHeaderTableAssistant {
	
	/**
	 * ImplicitHeaderTableAssistant should be used whenever you have a "thead" element 
	 * on your table and your first "tbody" row has your content.
	 * 
	 * @param  table the selenium table WebElement you need help dealing with.
	 * **/
	public ExplicitHeaderTableAssistant(final WebElement table) {
		super(table);
	}

	@Override
	protected By getHeaderColumnLocator() {
		return By.xpath("./thead/tr/*");
	}

}
