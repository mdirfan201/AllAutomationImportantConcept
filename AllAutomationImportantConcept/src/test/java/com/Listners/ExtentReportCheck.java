package com.Listners;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import freemarker.template.SimpleDate;

public class ExtentReportCheck {
	
static WebDriver driver;
	
	
public ExtentHtmlReporter htmlReporter;
public ExtentReports extent;
public ExtentTest extentTest;
	
	@BeforeTest
	public void setExtent() {
		htmlReporter= new ExtentHtmlReporter("MyExtext-Report.html");
		
		htmlReporter.config().setDocumentTitle("Automation Report"); //Title of rport
		htmlReporter.config().setReportName("Function Report"); //name of report
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent =new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Hostname","MY LocalHost PC");
		extent.setSystemInfo("OS","Windos10");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("Tester","Mohammed Irfan");
		extent.setSystemInfo("Browser","Chrome");
	}
	@AfterTest
	public void endReoprt() {
		extent.flush();
		
		
	}
	
	public static String  getScreenshot(WebDriver driver, String FileName) throws IOException {
		String date=new SimpleDateFormat("yyyyMMdd:hhmmss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String dest="D:\\IRFAN---\\java program\\AllAutomationImportantConcept"+FileName+date+".png";
		File finaldest=new File(dest);
		FileUtils.copyFile(src, finaldest);
		return dest;
	}
	@Test
	public void Test2() {
		System.setProperty("webdriver.chrome.driver", "D:\\IRFAN---\\java program\\AllAutomationImportantConcept\\Browser-Driver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("http:www.google.com");	
		System.out.println("The google titile is ==>"+ driver.getTitle());
		Assert.assertEquals(true, false);
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			extentTest.log(Status.FAIL, "TEST CASE FAILED IS "+result.getName());
			extentTest.log(Status.FAIL, "TEST CASE FAILED IS "+result.getThrowable());
			
			String screenshotpath=ExtentReportCheck.getScreenshot(driver, result.getName());
			extentTest.log(Status.FAIL,(Markup) extentTest.addScreencastFromPath(screenshotpath));
		}
		else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(Status.SKIP, "TEST CASE SKIPed IS "+result.getName());
		}
		
		driver.quit();
	}
	
	
}
