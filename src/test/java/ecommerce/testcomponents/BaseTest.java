package ecommerce.testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Files;

import Ecommerce.pageobjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public LoginPage loginPage;

	public WebDriver initializeBrowser() throws IOException
	{
		Properties prop= new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Ecommerce\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");

		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browserName=="edge")
		{
			//edge
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		return driver;
	}

	@BeforeMethod (alwaysRun = true)
	public void launchApplication() throws IOException
	{
		driver= initializeBrowser();
		loginPage=new LoginPage(driver);
		loginPage.goTo();
	}
	
	@AfterMethod (alwaysRun = true)
	public void tearDown()
	{
		driver.close();
	}
	
	public List<HashMap<String, String>> getJasonToHashMap(String jsnFilePath) throws IOException
	{
		//read json and convert to string
		String jasonFile=FileUtils.readFileToString(new File(jsnFilePath), StandardCharsets.UTF_8);
		
		//convert string to map
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String, String>> Data= mapper.readValue(jasonFile, new TypeReference<List<HashMap<String, String>>>() {
		});
		return Data;
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts=	(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		Files.copy(source, new File(System.getProperty("user.dir")+"\\reports"+testCaseName+".png"));
		return System.getProperty("user.dir")+"\\reports"+testCaseName+".png";
	}

	}

