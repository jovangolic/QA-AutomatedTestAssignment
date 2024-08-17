package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	private int count = 0;
	private static final int retryCount = 1;
	
	@Override
	public boolean retry(ITestResult result) {
		while(count < retryCount) {
			count++;
			return true;
		}
		return false;
	}
}
