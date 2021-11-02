package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class PracticeGetCssValue {
	
	@Test
	public void verifyColor() {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("headless");
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);
		
		
		System.setProperty("webdriver.chrome.driver", "D:/Driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver(options);
		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html");
		
		WebElement element=driver.findElement(By.xpath("//button"));
		
		System.out.println("Before button clr"+element.getCssValue("background-color"));
		
		Actions actions=new Actions(driver);
		actions.moveToElement(element).build().perform();
		System.out.println("After button clr"+element.getCssValue("color"));
		
	}

}
