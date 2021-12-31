package industrialTraining;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SelectClassOptions {

	WebDriver driver = null;

	public void initialization() {
		System.setProperty("webdriver.chrome.driver", "D:/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

	}

	@BeforeSuite
	public void setup() {
		initialization();
	}

	@Test
	public void dropdownMultipleSelect() {
		driver.switchTo().frame("iframeResult");
		WebElement ele = driver.findElement(By.id("cars"));
		ArrayList<String> values = new ArrayList<String>();
		values.add("Saab");
		values.add("Volvo");

		MultipleSelect(ele, values);

	}

	public void MultipleSelect(WebElement element, List<String> text) {

		Select dropdown = new Select(element);
		if (dropdown.isMultiple()) {
			for (String text1 : text) {
				dropdown.selectByVisibleText(text1);
			}
		}
	}

	public void getOptiosSelectByVisibleText(WebElement element, String text) {
		Select dropdown = new Select(element);
		List<WebElement> optios = dropdown.getOptions();
		for (WebElement option : optios) {
			if (option.getText().equals(text))
				;
			dropdown.selectByVisibleText(text);
			break;
		}
	}
	
	

}
