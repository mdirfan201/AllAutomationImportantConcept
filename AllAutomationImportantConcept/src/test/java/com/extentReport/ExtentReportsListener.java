package com.extentReport;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsListener {

	public static WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest extentTest;
		
		@BeforeSuite
		public void setExtent() {
			htmlReporter= new ExtentHtmlReporter("MyExtent-Report.html");
			
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
		
		
		
		@Test
		public void Test2() throws IOException {
			
			System.setProperty("webdriver.chrome.driver", "D:\\IRFAN---\\java program\\AllAutomationImportantConcept\\Browser-Driver\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			ExtentTest test=extent.createTest("Create My Firat Extent Report");
			driver.get("http://www.google.cm");	
			test.log(Status.INFO, "This step show usage log info");
			if(driver.getTitle().equals("Eoogle")){
				test.log(Status.FAIL, "TEST CASE fail");
			}else {
				
			}
			
			
		}
				
		
		
}
