package com.autoit;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class RobotEx {
	
	WebDriver driver;
	Robot r;
	
	@Test
	public void test01() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:/Driver/chromedriver.exe");
		
		String downloadPath="D:\\Downloads";
		
		HashMap<String, Object> chromepref=new HashMap<String, Object>();
		
		chromepref.put("download.default_directory", downloadPath);
		
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("prefs", chromepref);
		
		driver=new ChromeDriver(options);
		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html");
		
		WebElement element=driver.findElement(By.tagName("img"));
		
		Actions action=new Actions(driver);
		action.contextClick(element).pause(5000).perform();
		
		r=new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.delay(5000);
		r.keyPress(KeyEvent.VK_ENTER);
		
		
	}

}
