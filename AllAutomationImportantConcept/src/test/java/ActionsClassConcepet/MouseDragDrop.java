package ActionsClassConcepet;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseDragDrop {
	static WebDriver driver; 
	static Logger log= Logger.getLogger(MouseMovement.class);
	@Test
	public static void DragDropConcep() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D:\\IRFAN---\\java program\\AllAutomationImportantConcept\\Browser-Driver\\chromedriver.exe");
		driver= new ChromeDriver();
		System.out.println();
		log.info("****************************opening google***********************");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://jqueryui.com/droppable/");
		
		String title= driver.getTitle();
		System.out.println("Jqueryui Title is===>" + title);
		driver.switchTo().frame(0);
		
		Actions action= new Actions(driver);
		WebElement drag=driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement drop=driver.findElement(By.xpath("//div[@id='droppable']"));
		action.clickAndHold(drag).moveToElement(drop).release().build().perform();
		
		Thread.sleep(3000);
		
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
		
	}

}
