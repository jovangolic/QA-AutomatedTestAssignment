package pageEvents;

import org.openqa.selenium.WebDriver;

import pageObjects.OrangeHrmDashboardPage;

public class OrangeHrmDashboardPageEvents {

	
	private WebDriver driver;
	
	private OrangeHrmDashboardPage orangeHrmDashboardPage;
	
	public OrangeHrmDashboardPageEvents(WebDriver driver) {
		this.driver = driver;
		this.orangeHrmDashboardPage = new OrangeHrmDashboardPage(driver);
	}
	//navigiranje ka recruitment stranici
	public void navegateToRecruitmentPage() {
		orangeHrmDashboardPage.getRecruitmentmenu().click();
	}
}

