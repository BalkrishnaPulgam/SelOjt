package industrialTraining;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class WindowPract {
	
	WebDriver driver = null;

	public void initialization() {
		System.setProperty("webdriver.chrome.driver", "D:/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Windows.html");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

	}

	@BeforeSuite
	public void setup() {
		initialization();
	}
	
	@Test
	public void test1() {
		driver.findElement(By.xpath("//button[text()='click']")).click();
		
	String parent=	driver.getWindowHandle();
	
	Set<String> list=driver.getWindowHandles();
		
	}

}
