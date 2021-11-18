package guruPractice;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestCase2 {
WebDriver driver;
	
	@BeforeSuite
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:/Driver/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--incognito");
		driver=new ChromeDriver(options);
		driver.get("http://live.techpanda.org/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	@Test
	public void test04() throws Exception {
	
		driver.findElement(By.linkText("Mobile")).click();
		Thread.sleep(1000);
		
		 String XPeriaPrice =	driver.findElement(By.id("product-price-1")).getText();
		 System.out.println("XPeriaPrice : "+XPeriaPrice);
		 
		 driver.findElement(By.id("product-collection-image-1")).click();
		 driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		 
		 String detailPrice = driver.findElement(By.xpath("//span[@class='price']")).getText();
		 System.out.println("detailPrice : "+detailPrice);
		 
		 try {
			 assertEquals(XPeriaPrice, detailPrice);
		 }catch (Exception e) {
			e.printStackTrace();
		}

}
}