package Ecommerce.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ecommerce.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent
{
	WebDriver driver;
	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

		
	@FindBy (css="[routerlink*='myorders']")
	WebElement orderpg;
	
	@FindBy (css="tr td:nth-child(3)")
	List <WebElement> orderProdNames;
	
	By orderedProdList =By.cssSelector("tr td:nth-child(3)");
	
	public List<WebElement> getOrderedProdNames(String proName) throws InterruptedException
	{
		waitfortheEleToDisable(orderedProdList);
		return orderProdNames;
	}
	
	public Boolean getProductDetails(String proName) throws InterruptedException
	{ 	
	//	waitfortheEle(appearCheckout);
		Boolean bl=false;
		List<WebElement> orderedProducts=getOrderedProdNames(proName);
	
		for(int i=0;i<orderedProducts.size();i++)
		{
			if(orderedProducts.get(i).getText().equalsIgnoreCase(proName))
			{
				bl=true;
			}
		}
		return bl;
	}

}
