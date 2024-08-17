package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHrmLoginPage {
	
	private WebDriver driver;

	
	@FindBy(xpath = "//input[@id='btnLogin']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//a[contains(text(),'Log Out')]")
	private WebElement logoutButton;
	
	public OrangeHrmLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickLoginButton() {
        loginButton.click();
    }
	
	public void clickLogoutButton() {
		logoutButton.click();
	}
}
