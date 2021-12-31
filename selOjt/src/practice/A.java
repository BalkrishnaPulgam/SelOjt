package practice;




import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class A {
	static WebDriver driver = null;

	public static void main(String args[]) throws InterruptedException {

		// for private window

		
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		driver = new ChromeDriver();
		

		Dimension d=new Dimension(500,600);
		driver.manage().window().setSize(d);
	}

}
