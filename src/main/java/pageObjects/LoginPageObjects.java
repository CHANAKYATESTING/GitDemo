package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects {

	public WebDriver driver;

	public LoginPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	private By email = By.cssSelector("[type='email']");
	private By password = By.cssSelector("[type='password']");
	private By logInSubmitBtn = By.cssSelector("[name='commit']");
	private By forgotPassword = By.cssSelector("a[href*='forgot']");

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getSubmit() {
		return driver.findElement(logInSubmitBtn);
	}

	public ForgotPasswordPageObject getForgotPasswordPage() {
		ForgotPasswordPageObject fp = new ForgotPasswordPageObject(driver);
	
		driver.findElement(forgotPassword).click();
		return fp;
		
		
	}

}
