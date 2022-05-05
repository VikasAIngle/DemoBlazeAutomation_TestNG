package com.demoblaze.testcases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoblaze.base.TestBase;
import com.demoblaze.pages.CartPage;
import com.demoblaze.pages.PaymentInfoPage;
import com.demoblaze.util.TestUtil;

public class PaymentInfoPageTest extends TestBase
{

	PaymentInfoPage paymentInfoPage;
	CartPage cartPage;
	Alert alert;
	
	
	
	
	@Test(priority = 0)
	public void verifyPurchaseWithoutInfo()
	{	
		cartPage = new CartPage();
		logger.info("Going to Payment Page");
		paymentInfoPage = cartPage.goToPaymentPage();
		
		logger.info("Click on Purchase Button-->verifyPurchaseWithoutInfo");
		paymentInfoPage.clickPurchaseBtn();
		
		String txt = TestUtil.handleAlert(driver, alert);
		logger.info("Get Pop ups alert text");
		
		logger.info("Verifying Purchase Page without entering any order details");
		Assert.assertEquals(txt, "Please fill out Name and Creditcard.");
	}
	
	@Test(priority = 1)
	public void verifyPurchaseWithInfo()
	{
		logger.info("Send Order details in Payment Page");
		paymentInfoPage.sendDetails();
		
		logger.info("Click on Purchase Button-->verifyPurchaseWithInfo");
		paymentInfoPage.clickPurchaseBtn();
		
		logger.info("Verifying Purchase Page without entering any order details");
		Assert.assertEquals(paymentInfoPage.getSuccessMsg(), "Thank you for your purchase");
		
	}
	
	
	
	
	
	
	
	
	
	
}
