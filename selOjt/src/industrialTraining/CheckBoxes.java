package industrialTraining;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CheckBoxes {

	WebDriver driver = null;

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

	@Test
	public void checkBox() {

		ArrayList<String> values = new ArrayList<String>();
		values.add("Cricket");
		values.add("Movies");
		values.add("Hockey");

		List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		selectMultipleCheckBox(checkBoxes, values);

	}

	public void selectMultipleCheckBox(List<WebElement> checkBoxes, List<String> values) {

		for (String value : values) {
			for (WebElement checkBox : checkBoxes) {
				if (checkBox.getAttribute("value").equals(value)) {
					checkBox.click();
					break;
				}

			}
		}

	}

}
