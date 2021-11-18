package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WindowMin {
	static WebDriver driver = null;

	public static void main(String args[]) throws InterruptedException {

		// for private window

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("window-size=800,480");
		capabilities.setCapability(ChromeOptions.CAPABILITY, option);
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		driver = new ChromeDriver(capabilities);

		String url = "https://www.google.com/";
		driver.get(url);
	}

}
