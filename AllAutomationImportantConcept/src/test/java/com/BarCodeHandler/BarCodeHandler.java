package com.BarCodeHandler;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.HandleFrames.handleIFrame;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class BarCodeHandler {

	static WebDriver driver; 
	static Logger log= Logger.getLogger(BarCodeHandler.class);
	@Test
	public static void BarCodeHandlerSelenium() throws InterruptedException, NotFoundException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\IRFAN---\\java program\\AllAutomationImportantConcept\\Browser-Driver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.get("http://testautomationpractice.blogspot.com/");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("scrollBy(0,2000)");
		
		WebElement ele=driver.findElement(By.xpath("//img[@src='https://4.bp.blogspot.com/-_Bz0eHUicUY/XCxnkToPvQI/AAAAAAAAPPU/055m3a6VabUzUlwlzwwipQA-MImBuxq_wCLcBGAs/s1600/barcode2.gif']"));
		String str=ele.getAttribute("src");
		
		//HOW TO READ BARCODE IN SELENIUM
		//1 task
		
		URL url= new URL(str);
		//2 task
		BufferedImage img= ImageIO.read(url);
		//3
		LuminanceSource ls= new BufferedImageLuminanceSource(img);
		//4
		BinaryBitmap bm=new BinaryBitmap(new HybridBinarizer(ls));
		//5
		Result result=new MultiFormatReader().decode(bm);
		
		System.out.println("The value of BarCode is===>" +result.getText());
		Thread.sleep(5000);
		js.executeScript("scrollBy(0,-2000)");
		driver.findElement(By.xpath("//button[normalize-space()='Click Me']")).click();
		driver.switchTo().alert().getText();
		
		
		
}
}
