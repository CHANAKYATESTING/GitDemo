package org.chanakya.E2EProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	private static Logger log = LogManager.getLogger(Base.class.getName());
	public static WebDriver driver = null;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		log.info("Fetching file from properties file");

		prop = new Properties();
		// FileInputStream fis = new
		// FileInputStream("C:\\Users\\Chanakya\\Testing\\Automation_Selenium\\eclipse-workspace\\E2EProject\\resources\\data.properties");
		// getting the project path from system property
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\resources\\data.properties");

		prop.load(fis);

		// Use this if you're getting the browser value from properties file
		String browserName = prop.getProperty("browser");
		// Use this if you're getting the browser value from jenkins or Maven command
		// line
		// eg:- mvn test -Dbrowser=chrome

		// String browserName = System.getProperty("browser");
		String chromeDriver = prop.getProperty("chrome.driver");
		String chromePath = prop.getProperty("chrome.driver.path");

		if (browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\resources\\Drivers\\chromedriver.exe");
			System.out.println(browserName + " is opened");
			// System.out.println("Chrome driver " +chromeDriver + " is selected at "+
			// chromePath);
			log.info("Setting chrome driver property");

			// System.setProperty("webdriver.chrome.driver",
			// "C:\\Users\\Chanakya\\Testing\\Automation_Selenium\\Drivers\\chromedriver.exe");
			// System.getProperty("user.dir")+"\\resources\\
			// System.setProperty(chromeDriver, chromePath);
			driver = new ChromeDriver();
		} else if (browserName.equals("chromeheadless")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\resources\\Drivers\\chromedriver.exe");
			System.out.println(browserName + " is opened");
			// System.out.println("Chrome driver " +chromeDriver + " is selected at "+
			// chromePath);
			log.info("Setting chrome driver property");
			ChromeOptions ch = new ChromeOptions();

			ch.addArguments("headless");

			// System.setProperty("webdriver.chrome.driver",
			// "C:\\Users\\Chanakya\\Testing\\Automation_Selenium\\Drivers\\chromedriver.exe");
			// System.getProperty("user.dir")+"\\resources\\
			// System.setProperty(chromeDriver, chromePath);
			driver = new ChromeDriver(ch);
		} else if (browserName.equals("firefox")) {

			log.info("Setting firefox driver property");
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\resources\\Drivers\\geckodriver.exe");
			// System.setProperty(chromeDriver, chromePath);
			driver = new FirefoxDriver();
		} else if (browserName.equals("edge")) {

			/* set edge browser details */
		} else {
			System.out.println("No browser Selected. Please select a valid browser");
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;

	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String imageDestPathName = System.getProperty("user.dir") + "\\reports\\screenshots\\" + testCaseName + ".png";

		FileUtils.copyFile(source, new File(imageDestPathName));
		return imageDestPathName;
	}
}
