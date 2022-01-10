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

public class HomePageTestCase2 extends Base{

	public WebDriver driver;
	private static Logger log = LogManager.getLogger(HomePageTestCase2.class.getName());
	
	@BeforeTest
	
	public void init() throws IOException {
		log.info("Initializing the driver");
		driver = initializeDriver();
		log.info("After driver Initialization");
	}
	
	@Test
	public void validateFeaturedTitle() throws IOException {
		driver.get(prop.getProperty("url"));
		log.info("Inside validateFeaturedTitle test");
		HomePageObject hp = new HomePageObject(driver);
			
		System.out.println(hp.getFeaturedTitle().getText());
		Assert.assertEquals(hp.getFeaturedTitle().getText(),"FEATURED COURSES");
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
