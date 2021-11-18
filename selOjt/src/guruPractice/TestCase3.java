package guruPractice;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestCase3 {
	
WebDriver driver;
	
	@BeforeSuite
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:/Driver/chromedriver.exe");
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--headless");
		
		driver=new ChromeDriver(options);
		driver.get("http://live.techpanda.org/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void test04() throws Exception {
		driver.findElement(By.linkText("Mobile")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//h2//a[text()='Sony Xperia']//ancestor::li//span[text()='Add to Cart']")).click();
		driver.findElement(By.className("qty cart-item-quantity input-text")).clear();
		driver.findElement(By.className("qty cart-item-quantity input-text")).sendKeys("1000");
		driver.findElement(By.xpath("//button[@title='Update']")).click();
		
		String reqQty=driver.findElement(By.xpath("//p[@class='item-msg error']")).getText();
		 String msgQty ="* The maximum quantity allowed for purchase is 500.";
		 try {
			 assertEquals(reqQty, msgQty);
		 }catch (Exception e) {
			e.printStackTrace();
		}
		 
		 driver.findElement(By.id("empty_cart_button")).click();
		 Thread.sleep(2000);
		String actmsg= driver.findElement(By.xpath("//div[@class='cart-empty']//child::p[text()='You have no items in your shopping cart.']")).getText();
		System.out.println("You have no items msg = "+actmsg);
		String expmsg="You have no items in your shopping cart.";
		
		try {
			assertEquals(actmsg, expmsg);
		}catch (Exception e) {
			e.printStackTrace();
		}

		
	}
}
