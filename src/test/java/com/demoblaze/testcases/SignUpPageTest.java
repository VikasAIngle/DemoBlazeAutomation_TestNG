package com.demoblaze.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoblaze.base.TestBase;
import com.demoblaze.pages.HomePage;
import com.demoblaze.pages.SignUpPage;
import com.demoblaze.util.TestUtil;

public class SignUpPageTest extends TestBase
{
   SignUpPage signUpPage;
   Alert alert;
   HomePage homePage;
   
	@BeforeMethod
	public void set()
	{
		homePage = new HomePage();
		logger.info("Going to Sign Up Page");	
		signUpPage = homePage.goToSignUpPage();	// Clicking on Sign Up link
	}
	
	
	@Test()
	public void registerUser()
	{
		String pwd = TestUtil.randomString();	// Creating random string for username and password
		String un = pwd+"@gmail.com";
		
		logger.info("Registering new user on DemozBlaze "+"User: "+un);
		signUpPage.signUp(un, pwd);
		
		String txt = TestUtil.handleAlert(driver, alert);	// Handling expected alert
		
		try
		{
		Assert.assertEquals(txt,"Sign up successful.");		// Validating pop up's message
		logger.info("New User successfully created");
		}
		catch(Exception e)
		{
			logger.info("Failed to create new User");
		}
		
	}
		

	
	
}
