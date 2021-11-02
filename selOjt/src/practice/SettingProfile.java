package practice;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SettingProfile {
	WebDriver driver;
	
	@Test
	public void test() {
		System.setProperty("webdriver.chrome.driver", "D:/Driver/chromedriver.exe");
		
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		
		//chromePrefs.setPreference("browser.startup.homepage", "http://www.javabykiran.com/");
	}

}
