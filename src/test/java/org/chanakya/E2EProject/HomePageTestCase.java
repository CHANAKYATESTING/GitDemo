package org.chanakya.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPasswordPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObjects;

public class HomePageTestCase extends Base{

	public WebDriver driver;
	private static Logger log = LogManager.getLogger(HomePageTestCase.class.getName());
	@Test(dataProvider="getData")
	public void basePageNavigaton(String uname, String pword) throws IOException {
		//driver = initializeDriver();
		//moved the initialization to before test
		log.info("Going to url https://www.rahulshettyacademy.com/");
		driver.get(prop.getProperty("url"));
		HomePageObject hp = new HomePageObject(driver);
		
		LoginPageObjects lp = hp.getLogInPage();
		log.info("Inside basePageNavigaton");
		lp.getEmail().sendKeys(uname);
		lp.getPassword().sendKeys(pword);
		lp.getSubmit().click();
		ForgotPasswordPageObject fp =lp.getForgotPasswordPage();
		fp.getEmail().sendKeys("chanakyaraju123@gmail.com");
		fp.clickNext().click();
		
		//driver.close();
		
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][]  data = new Object[2][2];
		
		data[0][0] = "chanakyaraju@gmail.com";
		data[0][1] = "chanakyaraju";
		
		data[1][0] = "anu@gmail.com";
		data[1][1] = "chanakyaraju";
		
		return data;
	}
	@BeforeTest
	
	public void init() throws IOException {
		log.info("Initializing the driver");
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
