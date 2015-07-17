package br.org.cassus.seleniumtools.assist.table.test;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.org.cassus.seleniumtools.assist.table.HeaderlessTableAssistant;

public class HeaderlessTableAssistTest extends AbstractTableAssistTest<HeaderlessTableAssistant>{
	
	
	private static WebDriver driver;
	private WebElement table;
	
	public HeaderlessTableAssistTest() {
		super(driver);
		tableLocator = By.id("test_table_without_headers");
	}
	
	@BeforeClass
	public static void setupClass(){
		driver = new FirefoxDriver();
		String path = AbstractTableAssistTest.class.getResource("/sample.html").toString();
		driver.get(path);		
	}
	
	@Before
	public void setupTest(){
		this.table = driver.findElement(tableLocator);
		this.tableAssist = new HeaderlessTableAssistant(table);
	}
	
	@AfterClass
	public static void tearDown(){
		driver.quit();
	}

}
