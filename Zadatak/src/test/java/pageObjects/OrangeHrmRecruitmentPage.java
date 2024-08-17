package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHrmRecruitmentPage {
	
	private WebDriver driver;

	@FindBy(xpath = "//li[@id='left_menu_item_15']//a[1]//span[1]")
	private WebElement recruitment;
	
	//@FindBy(id = "menu_recruitment_viewCandidates")
	@FindBy(xpath = "//a[@class='top-level-menu-item active']")
    private WebElement candidatesLink;
    
	@FindBy(xpath = "//div[@class='oxd-status-tab-panel-header']//div[1]")
    private WebElement addCandidate;
    
    @FindBy(xpath = "//table[@id='resultTable']//tr")
    private List<WebElement> candidateRows;
	
	public OrangeHrmRecruitmentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getRecruitment() {
		return recruitment;
	}
	
	public void openCandidates() {
        candidatesLink.click();
    }
    
    public int getNumberOfCandidates() {
        return candidateRows.size();
    }
    
    public void clickAddButton() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addCandidate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='oxd-status-tab-panel-header']//div[1]")));
        addCandidate.click();
    }
}
