package industrialTraining;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class HighLightAnElement {
	WebDriver driver = null;
	public void initialization() {
		System.setProperty("webdriver.chrome.driver", "D:/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.gmail.com");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

	}

	@BeforeSuite
	public void setup() {
		initialization();
	}

	@Test
	public void highLight() {
		WebElement ele = driver.findElement(By.xpath("//input[@type='email']"));
		 //Call the highlighterMethod and pass webdriver and WebElement which you want to highlight as arguments
		highLighterMethod(driver, ele);
		ele.sendKeys("SoftwareTestingMaterial.com");
	}
	
	 //Creating a custom function
		public void highLighterMethod(WebDriver driver, WebElement element){
			JavascriptExecutor js = (JavascriptExecutor) driver;
	//		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
			js.executeScript("arguments[0].style.border='2px solid red'", element);
		}
		
		/*
		Finding an element using the selenium webdriver and highlighting it.
		WebElement emailTxt = driver.findElement(By.id("email"));  
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
		jsExecutor.executeScript("arguments[0].style.border='2px solid red'", emailTxt);
		
		*/
}
