package br.org.cassus.seleniumtools.assist.table.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.org.cassus.seleniumtools.assist.table.AbstractTableAssistant;

public abstract class AbstractTableAssistTest<T extends AbstractTableAssistant> {
	
	T tableAssist;
	static WebDriver driver;
	protected By tableLocator;
	
	public AbstractTableAssistTest(WebDriver driver) {
		AbstractTableAssistTest.driver = driver;
	}
	
	@Test
	public void lineCountTest() {
		Assert.assertEquals(3, tableAssist.countRows());
	}
	
	@Test
	public void getValueByPositionTest(){
		Assert.assertEquals("Teller", tableAssist.getValueByPosition(3,2));
	}
	
	@Test
	public void getValueByColIndexReference(){
		Assert.assertEquals("jack.teller@tellermorrow.com", tableAssist.getValueByReference(3,"jack.teller",4));
	}

}
