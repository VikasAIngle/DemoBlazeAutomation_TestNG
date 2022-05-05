package com.demoblaze.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.demoblaze.pages.LoginPage;
import com.demoblaze.util.BrowserFactory;
import com.demoblaze.util.TestUtil;

public class TestBase
{
	
	public static WebDriver driver;
	public static Properties prop= new Properties();
	public static String current_project_dir;
	public LoginPage loginPage;
	public static Logger logger;
	
	
	public TestBase()
	{
		try
		{
			current_project_dir=System.getProperty("user.dir");
			File propFile = new File(current_project_dir+"\\src\\main\\java\\com\\demoblaze\\config\\config.properties");
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
			
			
		}
		catch(IOException e)
		{
			e.getMessage();
			e.getStackTrace();
		}
		
	}
	
	
	public static void initialazation()
	{
		String browserName = prop.getProperty("browser");
		
		logger = Logger.getLogger("DemoBlaze Automation");
		PropertyConfigurator.configure(current_project_dir+"/src/main/resources/log4j.properties");
		
		driver = BrowserFactory.checkBrowser(driver, current_project_dir,browserName);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		
		driver.get(prop.getProperty("url"));
		
	}
	
	@BeforeSuite
	public void setUp()
	{
		
		initialazation();
		loginPage = new LoginPage();
		
	}
	
	@AfterSuite
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
