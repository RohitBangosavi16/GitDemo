package Ecommerce.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ecommerce.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent
{
	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div.cartSection h3")
	List<WebElement> products;
	
	@FindBy (css="li.totalRow .btn-primary")
	WebElement checkout;
	
	By findBy=By.cssSelector("div.cartSection h3");
	
	By appearCheckout=By.cssSelector("li.totalRow .btn-primary");
	public List<WebElement> getProductNames(String proName) throws InterruptedException
	{
		waitfortheEleToDisable(findBy);
		return products;
	}
	
	public Boolean getProductDetails(String proName) throws InterruptedException
	{ 	
		waitfortheEle(appearCheckout);
		Boolean bl=false;
		List<WebElement> products=getProductNames(proName);
	
		for(int i=0;i<products.size();i++)
		{
			if(products.get(i).getText().equalsIgnoreCase(proName))
			{
				bl=true;
			}
		}
		return bl;
	}

	public void goToCheckout()
	{
		checkout.click();	
	}
}
