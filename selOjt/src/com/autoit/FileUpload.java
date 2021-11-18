package com.autoit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FileUpload {
	
	WebDriver driver;
	
	@Test
	public void test() throws Exception{
		System.setProperty("webdriver.chrome.driver", "DriverForAutoIT/chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get("https://javabykiran.com/playground/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("File Upload")).click();
		driver.findElement(By.id("file")).click();
		Thread.sleep(5000);
		Runtime.getRuntime().exec("E:\\AutoIT\\demo.exe");
		
	WebElement submit=	driver.findElement(By.xpath("//button[@name='send']"));
	
	
	}

}
