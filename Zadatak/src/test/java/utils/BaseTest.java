package utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	@BeforeTest
	public void beforeTestMethod() {
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator+"reports"+File.separator+"ExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		sparkReporter.config().setTheme(Theme.DARK);
		//extent.setSystemInfo("HostName", null);
		//extent.setSystemInfo("UserName", null);
		sparkReporter.config().setDocumentTitle("Automation Report");
	}
	
	//ova metoda omogucava izvrsavanje testova u razlicitim pretrazivacima
	@Parameters("browser")
	@BeforeMethod
	public void beforeMethod(@Optional("chrome") String browser, Method testMethod) {
		
		logger = extent.createTest(testMethod.getName());
		setUpDriver(browser);
		driver.manage().window().maximize();
		//task 1 ako zelih da pokrenes samo otkomentarisi
		//driver.get(Constants.DEMO_QA_URL);
		//task 2
		driver.get(Constants.GOOGLE_URL);
		//task 3
		//driver.get(Constants.ORANGE_HRM_URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			//logovanje neuspeha u izvestaju
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed",ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed",ExtentColor.RED));
			// Uzimanje screenshot-a ako test ne uspe
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				//definisanje putanje za cuvanje slike
				String screenshotPath = System.getProperty("user.dir") + File.separator+"screenshots"+File.separator+result.getName()+".png";
				// Kreiranje folder za screenshot-ove ako ne postoji
	            File screenshotDir = new File(System.getProperty("user.dir") + File.separator + "screenshots");
	            if (!screenshotDir.exists()) {
	                screenshotDir.mkdirs();
	            }
	            // Snimanje screenshot u definisanu putanju
	            File destinationFile = new File(screenshotPath);
	            FileUtils.copyFile(screenshot, destinationFile);
	            //dodavanje slike u ExtentReport izvestaj
	            logger.addScreenCaptureFromPath(screenshotPath, "Test case failure screenshot");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		}
		else if(result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Test Case Passed", ExtentColor.GREEN));
		}
		driver.quit();
	}
	
	@AfterTest
	public void afterTest() {
		extent.flush();
	}
	
	//metoda za postavljanje driver-a koji ce se koristiti u testiranju
	public void setUpDriver(String browser) {
		switch(browser.toLowerCase()) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			default:
				throw new IllegalArgumentException("Browser \"" + browser + "\" is not supported.");
		}
	}
	
	//ovo je metoda za snimke ekrana - screenshot
	public void takeScreenshot(String filename) {
		//kreiranje formatiranog datuma za dodavanje u naziv fajl
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(screenshotFile, new File("screenshots/" + filename+"_"+timestamp+".png"));
		}
		catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
	}
	
	public static String getCurrentDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
}
