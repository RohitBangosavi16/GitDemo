package Ecommerce.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ecommerce.AbstractComponents.AbstractComponent;

public class LoginPage extends AbstractComponent
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="div.toast-message")
	WebElement errorMessage;
	
	By errmsgBy=By.cssSelector("div.toast-message");
	public ProductCatalogue loginPageApplication(String useremail, String passwrd)
	{
		userEmail.sendKeys(useremail);
		password.sendKeys(passwrd);
		submit.click();
		ProductCatalogue productcatlog=new ProductCatalogue(driver);
		return productcatlog;
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");

	}
	
	public String getErrorMessage()
	{
		waitfortheEle(errmsgBy);
		return errorMessage.getText();
	}
}
