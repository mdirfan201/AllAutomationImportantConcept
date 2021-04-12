package com.DatePicker;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DatePickerDropDownType {
	
	static WebDriver driver;
	static Logger log=Logger.getLogger(DatePickerDropDownType.class);

	@Test
	public static void PickTheInputDate() {
		System.setProperty("webdriver.chrome.driver", "D:\\IRFAN---\\java program\\AllAutomationImportantConcept\\Browser-Driver\\chromedriver.exe");
		driver= new ChromeDriver();
		log.info("****************************opening google***********************");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application");
		
		String title= driver.getTitle();
		System.out.println("REDBUS Title is===>" + title);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("scrollBy(0,500)");
		
		driver.findElement(By.xpath("//input[@id='dob']")).click();
		Select mnth_drp=new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		mnth_drp.selectByVisibleText("Oct");
		
		Select year_drp= new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		year_drp.selectByVisibleText("1990");
		
		String date="19";
		List <WebElement> alldate=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		for(WebElement ele : alldate) {
			String dt=ele.getText();
			if(dt.equalsIgnoreCase(date)) {
				ele.click();
				break;
			}
		}
		
		
	}
}
