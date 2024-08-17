package pageEvents;

import org.openqa.selenium.WebDriver;

import pageObjects.DemoQaHomePage;

public class DemoQaHomePageEvents {

private WebDriver driver;
	
	private DemoQaHomePage demoQaHomePage;
	
	public DemoQaHomePageEvents(WebDriver driver) {
		this.driver = driver;
		this.demoQaHomePage = new DemoQaHomePage(driver);
	}
	//navigacija ka droppable
	public void navigateToDroppable() {
		demoQaHomePage.getIntersectionsMeni().click();
		demoQaHomePage.getDroppableLink().click();
	}
	//navigacija ka tool tip
	public void navigateToToolTips() {
		demoQaHomePage.getWidgetsSection().click();
		demoQaHomePage.getToolTipsLink().click();
	}
	
}
