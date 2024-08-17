package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHrmDashboardPage {
	
	private WebDriver driver;
	private WebDriverWait wait;

	//span[text()='Recruitment']
	@FindBy(xpath = "//li[@id='left_menu_item_15']//a[1]//span[1]")
	private WebElement recruitmentMenu;
	
	@FindBy(xpath = "//a[@class='name']")
	private WebElement userIcon;

	@FindBy(xpath = "//a[contains(text(),'Log Out')]")
    private WebElement logoutButton;
	
	public OrangeHrmDashboardPage(WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}

	public WebElement getRecruitmentmenu() {
		return recruitmentMenu;
	}
	
	public void clickUserIcon() {
        userIcon.click();
    }

    public void clickLogoutButton() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	wait.until(ExpectedConditions.visibilityOf(logoutButton));
        logoutButton.click();
    }
}


