package com.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class screenShot {
	static WebDriver driver;
	public static void captureScreenshots( String testMethodName) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		try {
	FileUtils.copyFile(src, new File("D:\\IRFAN---\\java program\\AllAutomationImportantConcept\\ScreenShot"+testMethodName+"_"+".png"));
		} catch (IOException e) {
			System.out.println("Error in taking ScreenShots");
			e.printStackTrace();
		}
	}
}
