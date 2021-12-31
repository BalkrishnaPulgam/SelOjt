package industrialTraining;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ClickMethods {

	WebDriver driver = null;

	public void initialization() {
		System.setProperty("webdriver.chrome.driver", "D:/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	}

	@BeforeSuite
	public void setup() {
		initialization();
	}

	@Test
	public void test1() {
		WebElement ele=driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().keyDown(ele,Keys.SHIFT).sendKeys("balkrishna").build().perform();
		
		}
	
	@Test
	public void test2() {
		WebElement ele=driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		ele.clear();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",ele);
		ele.sendKeys("456");
		
		
		}

}
