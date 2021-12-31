package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class RightClick {
	
	WebDriver driver = null;
	public void initialization() {
		System.setProperty("webdriver.chrome.driver", "D:/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://javabykiran.com/playground/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

	}

	@BeforeSuite
	public void setup() {
		initialization();
	}

	@Test
	public void rightclick() {

		  WebElement ele=driver.findElement(By.linkText("UPDATE User"));
		  Actions action = new Actions(driver);
		  action.moveToElement(ele).contextClick().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).
		  build().perform();
	}

}
