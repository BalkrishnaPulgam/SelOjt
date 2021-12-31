package testNGPractice;


import org.testng.annotations.Test;

public class Prac {
	@Test
	public void loginwithouthPriority() {
		System.out.println("loginwithouthPriorityin");
		
	}
	
	@Test
	public void dashwithouthPriority() {
		System.out.println("dashwithouthPriority");
	}
	
	@Test(priority=1) 
	public void user() {
		System.out.println("user");
	}
	
	@Test(priority=1)
	public void login1() {
		System.out.println("login");
		
	}
}
