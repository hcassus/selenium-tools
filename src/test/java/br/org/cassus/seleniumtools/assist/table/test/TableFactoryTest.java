package br.org.cassus.seleniumtools.assist.table.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import br.org.cassus.seleniumtools.assist.table.ExplicitHeaderTableAssistant;
import br.org.cassus.seleniumtools.assist.table.HeaderlessTableAssistant;
import br.org.cassus.seleniumtools.assist.table.ImplicitHeaderTableAssistant;
import br.org.cassus.seleniumtools.assist.table.TableAssistFactory;
import br.org.cassus.seleniumtools.assist.table.TableType;

public class TableFactoryTest {
	
	WebElement table;	
	static TableAssistFactory factory;
	
	@BeforeClass
	public static void setupClass(){
		factory = new TableAssistFactory();
	}

	@Test
	public void headerlessAssistTest(){
		Assert.assertTrue(factory.getAssistant(table,TableType.HEADERLESS) instanceof HeaderlessTableAssistant);
	}
	
	@Test
	public void implictHeaderTest(){
		Assert.assertTrue(factory.getAssistant(table,TableType.IMPLICIT_HEADER) instanceof ImplicitHeaderTableAssistant);
	}
	
	@Test
	public void explicitHeaderTest(){
		Assert.assertTrue(factory.getAssistant(table,TableType.EXPLICIT_HEADER) instanceof ExplicitHeaderTableAssistant);
	}
	
	
}
