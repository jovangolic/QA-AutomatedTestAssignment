package pageEvents;

import org.openqa.selenium.WebDriver;

import pageObjects.OrangeHrmLoginPage;

public class OrangeHrmLoginPageEvents {

	private WebDriver driver;
	
	private OrangeHrmLoginPage orangeHrmLoginPage;
	
	public OrangeHrmLoginPageEvents(WebDriver driver) {
		this.driver = driver;
		this.orangeHrmLoginPage = new OrangeHrmLoginPage(driver);
	}
	
	public void loginPageButton() {
		orangeHrmLoginPage.clickLoginButton();
	}
	
	public void logoutPageButton() {
		orangeHrmLoginPage.clickLogoutButton();
	}
}
