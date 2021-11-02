package com.autoit;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileDownload {
	WebDriver driver;

	@Test
	public void test() throws Exception {
		System.setProperty("webdriver.chrome.driver", "DriverForAutoIT/chromedriver.exe");
				
		 // for giving download directory
    //    String downloadPath=System.getProperty("user.dir");
      String downloadPath= "E:\\AutoIT\\UploadNew";

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        
     // Set ChromePref and pass the download folder path with key
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath);
        ChromeOptions options=new ChromeOptions();
        
        options.setExperimentalOption("prefs", chromePrefs);
        
        WebDriver driver=new ChromeDriver(options);
        
        driver.get("https://www.ilovepdf.com/pdf_to_word");
        driver.manage().window().maximize();
        
        driver.findElement(By.xpath("//span[text()='Select PDF file']")).click();
        
        Thread.sleep(5000);
        
        //autoit exe software for selecting file        
        Runtime.getRuntime().exec("E:\\AutoIT\\UploadNew\\Presentation.exe");
        
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("processTaskTextBtn")));
        
        driver.findElement(By.id("processTaskTextBtn")).click();
        
        File file=new File(downloadPath+"/visit.docx");
        
        if(file.exists())
        {
            Assert.assertTrue(file.exists());
            if(file.delete())
                System.out.println("file deleted");
        }
		
	}

}
