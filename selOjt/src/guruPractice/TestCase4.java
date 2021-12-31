package guruPractice;

import static org.testng.Assert.assertEquals;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestCase4 {
	
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
	
	@Test
	public void test04() throws Exception {
		driver.findElement(By.linkText("Mobile")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='IPhone']//parent::h2//following-sibling::div//button//following-sibling::ul//span//following-sibling::a")).click();
		String mainMobile1 =driver.findElement(By.xpath("//h2//a[text()='IPhone']")).getText();
		System.out.println("mainMobile1 : "+mainMobile1);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Sony Xperia']//parent::h2//following-sibling::div//button//following-sibling::ul//span//following-sibling::a")).click();
		String mainMobile2 =driver.findElement(By.xpath("//h2//a[text()='Sony Xperia']")).getText();
		System.out.println("mainMobile2 : "+mainMobile2);
		Thread.sleep(1000);
		
		String parent=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		driver.findElement(By.xpath("//button[@title='Compare']")).click();
		Thread.sleep(1000);
		
		for(String handle :windows) {
			if(!parent.equals(handle))
			driver.switchTo().window(handle);
		}
		
		
		
		String strHead="COMPARE PRODUCTS";
		String compHead=driver.findElement(By.xpath("//h1")).getText();
		System.out.println("compHead = "+compHead);
		String popupMobile1=driver.findElement(By.xpath("//h2//a[text()='Sony Xperia']")).getText();
		String popupMobile2=driver.findElement(By.xpath("//h2//a[text()='IPhone']")).getText();
		System.out.println("popupMobile1 = "+popupMobile1);
	    System.out.println("popupMobile2 = "+popupMobile2);
	    Thread.sleep(1000);
	   try { 
	    assertEquals(strHead, compHead);
	   }catch (Exception e) {
		e.printStackTrace();
	}
	   try { 
		    assertEquals(mainMobile1, popupMobile1);
		   }catch (Exception e) {
			e.printStackTrace();
		}
	   try { 
		    assertEquals(mainMobile2, popupMobile2);
		   }catch (Exception e) {
			e.printStackTrace();
		}
	   
	   driver.findElement(By.xpath("//button[@title='Close Window']")).click();
	
	}

}
