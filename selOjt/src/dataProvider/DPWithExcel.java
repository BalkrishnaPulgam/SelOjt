package dataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DPWithExcel {

	public static WebDriver driver;

	public static void initialization() {
		System.setProperty("webdriver.chrome.driver", "D:/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html");
	}

	@BeforeSuite
	public void setup() {
		initialization();
	}

	@Test(dataProvider = "loginData")
	public void loginTest(String uname, String password, String title) {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(uname);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//button")).click();
		Assert.assertEquals(driver.getTitle(), title);
		if (title.contains("Dashboard"))
			driver.findElement(By.linkText("LOGOUT")).click();
	}

	@DataProvider
	String[][] loginData() throws BiffException, IOException {
		FileInputStream fis = new FileInputStream("DataForUse/LoginData.xls");
		Workbook wb = Workbook.getWorkbook(fis);
		Sheet sh = wb.getSheet("login");
		String[][] data = new String[sh.getRows() - 1][sh.getColumns()];
		
		for(int i=1; i<sh.getRows();i++) {    //rows
			for(int j=0; j<sh.getColumns();j++) {  //for columns
				Cell cell=sh.getCell(j,i);
				String value=cell.getContents();
				
				data[i-1][j]=value;
			}
		}
		System.out.println(data);
		return data;
	}
}
