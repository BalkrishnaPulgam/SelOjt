package guruPractice;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestCase1 {
	
WebDriver driver;
	
	@BeforeSuite
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:/Driver/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--headless");
		driver=new ChromeDriver(options);
		driver.get("http://live.techpanda.org/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	@Test
	public void test04() throws Exception {
		
		try {
			assertEquals(driver.getTitle(),"Home page");
		}catch (Exception e) {
			e.printStackTrace();
		}
	
		driver.findElement(By.linkText("Mobile")).click();
		Thread.sleep(1000);
		
		try {
			assertEquals(driver.getTitle(),"Mobile");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		WebElement element=driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select"));
		Select sel=new Select(element);
		sel.selectByVisibleText("Name");
		
		
		// Verify all products are sorted by name
		
		TakesScreenshot tc=(TakesScreenshot) driver;
		File src=tc.getScreenshotAs(OutputType.FILE);
		
		String path="D:\\SoftwareTestingMaterial.png";
		
		File dest=new File(path);
		FileUtils.copyFile(src, dest);
		
		

}
}