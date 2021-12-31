package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BBB {
	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
	
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--incognito");
	WebDriver driver = new ChromeDriver(options);
		
	driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html");
	}
}
