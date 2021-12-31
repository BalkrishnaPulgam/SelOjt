package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class RegisterPageTest {
	WebDriver driver;
	RegisterPage rp=new RegisterPage(driver);
	@Test
	public void register01() {
		
		rp.enterFirstName("sumit");
		rp.enterLastName("verma");
		rp.selectGender("male");
		
		
		List<String> values=new ArrayList<String>();
		values.add("Movies");
	}
	
	@Test
	public void register02() {
	
		rp.enterFirstName("sumit11");
		rp.enterLastName("verma111");
		rp.selectGender("female");
		
		
		List<String> values=new ArrayList<String>();
		values.add("Cricket");
	}

}
