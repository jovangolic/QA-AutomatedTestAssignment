package pageEvents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import pageObjects.DemoQaDroppablePage;

public class DemoQaDroppablePageEvents {

private WebDriver driver;
	
	private DemoQaDroppablePage droppablePage;
	
	public DemoQaDroppablePageEvents(WebDriver driver) {
		this.driver = driver;
		this.droppablePage = new DemoQaDroppablePage(driver);
	}
	//izvrsavanje drag and drop
	public void performDragAndDrop() {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(droppablePage.getDragMeBox(), droppablePage.getDropHereBox()).perform();;
	}
	
	public String getDropText() {
		return droppablePage.getDropHereBox().getText();
	}
	
}
