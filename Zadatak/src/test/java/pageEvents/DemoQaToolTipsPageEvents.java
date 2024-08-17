package pageEvents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import pageObjects.DemoQaToolTipsPage;

public class DemoQaToolTipsPageEvents {

private WebDriver driver;
	
	private DemoQaToolTipsPage toolTipsPage;
	
	public DemoQaToolTipsPageEvents(WebDriver driver) {
		this.driver = driver;
		this.toolTipsPage = new DemoQaToolTipsPage(driver);
	}
	
	public void hoverOverButton() {
		Actions actions = new Actions(driver);
		actions.moveToElement(toolTipsPage.getHoverButton()).perform();
	}
	
	public String getToolTipText() {
		return toolTipsPage.getToolTipText().getText();
	}
	
}
