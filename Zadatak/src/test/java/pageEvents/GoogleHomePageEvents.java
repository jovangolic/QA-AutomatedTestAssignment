package pageEvents;

import org.openqa.selenium.WebDriver;

import pageObjects.GoogleHomePage;

public class GoogleHomePageEvents {

	private WebDriver driver;
	private GoogleHomePage googleHomePage;
	
	public GoogleHomePageEvents(WebDriver driver) {
		this.driver = driver;
		this.googleHomePage = new GoogleHomePage(driver);
	}
	//pretraga
	public void searchFor(String query) {
		googleHomePage.getSearchBox().sendKeys(query);
		googleHomePage.getSearchBox().submit();
	}
	//klik na prvi rezultat metoda
	public void clickFirstResult() {
		googleHomePage.getFirstResult().click();
	}
	
}
