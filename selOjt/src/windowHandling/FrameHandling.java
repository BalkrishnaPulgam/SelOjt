package windowHandling;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class FrameHandling {

	WebDriver driver = null;

	@Test
	public void test01() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver = new ChromeDriver(option);
		driver.get("https://www.redbus.in/");

		Thread.sleep(15000);

		WebElement ele = driver.findElement(By.xpath("//i[@id='i-icon-profile']"));
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click();", ele);

		System.out.println(1);
		driver.findElement(By.id("signInLink")).click();
		System.out.println(1);
		Thread.sleep(15000);
		String mainWin = driver.getWindowHandle();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='modalIframe']")));

		driver.findElement(By.xpath("//div[text()='Facebook']")).click();

		Set<String> allWins = driver.getWindowHandles();
		String childWin = null;

		for (String window : allWins) {
			if (!mainWin.equals(window)) {
				driver.switchTo().window(window);
				childWin = driver.getWindowHandle();
			}
		}

		driver.findElement(By.id("email")).sendKeys("pulgambalkrishna47@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("124575");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.name("login")).click();
		Thread.sleep(5000);

		driver.close();

		driver.switchTo().window(mainWin);
		driver.findElement(By.xpath("//i[@Class='icon-close']")).click();
		
	//	WebElement cl = driver.findElement(By.xpath("//i[@Class='icon-close']"));
	//	JavascriptExecutor frameClose = (JavascriptExecutor) driver;
	//	frameClose.executeScript("arguments[0].click()", cl);
		
		
	}
}
