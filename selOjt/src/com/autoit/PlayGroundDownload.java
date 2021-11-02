package com.autoit;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class PlayGroundDownload {
	WebDriver driver;

	@Test
	public void test() throws Exception {
		System.setProperty("webdriver.chrome.driver", "DriverForAutoIT/chromedriver.exe");

		String downloadPath = "E:\\AutoIT\\Download";

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);

		ChromeOptions options = new ChromeOptions();

		options.setExperimentalOption("prefs", chromePrefs);

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://javabykiran.com/playground/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Download File")).click();
		
		//clicking download button
		driver.findElement(By.id("download")).click();

	}
}