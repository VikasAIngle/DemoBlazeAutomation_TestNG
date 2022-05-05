package com.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoblaze.base.TestBase;
import com.demoblaze.util.TestUtil;

public class PaymentInfoPage extends TestBase
{

	@FindBy(id = "name")
	WebElement name;
	
	@FindBy(id = "country")
	WebElement country;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id = "card")
	WebElement card;
	
	@FindBy(id = "month")
	WebElement month;
	
	
	@FindBy(id = "year")
	WebElement year;
	
	@FindBy(xpath="//button[text()='Purchase']")
	WebElement purchaseBtn;
	
	
	public PaymentInfoPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void sendDetails()
	{
		
		TestUtil.sendKeys(driver, name, prop.getProperty("username"));
		TestUtil.sendKeys(driver, country, "India");
		TestUtil.sendKeys(driver, city, "Aurangabad");
		TestUtil.sendKeys(driver, card, "123456789012");
		TestUtil.sendKeys(driver, month, "June");
		TestUtil.sendKeys(driver, year, "2022");
		
		
	}
	
	
	public void clickPurchaseBtn()
	{
		TestUtil.JSClick(driver, purchaseBtn);
	}
	
	public String getSuccessMsg()
	{
		String msg = driver.findElement(By.xpath("//h2[text()='Thank you for your purchase!']")).getText();
		
		return msg;
		
	}
	
	
	
	
}
