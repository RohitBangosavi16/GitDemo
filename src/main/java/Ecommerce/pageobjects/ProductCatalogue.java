package Ecommerce.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ecommerce.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent
{
	WebDriver driver;
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div.card-body")
	List<WebElement> items;

	@FindBy (xpath = "button:last-child")
	WebElement addProduct;

	By findBy=By.cssSelector("div.card-body");
	By tosterBy=By.cssSelector(".toast-container");
	By cardAddpause=By.cssSelector("div.la-3x");
	public List<WebElement> getProductlist()
	{
		waitfortheEle(findBy);
		return items;
	}

	public WebElement getProductName(String proName)
	{
		WebElement var = items.stream().filter(s->s.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(proName)).findFirst().orElse(null);
	//	var.findElement(By.cssSelector("button:last-child")).click();;
		return var;
	}

	public void addProductToCart(String proName) throws InterruptedException
	{
		WebElement productToAdd=getProductName(proName);
		productToAdd.findElement(By.cssSelector("button:last-child")).click();
		//addProduct.click();
		waitfortheEle(tosterBy);
		waitfortheEleToDisable(cardAddpause);
	}
	
	



}
