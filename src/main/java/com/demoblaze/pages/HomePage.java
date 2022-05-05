package com.demoblaze.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoblaze.base.TestBase;
import com.demoblaze.util.TestUtil;

public class HomePage extends TestBase
{

	@FindBy(xpath = "//a[text()='Phones']")
	WebElement phones;
	@FindBy(xpath = "//a[text()='HTC One M9']")
	WebElement htcMob;
	
	@FindBy(xpath = "//a[text()='Laptops']")
	WebElement laptops;
	@FindBy(xpath = "//a[text()='MacBook air']")
	WebElement MacLappy;
	
	@FindBy(xpath = "//a[text()='Monitors']")
	WebElement monitors;
	@FindBy(xpath = "//a[text()='ASUS Full HD']")
	WebElement asusDesktop ;
	
	@FindBy(xpath = "//img[@src='bm.png']")
	WebElement logo;
	
	@FindBy(id = "signin2")
	WebElement signUpLink;
	
	@FindBy(id = "login2")
	WebElement loginLink;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean isLogoDisplayed()
	{
		return logo.isDisplayed();
	}
	
	public ProductInfoPage getPhone()
	{
		TestUtil.clickOn(driver, phones);
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		jse.executeScript("arguments[0].scrollIntoView(true);", htcMob);
		
		TestUtil.JSClick(driver, htcMob);
		
		return new ProductInfoPage();
	}
	
	public ProductInfoPage getLappy()
	{
		TestUtil.clickOn(driver, laptops);
		
		TestUtil.clickOn(driver, MacLappy);
		
		return new ProductInfoPage();
	}
	
	
	public ProductInfoPage getMonitor()
	{
		TestUtil.clickOn(driver, monitors);
		TestUtil.clickOn(driver, asusDesktop);
		
		return new ProductInfoPage();
	}
	
	public SignUpPage goToSignUpPage()
	{
		TestUtil.clickOn(driver, signUpLink);	
		
		return new SignUpPage();
	}
	
	
	public LoginPage goToLoginPage()
	{
		TestUtil.JSClick(driver, loginLink);	
		
		return new LoginPage();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
