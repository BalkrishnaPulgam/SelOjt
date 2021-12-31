package testNGPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTest {
	
	@Test(priority=-1)
	public void login() {
		System.out.println("login");
		Assert.assertTrue(false, "failed");
	}
	
	@Test(priority=0,dependsOnMethods = "login")
	public void dash() {
		System.out.println("dash");
	}
	
	@Test(priority=1,dependsOnMethods = "dash")  // bydefault alwaysRun=false  & enabled=true
	public void user() {
		System.out.println("user");
	}
	
	@Test(priority=3,enabled=false,alwaysRun=true)
	public void login1() {
		System.out.println("login");
		Assert.assertTrue(false, "failed");
	}

}
