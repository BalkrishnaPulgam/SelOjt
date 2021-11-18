package practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println(allLinks.size());
		for (int i = 0; i < allLinks.size(); i++) {
			WebElement ele = allLinks.get(i);
			String url = ele.getAttribute("href");
			verifyLinkActive(url);
		}
	}

	public static void verifyLinkActive(String linkUrl) {
		try {
			URL url = new URL(linkUrl);
			HttpURLConnection httpUrlCon = (HttpURLConnection) url.openConnection();
			httpUrlCon.setConnectTimeout(3000);
			httpUrlCon.connect();
			if (httpUrlCon.getResponseCode() == 200) {
				System.out.println(linkUrl + " - " + httpUrlCon.getResponseMessage());
			}
			if (httpUrlCon.getResponseCode() == httpUrlCon.HTTP_NOT_FOUND) {
				System.out
						.println(linkUrl + " - " + httpUrlCon.getResponseMessage() + " - " + httpUrlCon.HTTP_NOT_FOUND);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
