package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Red {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
	
	System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
	ChromeOptions option = new ChromeOptions();
	option.addArguments("--disable-notifications");
	driver = new ChromeDriver(option);
	driver.get("https://www.redbus.in/");

	Thread.sleep(15000);
	
	
	WebElement src=	driver.findElement(By.id("src"));
	src.sendKeys("Wakad Pune");
	src.sendKeys(Keys.ENTER);
	
	WebElement dest=	driver.findElement(By.id("dest"));
	dest.sendKeys("Solapur");
	dest.sendKeys(Keys.ENTER);
	
		driver.findElement(By.xpath("//label[text()='Date']")).click();
		
		WebElement rightArrow=driver.findElement(By.xpath("//div[@class='rb-calendar']//button[text()='>']"));
		
		WebElement monthName=driver.findElement(By.xpath("//td[@class='monthTitle']"));
		
		List<WebElement> list=driver.findElements(By.xpath("//td[@class='wd day']"));
		
		
		
		
		for (WebElement webElement : list) {
			String text=webElement.getText();
			System.out.println(text);
			if(text.equals("22"));
			webElement.click();
		}
	}
}
