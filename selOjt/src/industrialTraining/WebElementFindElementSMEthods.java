package industrialTraining;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class WebElementFindElementSMEthods {

	public static WebDriver driver;

	public static void initialization() {
		System.setProperty("webdriver.chrome.driver", "D:/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.goibibo.com/");
	}

	@BeforeSuite
	public void setup() {
		initialization();
	}

	@Test
	public void test_1() {
		
		WebElement aboutUs = driver.findElement(By.xpath("//li[text()='about us']//parent::ul"));

		List<WebElement> aboutUslist = aboutUs.findElements(By.tagName("a"));
		int num=aboutUslist.size();
		System.out.println(num);

	}
	
	@Test
	public void language_1() {
		List<WebElement> radios =	driver.findElements(By.xpath("//input[@name='fav_language']"));
		selectRadio(radios, "HTML");

	}
	
	
	public void selectRadio(List<WebElement> radios, String text) {
		
		for (WebElement radio : radios) {
			if(radio.getAttribute("value").equals(text))
				radio.click();
			break;
				
		}
			
	}

}
