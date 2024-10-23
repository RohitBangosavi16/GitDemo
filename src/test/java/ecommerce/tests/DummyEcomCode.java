package ecommerce.tests;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Ecommerce.pageobjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DummyEcomCode {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		LoginPage loginPage=new LoginPage(driver);
		loginPage.goTo();
		loginPage.loginPageApplication("rht@gmail.com", "Rohit@123");
		String proName="IPHONE 13 PRO";

		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.card-body")));
		List<WebElement> items=driver.findElements(By.cssSelector("div.card-body"));

		WebElement var = items.stream().filter(s->s.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(proName)).findFirst().orElse(null);
		var.findElement(By.cssSelector("button:last-child")).click();;
	/*	System.out.println(items.get(0).getText());
		for(int i=0;i<items.size();i++)
		{
			System.out.println(items.get(i).getText());
			if(items.get(i).getText().contains(proName))
			{
				driver.findElements(By.xpath("//div /button[2]")).get(i).click();
			}
		}
		//	Thread.sleep(1000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-container")));
		System.out.println(driver.findElement(By.cssSelector(".toast-container")).getText());
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector("div.la-3x"))));
		//		Thread.sleep(3000);
		driver.findElement(By.cssSelector("button[routerlink*='cart'] i.fa")).click();

		List<WebElement> products=driver.findElements(By.cssSelector("div.cartSection h3"));
		//Boolean bl=products.stream().anyMatch(product->product.getText().equalsIgnoreCase(proName));
		Boolean bl=false;
		for(int i=0;i<products.size();i++)
		{
			if(products.get(i).getText().equalsIgnoreCase(proName))
			{
				bl=true;
			}
		}
		Assert.assertTrue(bl);
		driver.findElement(By.cssSelector("li.totalRow .btn-primary")).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.form-group .input")));
		driver.findElement(By.cssSelector("div.form-group .input")).sendKeys("ind");

		List<WebElement> countryList=driver.findElements(By.cssSelector("button.ta-item"));
		for(int i=0;i<countryList.size();i++)
		{
			if(countryList.get(i).getText().equalsIgnoreCase("india"))
			{
				countryList.get(i).click();
				break;
			}
		}
	*/	Thread.sleep(3000);

		driver.close();
	}

}

