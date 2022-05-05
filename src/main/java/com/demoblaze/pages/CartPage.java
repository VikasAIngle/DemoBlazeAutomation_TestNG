package com.demoblaze.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoblaze.base.TestBase;
import com.demoblaze.util.TestUtil;

public class CartPage extends TestBase
{

	@FindBy(xpath = "(//td[2])[1]")
	WebElement FirstItem;
	
	@FindBy(xpath = "(//a[text()='Delete'])[1]")
	WebElement deleteFirstItem;
	
	@FindBy(xpath = "//button[text()='Place Order']")
	WebElement placeOrderBtn;
	
	@FindBy(id = "totalp")
	WebElement total;
	
	@FindBy(xpath = "//a[text()='Cart']")
	WebElement cartLink;
	
	public CartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean firstItemDisplayed() throws Exception
	{
		String FirstitemName = FirstItem.getText();
		
		System.out.println(FirstitemName);
		
		TestUtil.JSClick(driver, deleteFirstItem);
		
		Thread.sleep(5000);
		
		String pageSource  = driver.getPageSource();
		
//		System.out.println(pageSource);
		
		return pageSource.contains(FirstitemName);
	}
	
	public int getTableTotalPrice()
	{
		List<WebElement> allItemPrice = driver.findElements(By.xpath("//td[3]"));
		
		int tableTotal = 0;
		
		for(WebElement item: allItemPrice)
		{
			tableTotal+=Integer.parseInt(item.getText());
		}
		
		return tableTotal;
		
	}
	
	public int getTotal()
	{
		
		return Integer.parseInt(total.getText());	
	}
	
	
	public void goToCart()
	{
		TestUtil.clickOn(driver, cartLink);
	}
	
	
	public PaymentInfoPage goToPaymentPage()
	{
		
		TestUtil.clickOn(driver, placeOrderBtn);
		
		return new PaymentInfoPage();
	}
	
	
}
