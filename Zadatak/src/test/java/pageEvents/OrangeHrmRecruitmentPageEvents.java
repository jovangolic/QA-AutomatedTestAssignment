package pageEvents;

import java.util.logging.Logger;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Level;


import pageObjects.AddCandidatePage;
import pageObjects.OrangeHrmRecruitmentPage;

public class OrangeHrmRecruitmentPageEvents {

	private WebDriver driver;
	
	private OrangeHrmRecruitmentPage orangeHrmRecruitmentPage;
	private WebDriverWait wait;
	private static final Logger logger = Logger.getLogger(OrangeHrmRecruitmentPageEvents.class.getName());
	
	public OrangeHrmRecruitmentPageEvents(WebDriver driver) {
		this.driver = driver;
		this.orangeHrmRecruitmentPage = new OrangeHrmRecruitmentPage(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}
	
	public int getCandidateCount() {
        return orangeHrmRecruitmentPage.getNumberOfCandidates();
    }
	
	public void openCandidates() {
		orangeHrmRecruitmentPage.openCandidates();
	}
    
	public void addNewCandidate(String firstName, String lastName, String email, String vacancy) {
        try {
            orangeHrmRecruitmentPage.clickAddButton();
            AddCandidatePage addCandidatePage = new AddCandidatePage(driver);
            addCandidatePage.openAddCandidateForm();
            addCandidatePage.enterFirstName(firstName);
            addCandidatePage.enterLastName(lastName);
            addCandidatePage.enterEmail(email);
            addCandidatePage.selectVacancy(vacancy);
            addCandidatePage.clickSaveButton();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to add new candidate: " + e.getMessage(), e);
        }
    }
}
