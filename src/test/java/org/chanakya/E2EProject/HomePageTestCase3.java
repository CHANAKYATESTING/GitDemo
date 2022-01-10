package org.chanakya.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;

public class HomePageTestCase3 extends Base{

	public WebDriver driver;
	private static Logger log = LogManager.getLogger(HomePageTestCase3.class.getName());
	@Test
	public void clickContactsLink() {
		driver.get(prop.getProperty("url"));
		log.info("Inside clickContactsLink() test");
		HomePageObject hp = new HomePageObject(driver);
		
		Assert.assertFalse(hp.getContactsLink().isDisplayed());
			
		
	}
	@BeforeTest
	
	public void init() throws IOException {
		log.info("Initializing the driver in HomePageTestCase3");
		driver = initializeDriver();
		log.info("After driver Initialization");
	}
	

	@AfterClass
	public void tearDown() {
		log.info("Inside tearDown() test");
		driver.quit();
	}
	public void finalize() {
		log.info("Inside finalize() test");
		driver.close();
	}
}
