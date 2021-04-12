package com.extentReport;

import java.awt.Desktop;
import java.awt.RenderingHints.Key;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentreportScreenshot {

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
	
	@AfterSuite
	public void endReoprt() throws IOException {
		extent.flush();
		Desktop.getDesktop().browse(new File("MyExtent-Report.html").toURI());
		
	}
	@Test
	public void attachedscreenshot() throws IOException {
		ExtentTest test=extent.createTest("Create My First Extent Report");
		System.setProperty("webdriver.chrome.driver", "D:\\IRFAN---\\java program\\AllAutomationImportantConcept\\Browser-Driver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		test.pass("Browser opedned");
		
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Automation", Keys.ENTER);
		//test.pass("Value enterd", MediaEntityBuilder.createScreenCaptureFromPath(getscreenshotpath()).build());
		test.pass("Valued Entered", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		
		test.pass("test finished");
	}
	
	public String getscreenshotpath() throws IOException {
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"/screenshot/Imagename.png";
		FileUtils.copyFile(source, new File(path));
		return path;
	}
	
	public String getBase64() {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	}
}
