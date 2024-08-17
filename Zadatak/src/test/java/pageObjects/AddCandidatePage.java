package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AddCandidatePage {

	private WebDriver driver;
	private WebDriverWait wait;
	private static final Logger logger = Logger.getLogger(AddCandidatePage.class.getName());
	
	@FindBy(xpath = "//div[@class='oxd-status-tab-panel-header']//div[1]")
	private WebElement addCandidateButton;
	
	@FindBy(xpath = "//input[@id='addCandidateForm_firstName']")
    private WebElement firstNameField;
    
    @FindBy(xpath = "//input[@id='addCandidateForm_lastName']")
    private WebElement lastNameField;
    
    @FindBy(xpath = "//input[@id='addCandidateForm_email']")
    private WebElement emailField;
    
    @FindBy(xpath = "//div[@class='select-placeholder']")
    private WebElement vacancyDropdown;
    
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;
    
    public AddCandidatePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
        logger.info("Initialized AddCandidatePage");
    }
    
    public void openAddCandidateForm() {
        try {
            WebElement addCandidateButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='oxd-status-tab-panel-header']//div[1]")));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", addCandidateButton);
            logger.info("Clicked on Add Candidate button using JavaScript.");
            wait.until(ExpectedConditions.visibilityOf(firstNameField));
            logger.info("Add Candidate form is visible.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to open Add Candidate form: " + e.getMessage(), e);
        }
    }

    public void enterFirstName(String firstName) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='addCandidateForm_firstName']")));
            element.sendKeys(firstName);
            logger.info("Entered first name: " + firstName);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to enter first name: " + e.getMessage(), e);
        }
    }

    public void enterLastName(String lastName) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='addCandidateForm_lastName']")));
            element.sendKeys(lastName);
            logger.info("Entered last name: " + lastName);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to enter last name: " + e.getMessage(), e);
        }
    }

    public void enterEmail(String email) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='addCandidateForm_email']")));
            element.sendKeys(email);
            logger.info("Entered email: " + email);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to enter email: " + e.getMessage(), e);
        }
    }

    public void selectVacancy(String vacancy) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='select-placeholder']")));
            new Select(element).selectByVisibleText(vacancy);
            logger.info("Selected vacancy: " + vacancy);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to select vacancy: " + e.getMessage(), e);
        }
    }

    public void clickSaveButton() {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
            element.click();
            logger.info("Clicked on Save button.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to click Save button: " + e.getMessage(), e);
        }
    }
}
