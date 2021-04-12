package com.DatePicker;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DatePickerType1 {
	static WebDriver driver;
	static Logger log=Logger.getLogger(DatePickerType1.class);

	@Test
	public static void DatePicker1() {
		System.setProperty("webdriver.chrome.driver", "D:\\IRFAN---\\java program\\AllAutomationImportantConcept\\Browser-Driver\\chromedriver.exe");
		driver= new ChromeDriver();
		log.info("****************************opening google***********************");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.redbus.in/");
		
		String title= driver.getTitle();
		System.out.println("REDBUS Title is===>" + title);
		
		String year="2021";
		String month="Oct";
		String date="19";
		
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
		while(true) {
			String monthyear=driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
			String arr[]=monthyear.split(" ");
			String mon=arr[0];
			String yr= arr[1];
			if(mon.equalsIgnoreCase(month) && yr.equalsIgnoreCase(year))
				
				break;
			else
				driver.findElement(By.xpath("//button[normalize-space()='>']")).click();
		}
		
		List<WebElement> alldate=driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//td"));
		for(WebElement ele:alldate) {
			String dt=ele.getText();
			if(dt.equals(date)) {
				ele.click();
				break;
			}
		}
		
		
		
		
	}
}
