package br.org.cassus.seleniumtools.assist.table.test;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.org.cassus.seleniumtools.assist.table.ExplicitHeaderTableAssistant;

public class ExplicitHeaderTableAssistTest extends AbstractHeaderTableAssistTest<ExplicitHeaderTableAssistant>{
	
	
	private static WebDriver driver;
	private WebElement table;
	
	public ExplicitHeaderTableAssistTest() {
		super(driver);
		tableLocator = By.id("test_table");
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
		this.tableAssist = new ExplicitHeaderTableAssistant(table);
	}
	
	@AfterClass
	public static void tearDown(){
		driver.quit();
	}
	

}
