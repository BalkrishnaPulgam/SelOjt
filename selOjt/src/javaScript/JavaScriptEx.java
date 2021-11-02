package javaScript;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptEx {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:/Driver/chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html");
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].click();", driver.findElement(By.id("email")));
		
		js.executeScript("document.getElementById('email').value='kiran@gmail.com';");
		
		js.executeScript("arguments[0].click();", driver.findElement(By.id("password")));
		
		js.executeScript("document.getElementById('password').value='123456';");
		
		js.executeScript("arguments[0]",driver.findElement(By.xpath("//button")));
		
		js.executeScript("history.go(0)");
		
		js.executeScript("alert('WElcome!!!');");
		
		Alert alert=driver.switchTo().alert();
		alert.accept();
		
		driver.navigate().to("https://www.amazon.in/ref=nav_logo");
		
		Thread.sleep(5000);
		
	WebElement element=driver.findElement(By.xpath("//span[@class='action-inner']"));
		
		js.executeScript("arguments[0].scrollIntoView(true);",element);
	
	}

}
