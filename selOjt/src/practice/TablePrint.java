package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class TablePrint {

	@Test
	public void verifyColor() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);

		System.setProperty("webdriver.chrome.driver", "D:/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html");

		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.linkText("Users")).click();

		WebElement table = driver.findElement(By.xpath("//table"));

		List<WebElement> tr = table.findElements(By.tagName("tr"));
		System.out.println("total no of rows " + tr.size());

		for (WebElement row : tr) {

			List<WebElement> td = row.findElements(By.tagName("td"));
			for (WebElement col : td) {
				System.out.println(col.getText());
			}
			System.out.println("----------");

		}

	}

}
