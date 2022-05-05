package com.demoblaze.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.demoblaze.base.TestBase;

public class Reporting extends TestListenerAdapter
{	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onStart(ITestContext testContext)
	{
		
		
		String projectWorkingDir = System.getProperty("user.dir");
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()).replace(".", "_");
		sparkReporter = new ExtentSparkReporter(projectWorkingDir+"/test-output/Extent Report/"+timeStamp+".html");
		try 
		{
		sparkReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		}
		catch(IOException e)
		{
			e.getStackTrace();
		}
		
		sparkReporter.config().setDocumentTitle("Automation Report");	// Title of the report
		sparkReporter.config().setReportName("Functional Report");		// Name of the Report
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("HostName", "LocalHost");
		extent.setSystemInfo("OS", "Windows 11");
		extent.setSystemInfo("Automation Tester", "Vikas Ingle");
		extent.setSystemInfo("Browser", "Firefox");
	
	}
	
	public void onTestSuccess(ITestResult tr)
	{
		logger = extent.createTest(tr.getName());	// Creates new Entry in project
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));	// send the passed information to the report with GREEN color highlighted
		
	}
	
	public void onTestFailure(ITestResult tr)
	{
		
		logger = extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));	// send the passed information to the report with RED color highlighted
		
		try
		{
		String screenShotPath = getScreenShot(TestBase.driver, tr.getName());
		
		logger.addScreenCaptureFromPath(screenShotPath);
		logger.log(Status.INFO, tr.getThrowable());
		
		}
		catch(Exception e)
		{
			System.out.println(e.getStackTrace());
		}
		
	}
	
	public void onTestSkipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
	
	public static String getScreenShot(WebDriver driver,String screenShotName) throws IOException
	{
		String dateName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String destination = System.getProperty("user.dir") +"/FailedTestsScreenShots/"+screenShotName+"_"+dateName+".png";
		
		File finalDestination = new File(destination);
		
		FileUtils.copyFile(source, finalDestination);
		
		return destination;
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
