package Ecommerce.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Ecommerce.pageobjects.CartPage;
import Ecommerce.pageobjects.OrderPage;

public class AbstractComponent 
{
	WebDriver driver;
	public AbstractComponent(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy (css="button[routerlink*='cart'] i.fa")
	WebElement goToCart;
	
	@FindBy (css="[routerlink*='myorders']")
	WebElement goToOrders;
	

	public void waitfortheEle(By findBy)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void waitfortheEleToDisable(By findBy) throws InterruptedException
	{
		Thread.sleep(3000);
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}

	public CartPage goToCartPage()
	{
		goToCart.click();
		CartPage cartpage=new CartPage(driver);
		return cartpage;
	}

	public OrderPage goToOrderPage()
	{
		goToOrders.click();
		OrderPage orderpg=new OrderPage(driver);
		return orderpg;
	}

}
