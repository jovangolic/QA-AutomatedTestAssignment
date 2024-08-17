package utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class SuiteListener implements ITestListener, IAnnotationTransformer{

	private static ExtentReports extent;
	private static ExtentTest test;
	
	// Ova metoda se poziva pre nego što suite počne
    public void onStart(ITestContext context) {
        ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/ExtentReport.html");
        reporter.config().setDocumentTitle("Automation Report");
        reporter.config().setReportName("Functional Testing");
        
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Jovan Golic");
    }
	
	public void onTestStart(ITestResult result) {
	    test = extent.createTest(result.getMethod().getMethodName());
	}
	
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test passed");
	}
	
	
	public void onTestFailure(ITestResult result) {
		//za skladistenje screenshot-ova
		String filename = System.getProperty("user.dir") +File.separator+"screenshots"+File.separator+result.getMethod().getMethodName()+".png";
		File screenshot = ((TakesScreenshot)BaseTest.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(filename));
			test.log(Status.FAIL,"Test failed. Screenshot saved at: " + filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		//referenciranje na klasu RetryAnalyzer
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}
	
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test skipped");
	}
	
	public void onFinish(ITestContext context) {
		extent.flush();
	  }
}
	
