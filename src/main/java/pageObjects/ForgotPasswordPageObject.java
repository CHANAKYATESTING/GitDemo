package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPageObject {

	public WebDriver driver;

	public ForgotPasswordPageObject(WebDriver driver) {
		this.driver = driver;
	}

	private By email = By.id("email");
	
	private By nextBtn = By.cssSelector("input[type='submit']");
	

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	

	public WebElement clickNext() {
		return driver.findElement(nextBtn);

	}

}
