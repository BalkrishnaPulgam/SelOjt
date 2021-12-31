package industrialTraining;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ActionsClassPageDownAndPageUp {
	WebDriver driver = null;
	public void initialization() {
		System.setProperty("webdriver.chrome.driver", "D:/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.softwaretestingmaterial.com");
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

	}

	@BeforeSuite
	public void setup() {
		initialization();
	}

	
	
	@Test
	public void actionsClass() throws InterruptedException{
		
		Actions action = new Actions(driver);
                //open SoftwareTestingMaterial.com
		
                //sleep for 3secs to load the page
		Thread.sleep(3000);
                //SCROLL DOWN
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(3000);
                //SCROLL UP
		action.sendKeys(Keys.PAGE_UP).build().perform();
                //driver.close();
        }

}
