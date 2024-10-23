package ecommerce.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import Ecommerce.pageobjects.CartPage;
import Ecommerce.pageobjects.OrderPage;
import Ecommerce.pageobjects.ProductCatalogue;
import ecommerce.testcomponents.BaseTest;

public class Ecommerce extends BaseTest {

	@Test (dataProvider = "getData", groups = {"Purchase"})
	//public void submitOrder(String email,String pass, String prodName) throws IOException, InterruptedException
	// commented all are by using normal dataprovider object 2d arry
	//replaced by Hashmap dataprovider
	public void submitOrder(HashMap<String,String> input) throws InterruptedException
	{

		//ProductCatalogue productcatlog=loginPage.loginPageApplication("rht@gmail.com", "Rohit@123");
		ProductCatalogue productcatlog=loginPage.loginPageApplication(input.get("email"),input.get("pass"));
		//productcatlog.addProductToCart(prodName);
		productcatlog.addProductToCart(input.get("product"));
		CartPage cartpage=productcatlog.goToCartPage();
		//Boolean match=cartpage.getProductDetails(prodName);
		Boolean match=cartpage.getProductDetails(input.get("product"));
		Assert.assertTrue(match);
	}


	//	@Test (dependsOnMethods = {"submitOrder"})
	public void verifyOrder() throws InterruptedException
	{
		String prodName="ZARA COAT 3";
		ProductCatalogue productcatlog=loginPage.loginPageApplication("rht@gmail.com", "Rohit@123");
		OrderPage orderpg= productcatlog.goToOrderPage();

		//System.out.println(orderpg.getProductDetails(prodName));
		Assert.assertTrue(orderpg.getProductDetails(prodName));
	}

	@DataProvider

	public Object [][] getData() throws IOException
	{
		List<HashMap<String, String>> data=getJasonToHashMap(System.getProperty("user.dir")+"\\src\\test\\java\\ecommerce\\dataprov\\PropductOrder.json");

		return new Object [][] {{data.get(0)},{data.get(1)}};
		
	}
	/*@DataProvider

	public Object [][] getData()
	{
		HashMap<String,String> DataHash=new HashMap<String,String>();
		DataHash.put("email", "rht@gmail.com");
		DataHash.put("pass", "Rohit@123");
		DataHash.put("product", "IPHONE 13 PRO");

		HashMap<String,String> DataHash1=new HashMap<String,String>();
		DataHash1.put("email", "rht@gmail.com");
		DataHash1.put("pass", "Rohit@123");
		DataHash1.put("product", "IPHONE 13 PRO");

		return new Object [][] {{DataHash},{DataHash1}};
		//for without using hashmap
		//return new Object[][] {{"rht@gmail.com","Rohit@123","ZARA COAT 3"},{"rhtb@gmail.com", "Rohit@123","IPHONE 13 PRO"}};
	}*/
	
	
}
