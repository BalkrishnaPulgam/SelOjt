package industrialTraining;


import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SelectRadioButton {

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
	public void gender_1() {
		List<WebElement> radios = driver.findElements(By.xpath("//input[@name='radiooptions']"));
		selectRadio(radios, "FeMale");
	}

	@Test
	public void gender_2() {
		List<WebElement> radios = driver.findElements(By.xpath("//input[@name='radiooptions']"));
		selectRadio(radios, "Male");
	}

	@Test
	public void hobbiesCheckBox() {
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		selectCheckBox(checkBoxes, "Cricket");
		selectAllCheckBox(checkBoxes);
	}

	@Test
	public void SkillsList() {
		WebElement element = driver.findElement(By.xpath("//select[@id='Skills']"));

		System.out.println(getAllDropDownValues(element));
	}

	@Test
	public void countriesList() {
		WebElement element = driver.findElement(By.className("select2-selection__rendered"));
		List<String> valuesList = new LinkedList<String>();
		Select sel = new Select(element);
		List<WebElement> elementList = sel.getOptions();
		for (WebElement ele : elementList) {
			valuesList.add(ele.getText());
			System.out.println(valuesList);
		}
	}

	public void selectRadio(List<WebElement> radios, String text) {
		for (WebElement radio : radios) {
			if (radio.getAttribute("value").equals(text)) {
				radio.click();
				if (radio.isSelected()) {
					System.out.println(text + " Radio Button is selected.");
				}
				break;
			}
		}
	}

	public void selectCheckBox(List<WebElement> checkBoxes, String text) {
		for (WebElement checkBox : checkBoxes) {
			if (checkBox.getAttribute("value").equals(text)) {
				;
				checkBox.click();
				break;
			}
		}
	}
	
	
		
	
	

	public void selectAllCheckBox(List<WebElement> checkBoxes) {
		for (WebElement checkBox : checkBoxes) {
			if (!checkBox.isSelected()) {
				checkBox.click();
			}
		}
	}

	public List<String> getAllDropDownValues(WebElement element) {

		List<String> newList = new LinkedList<String>();
		Select sel = new Select(element);
		List<WebElement> elementList = sel.getOptions();
		for (WebElement el : elementList) {
			newList.add(el.getText());
		}

		return newList;

	}

}
