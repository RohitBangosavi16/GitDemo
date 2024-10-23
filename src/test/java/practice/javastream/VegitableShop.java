package practice.javastream;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VegitableShop 
{
	//@Test   //print price of a vegitable 
	public void getVegetable() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rohit\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

		driver.findElement(By.cssSelector("span.sort-descending")).click();


		//	List <String> originalList=vegName.stream().map(s-> s.getText()).collect(Collectors.toList());
		//List <String> newList=originalList.stream().sorted().collect(Collectors.toList());

		//	Assert.assertEquals(newList, originalList);
		WebElement nextButton=driver.findElement(By.cssSelector("[aria-label='Next']"));
		//	System.out.println(nextButton.isEnabled());
		//	nextButton.click();
		List <String> vegPrice;
		do
		{
			List<WebElement> vegName=driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
			//	Thread.sleep(3000);
			vegPrice=vegName.stream().filter(s->s.getText().equalsIgnoreCase("Rice")).map(s->getPrice(s)).collect(Collectors.toList());
			//	Thread.sleep(3000);
			if(vegPrice.size()<1)
				nextButton.click();
			//			else 
			//				break;
		}while(vegPrice.size()<1);

		vegPrice.forEach(s->System.out.println(s));

		//	List <String> vegPrice=vegName.stream().filter(s->s.getText().equalsIgnoreCase("Rice")).map(s->getPrice(s)).collect(Collectors.toList());)
		//	Thread.sleep(3000);
		driver.close();

	}

	private String getPrice(WebElement s) {
		return s.findElement(By.xpath("following-sibling::td[1]")).getText();

	}

	//@Test //stream operations 
	public void streamMethods()
	{
		List<String> names=Arrays.asList("Rohit","Rahul", "Rohini", "Bhakti", "Chiu");
		//		names.stream().filter(s->s.startsWith("R")).sorted().collect(Collectors.toList()).forEach(s->System.out.println(s));
		//		names.stream().filter(s->s.endsWith("i")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));	
		//		names.stream().filter(s->s.startsWith("R")).limit(2).forEach(s->System.out.println(s));
		//		
		//names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));

		//	List<String> newNames = names.stream().filter(s->s.endsWith("i")).map(s->s.toUpperCase()).collect(Collectors.toList());	
		//
		//	Stream<String> newConcatedList=Stream.concat(names.stream(), newNames.stream());
		//	newConcatedList.forEach(s->System.out.println(s));

		Boolean bl=names.stream().allMatch(s->s.equalsIgnoreCase("Rohit"));
		System.out.println(bl);
	}

	@Test
	public void verifyVegiableSearch()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rohit\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		String vegSerach="Rice";
		WebElement nextButton=driver.findElement(By.cssSelector("[aria-label='Next']"));

		List <String> vegPrice;
		driver.findElement(By.cssSelector("div #search-field")).sendKeys(vegSerach);
		List<WebElement> vegName=driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		//vegName.stream().anyMatch(s->s.getText().equalsIgnoreCase("Rice")).map(s->getPrice(s));
		boolean bl = vegName.stream().anyMatch(s->s.getText().equalsIgnoreCase(vegSerach));
		
		System.out.println(bl);
	
	driver.close();
}
}
