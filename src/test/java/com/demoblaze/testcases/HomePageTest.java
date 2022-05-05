package com.demoblaze.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoblaze.base.TestBase;
import com.demoblaze.pages.HomePage;
import com.demoblaze.pages.SignUpPage;
import com.demoblaze.util.TestUtil;

public class HomePageTest extends TestBase
{
	HomePage homePage;
	
	@BeforeMethod
	public void set()
	{
		homePage = new HomePage();
		logger.info("Initiating HomePage Contructor");
	}
	
	@Test
	public void verifyTitle()
	{	
		try
		{
		Assert.assertEquals(homePage.validateHomePageTitle(), "STORE");
		logger.info("Title is correct");
		}
		catch(Exception e)
		{
			logger.info("Title is incorrect");
		}
	}
	
	@Test
	public void verifyLogo()
	{	
		logger.warn("Validating Logo of DemoBlaze");
		Assert.assertTrue(homePage.isLogoDisplayed());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
