package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomeTwoPage {

	private WebDriver driver;

    // Locators
    private By searchBox = By.name("q");
    private By resultsStats = By.id("result-stats");

    public GoogleHomeTwoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getSearchBox() {
        return driver.findElement(searchBox);
    }

    public WebElement getResultsStats() {
        return driver.findElement(resultsStats);
    }
	
}
