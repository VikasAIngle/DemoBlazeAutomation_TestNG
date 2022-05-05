package com.demoblaze.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoblaze.base.TestBase;
import com.demoblaze.util.TestUtil;

public class ProductInfoPage extends TestBase
{
	@FindBy(xpath = "//a[text()='Add to cart']")
	WebElement addToCartBtn;
	
	public ProductInfoPage()
	{
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickOnaddToCartBtn()
	{
		TestUtil.JSClick(driver, addToCartBtn);
		
	}
	
	

}
