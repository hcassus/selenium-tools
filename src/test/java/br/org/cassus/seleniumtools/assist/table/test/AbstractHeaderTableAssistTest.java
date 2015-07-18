package br.org.cassus.seleniumtools.assist.table.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.org.cassus.seleniumtools.assist.table.AbstractHeaderTableAssistant;

public abstract class AbstractHeaderTableAssistTest<T extends AbstractHeaderTableAssistant> extends AbstractTableAssistTest<AbstractHeaderTableAssistant>{
	
	
	
	public AbstractHeaderTableAssistTest(final WebDriver driver) {
		super(driver);
	}

	@Test
	public void getValueByColumnNameAndRowTest(){
		Assert.assertEquals("jane.doe@gmail.com", tableAssist.getValueByColumnAndLine("E-mail",2));
	}
	
	@Test
	public void getValueByColNameReference(){
		Assert.assertEquals("jack.teller@tellermorrow.com", tableAssist.getValueByReference("User","jack.teller","E-mail"));
	}

}
