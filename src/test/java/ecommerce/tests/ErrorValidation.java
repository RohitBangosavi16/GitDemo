package ecommerce.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Ecommerce.pageobjects.CartPage;
import Ecommerce.pageobjects.ProductCatalogue;
import ecommerce.testcomponents.BaseTest;


public class ErrorValidation extends BaseTest
{
	@Test (groups = {"ErrorHandling"})
	public void loginpgErrorValidation() throws IOException, InterruptedException
	{
		loginPage.loginPageApplication("rht@gmail.com", "Rohit123");
		String prodName="ZARA COAT 3";

		String errmsg=loginPage.getErrorMessage();
		Assert.assertEquals(errmsg, "Incorrectemail or password.");
	}
	@Test (groups = {"ErrorHandling"})
	public void submitOrderErrorValidation() throws IOException, InterruptedException
	{
		
		ProductCatalogue productcatlog=loginPage.loginPageApplication("rhtb@gmail.com", "Rohit@123");
		String prodName="ZARA COAT 3";

		productcatlog.addProductToCart(prodName);
		CartPage cartpage=productcatlog.goToCartPage();
		Boolean match=cartpage.getProductDetails(prodName);
		Assert.assertTrue(match);
		
		
	}


}
