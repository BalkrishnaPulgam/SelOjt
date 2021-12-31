package windowHandling;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TabHandling {
	public static void main(String[] args) throws AWTException {
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:/Driver/chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html");
		
	/*	//1 link open in new tab
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
		driver.findElement(By.partialLinkText("new")).sendKeys(selectLinkOpeninNewTab);
		
			//2  blank tab
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.open('','');");
		
	
		//3
		//To open a new tab         
		Robot r = new Robot();                          
		r.keyPress(KeyEvent.VK_CONTROL); 
		r.keyPress(KeyEvent.VK_T); 
		r.keyRelease(KeyEvent.VK_CONTROL); 
		r.keyRelease(KeyEvent.VK_T);   
		
	*/	
		//
		WebElement linkElement=driver.findElement(By.partialLinkText("new"));
		
		Actions actions = new Actions(driver); 
        actions.keyDown(Keys.LEFT_CONTROL) 
               .click(linkElement) 
               .keyUp(Keys.LEFT_CONTROL) 
               .build() 
               .perform(); 
	
		
	}

}
