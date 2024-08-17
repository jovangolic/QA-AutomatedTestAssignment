package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoQaDroppablePage {

	@FindBy(id="draggable")
	private WebElement dragMeBox;
	
	@FindBy(id="droppable")
	private WebElement dropHereBox;
	
	public DemoQaDroppablePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getDragMeBox() {
		return dragMeBox;
	}

	public WebElement getDropHereBox() {
		return dropHereBox;
	}
}
