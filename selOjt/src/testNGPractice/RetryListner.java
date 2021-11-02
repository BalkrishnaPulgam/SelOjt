package testNGPractice;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListner implements IRetryAnalyzer{
	
	int count=1;
	int maxLimit=3;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(count<maxLimit) {
			count++;
			return true;
		}
		return false;
	}

}
