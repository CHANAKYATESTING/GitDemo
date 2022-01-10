package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObject {
	
	public WebDriver driver;
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	private By signIn = By.cssSelector("a[href*='sign_in']");
	private By featuredCoursesTitle = By.xpath("//h2[contains(text(),'Featured Courses')]");
	private By contactsLink = By.xpath("//a[normalize-space()='Contact']");
	
	public LoginPageObjects getLogInPage() {
		
		
		
		driver.findElement(signIn).click();
		LoginPageObjects lp = new LoginPageObjects(driver);
		return lp;
	}
	
	public WebElement getFeaturedTitle() {
		return driver.findElement(featuredCoursesTitle);
	}
	public WebElement getContactsLink() {
		return driver.findElement(contactsLink);
	}

}
