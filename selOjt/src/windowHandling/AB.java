package windowHandling;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AB {

	public static void main(String[] args) {

		WebDriver driver;

		System.setProperty("webdriver.chrome.driver", "D:/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html");

		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();

		String parent = driver.getWindowHandle();
		List<WebElement> links = driver.findElements(By.partialLinkText("info"));

		for (WebElement link : links) {
			link.click();
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Set<String> wins = driver.getWindowHandles();
		
		
		
		for(String win:wins) {
			if(!parent.equals(win)) {
				driver.switchTo().window(win);
				driver.close();
			}
		}
		
		
		Actions action=new Actions(driver);
		action.sendKeys(Keys.chord(Keys.CONTROL,Keys.TAB));
		driver.get("google.com");
		
		

	}

}
