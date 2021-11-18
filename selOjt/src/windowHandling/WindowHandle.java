package windowHandling;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowHandle {
	WebDriver driver = null;

	@Test
	public void test01() throws Exception{
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		String mainWin = driver.getWindowHandle();

		List<WebElement> links = driver.findElements(By.partialLinkText("info"));   // findElements never throws exception, if element not found it creates empty list
		// upto this only one window

		for (WebElement link : links) {
			link.click();
			Thread.sleep(5000);
		}

		// now there are five windows in the browser

		Set<String> allWins = driver.getWindowHandles();
		
		for (String window : allWins) {
			System.out.println("id of handle of window: "+window);
		
			if(!mainWin.equals(window))
				driver.switchTo().window(window);
			
			
			System.out.println("title of child window :"+ driver.getTitle());
			System.out.println(driver.getCurrentUrl());
			
			if(!mainWin.equals(window))
			driver.close();
		}
	}

}
