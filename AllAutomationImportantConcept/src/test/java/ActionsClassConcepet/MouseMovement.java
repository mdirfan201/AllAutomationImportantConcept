package ActionsClassConcepet;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.interactions.Action;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class MouseMovement {
	
	static WebDriver driver; 
	static Logger log= Logger.getLogger(MouseMovement.class);
	@Test
	public static void MouseMoventConcep() throws InterruptedException, MalformedURLException, IOException{
		System.setProperty("webdriver.chrome.driver", "D:\\IRFAN---\\java program\\AllAutomationImportantConcept\\Browser-Driver\\chromedriver.exe");
		driver= new ChromeDriver();
		System.out.println();
		log.info("****************************opening google***********************");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.spicejet.com/");
		Actions action= new Actions(driver);
		WebElement 	logimMove=driver.findElement(By.xpath("//a[@id='ctl00_HyperLinkLogin']"));
		action.moveToElement(logimMove).build().perform();
		Thread.sleep(3000);
		action.moveToElement(driver.findElement(By.linkText("SpiceClub Members"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign up")).click();	
		Thread.sleep(3000);
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		String titel1=driver.getTitle();
		System.out.println("The Loging Page Title is=====>" +titel1);
		System.out.println();
		WebElement Title= driver.findElement(By.xpath("//select[@id='CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_DropDownListTitle']"));
		Select select= new Select(Title);
		//select.selectByValue("MR");
		//select.selectByIndex(1);
		select.selectByVisibleText("MR");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		WebElement txtUsername= driver.findElement(By.id("CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TextBoxFirstName"));
		String typeValue=txtUsername.getAttribute("type");
		System.out.println("Value of type attribute: "+typeValue);
		
		String typeIndex=txtUsername.getAttribute("tabindex");
		System.out.println("Index of type attribute:=== "+typeIndex);
		
//		String text=JOptionPane.showInputDialog("Enter the captcha");
//		WebElement txtUsername1= driver.findElement(By.id("CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TextBoxFirstName"));
//		txtUsername1.sendKeys(text);
		
		
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
			.moveToElement(txtUsername)
			.click()
			.keyDown(txtUsername, Keys.SHIFT)
			.sendKeys(txtUsername, "mohammed irfanulah")
			.keyUp(txtUsername, Keys.SHIFT)
			.doubleClick(txtUsername)
			//.contextClick()
			//.sendKeys(Keys.ENTER)
			.build();
			seriesOfActions.perform() ;
			
			Thread.sleep(3000);
			WebElement LastName=driver.findElement(By.id("CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TextBoxLastName"));
			LastName.sendKeys(Keys.SHIFT);
			LastName.sendKeys("ansari");
			
			List<WebElement> linksList=driver.findElements(By.tagName("a"));
			linksList.addAll(driver.findElements(By.tagName("img")));
			System.out.println("Size of  Full links and images are====>" + linksList.size());
			
			
			List<WebElement> activelinks= new ArrayList<WebElement>();
			
			for(int i=0; i<linksList.size();i++) {
				if(linksList.get(i).getAttribute("href") !=null && (! linksList.get(i).getAttribute("href").contains("javascript"))) {
				activelinks.add(linksList.get(i));
				}
			}
			
			System.out.println("Size of active links and images are====>" + activelinks.size());
			for(int j=0; j<activelinks.size(); j++) {
				
				HttpURLConnection connection= (HttpURLConnection) new URL(activelinks.get(j).getAttribute("href")).openConnection();
				connection.connect();
				String response= connection.getResponseMessage();
				connection.disconnect();
				System.out.println(activelinks.get(j).getAttribute("href") + " "+ response);
				
			}
			driver.findElement(By.id("CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TextBoxFirstName")).sendKeys("11111");
	}

}
