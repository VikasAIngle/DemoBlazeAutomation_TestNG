package com.demoblaze.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoblaze.base.TestBase;
import com.demoblaze.pages.CartPage;

public class CartPageTest extends TestBase
{
	CartPage cartPage;
		
	@BeforeMethod
	public void set()
	{
		logger.info("Initiating Cart Page Constructor");
		cartPage = new CartPage();
	}
	
	
	@Test(priority = 0)
	public void goToCart() throws Exception
	{
		logger.info("Go to Cart Page");
		cartPage.goToCart();
		Thread.sleep(5000);
	}
	
		@Test(priority = 1)
		public void validateDeleteItem() throws Exception
		{
		logger.info("Verifying Whether First item is displayed after deleting it");
		Assert.assertFalse(cartPage.firstItemDisplayed());
		}
	
	
	@Test(priority = 2)
	public void valiadteTotalProductPrice()
	{
		logger.info("Verifying whether Total table price shown on page is equal to the sum of price of all items");
		Assert.assertEquals(cartPage.getTableTotalPrice(), cartPage.getTotal());
		
	}
	
	
	
	
}
