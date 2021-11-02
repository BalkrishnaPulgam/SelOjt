package dataProvider;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class PrintData {

	public static WebDriver driver;

	public static void initialization() {
		System.setProperty("webdriver.chrome.driver", "D:/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html");
	}

	@BeforeSuite
	public void setup() {
		initialization();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
	}

	@Test
	public void loginTest() {
		
		driver.findElement(By.linkText("Users")).click();
		
		List<WebElement> uname=driver.findElements(By.xpath("//tr/td[2]"));
		List<WebElement> states=driver.findElements(By.xpath("//tr/td[7]"));
		
		
		//printing users from Maharashtra
		for(int i=0; i<states.size();i++) {
			if(states.get(i).getText().equals("Maharashtra")) {
				String name=uname.get(i).getText();
				System.out.println(name);
			}
		}
		
		//alternate
		String state="Maharashtra";
		int i=0;
		for (WebElement element : states) {
		String name=uname.get(i).getText();
		
			if(element.getText().equals(state)) {
				System.out.println(name);
			}
			i++;
		}
		
		//printing users from Punjab
		System.out.println("Users from Punjab");
		
		for(int j=0; j<states.size(); j++) {
			if(states.get(j).getText().equals("Punjab")) {
				String name=uname.get(j).getText();
				System.out.println(name);
			}
		}
		
		//printing userName who are female;
		System.out.println("printing userName who are Female: ");
		
		List<WebElement> gender=driver.findElements(By.xpath("//tr/td[6]"));
		String FemaleGender="Female";
		
		
		for(int k=0;k<gender.size();k++) {
			if(gender.get(k).getText().equals(FemaleGender)) {
				String name=uname.get(k).getText();
				System.out.println(name);
			}
		}
		
		////printing userName who are Male;
		System.out.println("printing userName who are Male: ");
		String maleGender="Male";
		int x=0;
		for(WebElement mGender:gender) {
			String name=uname.get(x).getText();
			if(mGender.getText().equals(maleGender)) {
				System.out.println(name);
			}
			x++;
		}
		
		
		//valid mobile number
		System.out.println("valid mobile number");
		int z=0;
		List<WebElement> mobile=driver.findElements(By.xpath("//tr//td[4]"));
		
		for (WebElement element : mobile) {
			String mob=element.getText();
		         char[] ch=mob.toCharArray();
	                 int length=ch.length;
		
			if(length==10) {
				String name=uname.get(z).getText();
				System.out.println(name);
			}
			z++;
			
		}
		
	}

	@Test(description = "employee not available on Sunday")
	public void verifyOperator() {

		driver.findElement(By.linkText("Operators")).click();

		System.out.println("employee not available on Sunday");

		List<WebElement> uname = driver.findElements(By.xpath("//tr//td[2]"));

		List<WebElement> timings = driver.findElements(By.xpath("//td[6]"));

		String timing = "Sunday";
		int y = 0;
		for (WebElement element : timings) {
			String name = uname.get(y).getText();
			if (!element.getText().contains(timing)) {
				System.out.println(name);
			}
			y++;
		}
	}
	
	@Test(description = "Employee who having PhoneCall")
	public void verifyPhoneCall() {
		driver.findElement(By.linkText("Operators")).click();

		System.out.println("Employee who having PhoneCall");
		
		List<WebElement> uname =driver.findElements(By.xpath("//tr//td[2]"));
		List<WebElement> phone=driver.findElements(By.xpath("//tr//td[4]"));
		
		int a=0;
		String phoneCall="Phone Call";
		for (WebElement element : phone) {
			
			if(element.getText().contains(phoneCall)) {
				String name=uname.get(a).getText();
				System.out.println(name);
			}
			a++;
		}
	}

}
