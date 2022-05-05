package com.demoblaze.testcases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoblaze.base.TestBase;
import com.demoblaze.pages.CartPage;
import com.demoblaze.pages.HomePage;
import com.demoblaze.pages.ProductInfoPage;
import com.demoblaze.util.TestUtil;

public class ProductInfoPageTest extends TestBase
{
	ProductInfoPage phone;
	ProductInfoPage lappy;
	ProductInfoPage monitor;
	ProductInfoPage prod;
	
	HomePage homePage;
	CartPage cartPage;
	
	Alert alert;
	String alertTxt;
	
	@BeforeMethod
	public void set()
	{
		driver.get(prop.getProperty("url"));
		homePage = new HomePage();
	}
	
	
	
	@Test(groups = {"ProductInfoPageTest.addProduct"})
	public void selectPhone() throws Exception
	{
		phone = homePage.getPhone();
		phone.clickOnaddToCartBtn();
		
		Thread.sleep(2000);
		
		alertTxt = TestUtil.handleAlert(driver, alert);
		
		Assert.assertEquals(alertTxt, "Product added.");
		
	
	}
	
	@Test(groups = {"ProductInfoPageTest.addProduct"})
	public void selectLappy() throws Exception
	{
		lappy = homePage.getLappy();
		lappy.clickOnaddToCartBtn();
		
		Thread.sleep(2000);
		
		alertTxt = TestUtil.handleAlert(driver, alert);
		
		Assert.assertEquals(alertTxt, "Product added.");
		
	}
	
	@Test(groups = {"ProductInfoPageTest.addProduct"})
	public void selectMonitor() throws Exception
	{
		monitor = homePage.getMonitor();
		monitor.clickOnaddToCartBtn();
		
		Thread.sleep(2000);
		
		alertTxt = TestUtil.handleAlert(driver, alert);
		
		Assert.assertEquals(alertTxt, "Product added.");
		
	}
	
	
	
	
	
	
	
	
	
}
