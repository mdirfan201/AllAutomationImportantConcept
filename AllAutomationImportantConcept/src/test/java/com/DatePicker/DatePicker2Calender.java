package com.DatePicker;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DatePicker2Calender {
	
	static WebDriver driver;
	static Logger log=Logger.getLogger(DatePicker2Calender.class);

	@Test
	public static void DatePicker1() throws IOException {
		InputStream input= new FileInputStream("D:\\IRFAN---\\java program\\AllAutomationImportantConcept\\DateRead.properties");
		Properties prop= new Properties();
		prop.load(input);
		
		System.setProperty("webdriver.chrome.driver", "D:\\IRFAN---\\java program\\AllAutomationImportantConcept\\Browser-Driver\\chromedriver.exe");
		driver= new ChromeDriver();
		log.info("****************************opening google***********************");
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']")).click();
		System.out.println("The SpiceJet Title is==>"+ driver.getTitle());
		
		
		String month="October 2021";
		String date="19";
		
		while(true) {
		String monthyear= driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-left']")).getText();
		System.out.println("The value of month and year==>" + monthyear);
		if(monthyear.equalsIgnoreCase(month)) {
			break;
		}
		else {
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		
		}
		
		List<WebElement> alldate=driver.findElements(By.xpath("//body[1]/div[2]/div[1]/table[1]/tbody[1]/tr/td"));
		for(WebElement ele: alldate) {
			System.out.println("The ele Date"+ele.getText());
			
		}
		
}
}
