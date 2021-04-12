package com.HandleFrames;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class handleIFrame {

	static WebDriver driver; 
	static Logger log= Logger.getLogger(handleIFrame.class);
	@Test
	public static void HandleFrameSelenium() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\IRFAN---\\java program\\AllAutomationImportantConcept\\Browser-Driver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		
		//we can Handle Frame in 3 ways...
		
		//1.. driver.switchTo().frame(name of frame Or Id of frame);
		//2.. driver.switchTo().frame(WebElement); 
		//3.. driver.switchTo().frame(0);
		
		//1st frame
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.xpath("//a[normalize-space()='org.openqa.selenium']")).click();
		driver.switchTo().defaultContent(); //go back to main page
		Thread.sleep(3000);
		
		//2nd frame
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.xpath("//span[normalize-space()='WebDriver']")).click();
		driver.switchTo().defaultContent(); //go back to main page
		Thread.sleep(3000);
		
		//3rd Frame
		driver.switchTo().frame("classFrame");
		driver.findElement(By.xpath("//div[@class='topNav']//a[text()='Help']")).click();
		driver.switchTo().defaultContent(); //go back to main page
		Thread.sleep(3000); 
		
	}
	
}
