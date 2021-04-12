package com.HandleWindowAndTabs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandleWindow {

	static WebDriver driver;
	static Logger log= Logger.getLogger(HandleWindow.class);
	
	@Test
	public static void HowTohandlkeWindows() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\IRFAN---\\java program\\AllAutomationImportantConcept\\Browser-Driver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
			
		//We can Handle window in two ways
				//1.. getWindowHandle();
				//2.. getWindowHandles();
		 String parentWindowID=driver.getWindowHandle(); //return ID of single browser
		System.out.println("Parent Window ID is====>" + parentWindowID);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
		Thread.sleep(3000);
		Set<String> windowsIDs=driver.getWindowHandles();
		System.out.println("Total number of Id of Multiple Windiows====>" + windowsIDs.size());
		
		//How to caputer Multiple Windows ID
			//1. using iterator();
//		Iterator<String> itr=windowsIDs.iterator();
//		String parentID=itr.next();
//		String childID=itr.next();
//		System.out.println("Parent window ID is====> "+ parentID);	
//		System.out.println("Childt window ID is====> "+ childID);
		
			//2...using List or ArrayList
		List<String> windowIDsList= new ArrayList(windowsIDs);
		String ListparentID=windowIDsList.get(0);
		String ListchildID=windowIDsList.get(1);
		System.out.println("ListParent window ID is====> "+ ListparentID);
		System.out.println("Listchild window ID is====> "+ ListchildID);
		
//		//How to use WindowID for switching
		driver.switchTo().window(ListparentID);
		System.out.println("Parent window title is ===>" + driver.getTitle());
//		
		driver.switchTo().window(ListchildID);
		System.out.println("Child window title is ===>" + driver.getTitle());
		
//		for(String winid:windowIDsList) {
//			String title=driver.switchTo().window(winid).getTitle();
//			System.out.println("All window title is ===>" + title);
//			if(! title.equals("OrangeHRM")|| title.equals("HR Management System | HR Management Software | OrangeHRM")) {
//				driver.close();
//				System.out.println("Child window closed with Title OrangeHRM");
//			}	
		}
		
		
	}

