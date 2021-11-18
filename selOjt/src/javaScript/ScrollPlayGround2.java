package javaScript;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ScrollPlayGround2 {
	static WebDriver driver;

	public static void main(String[] args) throws AWTException {
		System.setProperty("webdriver.chrome.driver", "D:/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://javabykiran.com/playground/scrollbar-demo");

		WebElement element = driver.findElement(By.xpath("//button[text()='Sign In']"));

		driver.findElement(By.xpath("//input[@placeholder='Email']")).click();

		Robot robot = new Robot();
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		robot.mouseWheel(10);

		// JavascriptExecutor js=(JavascriptExecutor) driver;

		// js.executeScript("arguments[0].scrollIntoView(true);",element);

	}

}
