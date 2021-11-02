package testNGPractice;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListenerEx implements ITestListener{

	public void onFinish(ITestContext result) {
		System.out.println("Test suite is finished with execution");
		
	}

	public void onStart(ITestContext result) {
		System.out.println("Test suite is ready to start execution");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("TestCase failed with name: "+ result.getName());
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("TestCase skipped with name: "+ result.getName());
		
	}

	public void onTestStart(ITestResult result) {
		System.out.println("TestCase started with name: "+ result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("TestCase passed with name: "+ result.getName());
		
	}

}
