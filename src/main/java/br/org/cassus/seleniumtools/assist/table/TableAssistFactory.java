package br.org.cassus.seleniumtools.assist.table;

import org.openqa.selenium.WebElement;

/**
 * Factory class that returns the correct assistant for each kind of table.
 */
public class TableAssistFactory {
	/**
	 * Returns the assistant based on the type of the table.
	 * In order to benefit from header operations <b>TableAssist</b> can be cast 
	 * to HeadersTableAssist for <b>EXPLICIT_HEADER</b> and <b>IMPLICIT_HEADER</b> tables
	 * @param table selenium WebElement that represents the table
	 * @param type the type of table to interact with
	 */
	public TableAssist getAssistant(final WebElement table,final TableType type){
		TableAssist assist=null;
		if(type == TableType.EXPLICIT_HEADER){
			assist = new ExplicitHeaderTableAssistant(table);
		} else if (type == TableType.IMPLICIT_HEADER) {
			assist = new ImplicitHeaderTableAssistant(table);
		} else if (type == TableType.HEADERLESS){
			assist = new HeaderlessTableAssistant(table);
		}
		
		return assist;
	}
	
}
