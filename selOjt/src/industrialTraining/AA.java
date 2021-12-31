package industrialTraining;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AA {
	
	WebDriver driver = null;
	
	public AA(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void initialization() {
		System.setProperty("webdriver.chrome.driver", "D:/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

	}
	

	@BeforeSuite
	public void setup() {
		initialization();
	}
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	WebElement FirstName;
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement LastName;
	
	@FindBy(xpath="//input[@name='radiooptions']")
	List<WebElement> genders;
	
	@FindBy(xpath="//input[@type='checkbox']")
	List<WebElement> Hobbies;
	
	
	public void enterFirstName(String text) {
		FirstName.sendKeys(text);
	}
	
	public void enterLastName(String text) {
		LastName.sendKeys(text);
	}
	
	
	
	
	
	public void selectGender(String text) {
		for(WebElement gender:genders) {
			if(gender.getAttribute("value").equalsIgnoreCase(text)) {
				gender.click();
				break;
			}
		}
	}
	
	
	public void selectHobbies(List<String> values) {
		for(String value:values ) {
			for(WebElement checkBox:Hobbies) {
				if(checkBox.getAttribute("value").equalsIgnoreCase(value)) {
					checkBox.click();
					break;
				}
			}
		}
	}
	
	
	@Test
	public void test1() {
		enterFirstName("sumit");
		enterLastName("verma");
		selectGender("male");
		
		
		List<String> values=new ArrayList<String>();
		values.add("Movies");
		
	}
	
	@Test
	public void test2() {
		enterFirstName("sumit11");
		enterLastName("verma11");
		selectGender("Female");
		
		
		List<String> values=new ArrayList<String>();
		values.add("Cricket");
		
	}
	 

}
