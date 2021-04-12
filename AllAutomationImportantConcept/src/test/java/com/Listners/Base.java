package com.Listners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	 
	static WebDriver driver;
	public static void initialization() {
		System.setProperty("webdriver.chrome.driver", "D:\\IRFAN---\\java program\\AllAutomationImportantConcept\\Browser-Driver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}

}
