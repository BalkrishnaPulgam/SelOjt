package testNGPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTest {
	
	@Test(priority=-1)
	public void login() {
		System.out.println("login");
		Assert.assertTrue(true, "failed");
	}
	
	@Test(priority=0)
	public void dash() {
		System.out.println("dash");
	}
	
	@Test(priority=1,dependsOnMethods = "login")
	public void user() {
		System.out.println("user");
	}

}
