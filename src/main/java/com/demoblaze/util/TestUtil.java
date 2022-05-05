package com.demoblaze.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestUtil 
{
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	public static void explicitWait(WebDriver driver, int Seconds, WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Seconds));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static void JSClick(WebDriver driver, WebElement ele)
	{
		TestUtil.explicitWait(driver, 10, ele);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", ele);
		
	}
	
	
	public static void sendKeys(WebDriver driver, WebElement ele, String txt)
	{
		TestUtil.explicitWait(driver, 10, ele);
		ele.clear();
		ele.sendKeys(txt);
	}
	
	public static void clickOn(WebDriver driver, WebElement ele)
	{
		TestUtil.explicitWait(driver, 10, ele);
		ele.click();
	}
	
	public static String handleAlert(WebDriver driver,Alert alert)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();
		String alertTxt = alert.getText();
		alert.accept();
		
		return alertTxt;
	}
	
	public static String randomString()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(8);
		return generatedString;
	}
	
	
	public static String[][] getDataFromXL() throws Exception
	{
		
		File xlFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\demoblaze\\testdata\\LoginData.xlsx");
		
		FileInputStream fis = new FileInputStream(xlFile);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		XSSFRow row;
		XSSFCell cell;
		int totalRows = sheet.getLastRowNum();
		int totalCols = sheet.getRow(1).getLastCellNum();
		
		
		String[][] tabArray = new String[totalRows][totalCols];
		
		for(int r=1, i = 0;r<=totalRows;r++, i++)
		{
			row = (XSSFRow)sheet.getRow(r);
			for(int c=0, j=0;c<totalCols;c++, j++)
			{
				cell = row.getCell(c);
				tabArray[i][j] = cell.getStringCellValue();
			
			}
		}
		
		
		
		return tabArray;
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
