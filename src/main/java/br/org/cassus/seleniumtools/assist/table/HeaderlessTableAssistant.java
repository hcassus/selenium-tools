package br.org.cassus.seleniumtools.assist.table;

import org.openqa.selenium.WebElement;

public class HeaderlessTableAssistant extends AbstractTableAssistant {

	/**
	 * HeaderlessTableAssistant should be used whenever you don't have 
	 * any headers on your table and contents start your first row.
	 * 
	 * @param  table the selenium table WebElement you need help dealing with.
	 * **/
	public HeaderlessTableAssistant(final WebElement table) {
		super(table);
	}
}
