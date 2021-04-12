package com.Listners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

@Listeners(CustomListeners.class)
public class TakeFailureOnluScreeShots {

	static WebDriver driver;

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	static Logger log = Logger.getLogger(TakeFailureOnluScreeShots.class);

	@BeforeSuite
	public void setup() {
		htmlReporter = new ExtentHtmlReporter("MyFirstExtentReport.html");
		
		htmlReporter.config().setEncoding("utf-8	");
		htmlReporter.config().setDocumentTitle("Automation Report"); // Title of rport
		htmlReporter.config().setReportName("Function Report"); // name of report
		htmlReporter.loadXMLConfig("D:\\IRFAN---\\java program\\AllAutomationImportantConcept\\extent-config.xml");
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(	htmlReporter);
		extent.setSystemInfo("Hostname", "MY LocalHost PC");
		extent.setSystemInfo("OS", "Windos10");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester", "Mohammed Irfan");
		extent.setSystemInfo("Browser", "Chrome");
	}

	@AfterSuite
	public void endReport() throws IOException {
		extent.flush();
		Desktop.getDesktop().browse(new File("MyFirstExtentReport.html").toURI());
	}

	@Test
	public void TestCaseFailureScreenShots1() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\IRFAN---\\java program\\AllAutomationImportantConcept\\Browser-Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");

		ExtentTest test = extent.createTest("Successful Test");
		test.log(Status.INFO, "This step show usage log info");
		test.log(Status.FAIL, "Test CaseFail");

		Actions action = new Actions(driver);

		WebElement logimMove = driver.findElement(By.xpath("//a[@id='ctl00_HyperLinkLogin']"));
		action.moveToElement(logimMove).build().perform();
		Thread.sleep(3000);
		action.moveToElement(driver.findElement(By.linkText("SpiceClub Members"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign up")).click();
		Thread.sleep(3000);

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		String titel1 = driver.getTitle();
		System.out.println("The Loging Page Title is=====>" + titel1);
		System.out.println();
		WebElement Title = driver.findElement(By.xpath("//select[@id='CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_DropDownListTitle']"));
		Select select = new Select(Title);
		// select.selectByValue("MR");
		// select.selectByIndex(1);
		select.selectByVisibleText("MR");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		WebElement txtUsername = driver
				.findElement(By.id("CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TextBoxFirstName"));
		String typeValue = txtUsername.getAttribute("type");
		System.out.println("Value of type attribute: " + typeValue);

		String typeIndex = txtUsername.getAttribute("tabindex");
		System.out.println("Index of type attribute:=== " + typeIndex);

//		String text=JOptionPane.showInputDialog("Enter the captcha");
//		WebElement txtUsername1= driver.findElement(By.id("CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TextBoxFirstName"));
//		txtUsername1.sendKeys(text);

		Actions builder = new Actions(driver);
		Action seriesOfActions = builder.moveToElement(txtUsername).click().keyDown(txtUsername, Keys.SHIFT)
				.sendKeys(txtUsername, "mohammed irfanulah").keyUp(txtUsername, Keys.SHIFT).doubleClick(txtUsername)
				// .contextClick()
				// .sendKeys(Keys.ENTER)
				.build();
		seriesOfActions.perform();

		Thread.sleep(3000);
		WebElement LastName = driver
				.findElement(By.id("CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TextBoxLastName"));
		LastName.sendKeys(Keys.SHIFT);
		LastName.sendKeys("ansari");

		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,500)");
		driver.findElement(By.xpath("//input[@id='CONTROLGROUPREGISTERVIEW_ButtonSubmit']")).click();
		test.pass("Valued Entered", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		Alert alert = driver.switchTo().alert();
		System.out.println("The Alert Message is===>" + alert.getText());
		alert.accept();
		System.out.println("Accepted the alert.");
		driver.quit();
	}

	@Test
	public void TestCaseFailureScreenShots2() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\IRFAN---\\java program\\AllAutomationImportantConcept\\Browser-Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.get("http://jqueryui.com/droppable/");

		ExtentTest test = extent.createTest("Create My First Extent Report TestCaseFailureScreenShots2").assignAuthor("Mohammed").assignCategory("Smoke").assignDevice("Chrome 89");
		test.log(Status.INFO, "This step show usage log info");
		test.log(Status.PASS, "The test case passs");
		Actions action = new Actions(driver);

		String title = driver.getTitle();
		System.out.println("Jqueryui Title is===>" + title);
		driver.switchTo().frame(0);

		Actions action1 = new Actions(driver);
		WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
		action1.clickAndHold(drag).moveToElement(drop).release().build().perform();

		Thread.sleep(3000);
		test.pass("Valued Entered", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		driver.findElement(By.xpath("//div[@id='draggable']")).click();
		driver.close();
	}

	@Test
	public void TestCaseFailureScreenShots3() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\IRFAN---\\java program\\AllAutomationImportantConcept\\Browser-Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		ExtentTest test = extent.createTest("Create My First Extent Report TestCaseFailureScreenShots3");
		test.log(Status.INFO, "This step show usage log info");
		//test.log(Status.FAIL, "Failed the test case");
		driver.findElement(By.name("q")).sendKeys("Automation", Keys.ENTER);
		System.out.println("The Tile of goole page is==>" + driver.getTitle());
		test.pass("Valued Entered", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		driver.close();
	}

	@Test
	public void TestCaseFailureScreenShots4() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\IRFAN---\\java program\\AllAutomationImportantConcept\\Browser-Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		ExtentTest test = extent.createTest("Skiped Test Method");
		test.log(Status.INFO, "This step show usage log info");
		test.log(Status.SKIP, "Test Methos is skiped"); 
		throw new SkipException("Excuting Skiped test");
		

	}

	public static void failed(String testMethodName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("D:\\IRFAN---\\java program\\AllAutomationImportantConcept\\ScreenShot"
					+ testMethodName + "_" + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getBase64() {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	}
}
