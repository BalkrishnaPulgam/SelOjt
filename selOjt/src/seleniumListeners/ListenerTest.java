package seleniumListeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ListenerTest {
	
	WebDriver driver;
	@BeforeSuite
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		driver=new ChromeDriver();
		EventFiringWebDriver efd= new EventFiringWebDriver(driver);
		ListenerExSel listEx=new ListenerExSel();
		efd.register(listEx);
		driver=efd;
		
	}

	@Test
	public void test01() {
		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html");
		driver.navigate().refresh();
		
		driver.navigate().to("https://www.redbus.in/");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().to("file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html");
		
		WebElement uname=driver.findElement(By.id("email"));
		uname.sendKeys("kiran@gmail.com");
		WebElement pass=driver.findElement(By.id("password"));
		pass.sendKeys("123456");
		WebElement btn=driver.findElement(By.xpath("//button"));
		btn.click();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard1");
		
	}
}
