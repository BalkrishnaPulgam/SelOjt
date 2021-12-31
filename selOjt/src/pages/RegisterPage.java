package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeSuite;

public class RegisterPage {

	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
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

	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement FirstName;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement LastName;

	@FindBy(xpath = "//input[@name='radiooptions']")
	List<WebElement> genders;

	@FindBy(xpath = "//input[@type='checkbox']")
	List<WebElement> Hobbies;

	public void enterFirstName(String text) {
		FirstName.sendKeys(text);
	}

	public void enterLastName(String text) {
		LastName.sendKeys(text);
	}

	public void selectGender(String text) {
		for (WebElement gender : genders) {
			if (gender.getAttribute("value").equalsIgnoreCase(text)) {
				gender.click();
				break;
			}
		}
	}

	public void selectHobbies(List<String> values) {
		for (String value : values) {
			for (WebElement checkBox : Hobbies) {
				if (checkBox.getAttribute("value").equalsIgnoreCase(value)) {
					checkBox.click();
					break;
				}
			}
		}
	}

}
