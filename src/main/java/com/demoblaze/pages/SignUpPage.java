package com.demoblaze.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoblaze.base.TestBase;
import com.demoblaze.util.TestUtil;

public class SignUpPage extends TestBase
{
	@FindBy(id = "sign-username")
	WebElement sUsername;
	
	@FindBy(id = "sign-password")
	WebElement sPassword;
	
	
	
	@FindBy(xpath = "//button[text()='Sign up']")
	WebElement signUpBtn;
	
	public SignUpPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	
	public void signUp(String un, String pwd)
	{
		
		TestUtil.sendKeys(driver, sUsername, un);
		TestUtil.sendKeys(driver, sPassword, pwd);
		
		TestUtil.JSClick(driver, signUpBtn);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
