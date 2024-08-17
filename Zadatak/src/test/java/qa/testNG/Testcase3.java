package qa.testNG;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageEvents.OrangeHrmDashboardPageEvents;
import pageEvents.OrangeHrmLoginPageEvents;
import pageEvents.OrangeHrmRecruitmentPageEvents;
import pageObjects.OrangeHrmDashboardPage;
import pageObjects.OrangeHrmRecruitmentPage;
import utils.BaseTest;


public class Testcase3 {
  
	private OrangeHrmLoginPageEvents loginPageEvents;
	private OrangeHrmDashboardPageEvents dashboardPageEvents;
	private OrangeHrmRecruitmentPageEvents recruitmentPageEvents;
	private OrangeHrmRecruitmentPage recruitmentPage;
	private OrangeHrmDashboardPage dashboardPage;
	private WebDriver driver;
	
	//privatna klasa jer sam hteo da imam samo za ovaj test njegov driver
	private class WebDriverManager{
		public WebDriver setUpDriver(String browser) {
			WebDriver localDriver = null;
			switch (browser.toLowerCase()) {
			case "chrome": 
				io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
				localDriver = new ChromeDriver();
				break;
			case "firefox":
				io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
				localDriver = new FirefoxDriver();
				break;
			case "edge":
				io.github.bonigarcia.wdm.WebDriverManager.edgedriver().setup();
				localDriver = new EdgeDriver();
				break;
			default:
				throw new IllegalArgumentException("Browser \"" + browser + "\" is not supported.");
			}
			return localDriver;
		}
	}
	
	@BeforeMethod
	@Parameters("browser")
	public void setUp(@Optional("chrome") String browser) {
		WebDriverManager manager = new WebDriverManager();
		if (driver == null) {
            //throw new RuntimeException("WebDriver initialization failed.");
			driver = manager.setUpDriver(browser);
        }
		driver.manage().window().maximize();
		driver.get("https://orangehrm-demo-7x.orangehrmlive.com/");
		loginPageEvents = new OrangeHrmLoginPageEvents(driver);
		dashboardPageEvents = new OrangeHrmDashboardPageEvents(driver);
		recruitmentPageEvents = new OrangeHrmRecruitmentPageEvents(driver);
		dashboardPage = new OrangeHrmDashboardPage(driver);
		recruitmentPage = new OrangeHrmRecruitmentPage(driver);
	}
	@Test
	public void testAddAndRemoveCandidate() throws InterruptedException {
		loginPageEvents.loginPageButton();
        dashboardPageEvents.navegateToRecruitmentPage();      
        recruitmentPageEvents.openCandidates();
        int initialCandidateCount = recruitmentPageEvents.getCandidateCount();  
        recruitmentPage.clickAddButton();
        recruitmentPageEvents.addNewCandidate(
            "QA", "Automation - " + getCurrentDate(), "qa@example.com", "Vacancy for Customer Support Specalist - USA"
        );  
        System.out.println("Number of candidates are: " + initialCandidateCount);
        int newCandidateCount = recruitmentPageEvents.getCandidateCount();
        Assert.assertEquals(newCandidateCount, initialCandidateCount + 1, "Candidate count should have increased by 1");
        int finalCandidateCount = recruitmentPageEvents.getCandidateCount();
        Assert.assertEquals(finalCandidateCount, newCandidateCount - 1, "Candidate count should have decreased by 1");
        dashboardPage.clickUserIcon();
        dashboardPage.clickLogoutButton();
	}
	
	@AfterMethod
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
	
	private static String getCurrentDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
}
