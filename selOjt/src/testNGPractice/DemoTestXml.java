package testNGPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTestXml {
	 WebDriver driver;
	
	@Test(groups = "login")
	public void verifyLoginTitle() {
		System.setProperty("webdriver.chrome.driver", "D:/Driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html");
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Log in");
	}
	
	@Test(groups = "login")
	public void verifyLogo() {
		WebElement element=driver.findElement(By.xpath("//img"));
		Assert.assertTrue(element.isDisplayed());
	}

	@Test(groups = "login")
	public void verifyValidLogin() {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}
	
	@Test(groups = "dash",dependsOnGroups = "login",alwaysRun = true)
	public void verifyDashboardTitle() {
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard1");
	}
	
	@Test(groups = "dash",dependsOnGroups = "login")
	public void verifyCourses() {
		Assert.assertEquals(true, false);
		
	}

}
