package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoQaHomePage {

	//h5[text()='Interactions']
	
	@FindBy(xpath = "//div[5]//div[1]//div[2]")
	private WebElement intersectionsMeni;
	
	@FindBy(id = "draggable")
	private WebElement draggable;
	
	
	//span[text()='Droppable']
	@FindBy(xpath = "//span[normalize-space()='Droppable']")
	private WebElement droppableLink;
	
	//h5[text()='Widgets']
	@FindBy(xpath="//body/div[@id='app']/div[contains(@class,'body-height')]/div[contains(@class,'container playgound-body')]/div[contains(@class,'row')]/div[contains(@class,'col-md-3')]/div[@class='left-pannel']/div[@class='accordion']/div[4]/span[1]/div[1]/div[1]")
	private WebElement widgetsSection;
	
	//span[text()='Tool Tips']
	@FindBy(xpath = "//span[normalize-space()='Tool Tips']")
	private WebElement toolTipsLink;
	
	//button[@id='toolTipButton']
	//@FindBy(id = "toolTipButton")
	@FindBy(xpath = "button[@id='toolTipButton']")
	private WebElement hoverButton;
	
	public DemoQaHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getIntersectionsMeni() {
		return intersectionsMeni;
	}

	public WebElement getDraggable() {
		return draggable;
	}

	public WebElement getDroppableLink() {
		return droppableLink;
	}

	public WebElement getWidgetsSection() {
		return widgetsSection;
	}

	public WebElement getToolTipsLink() {
		return toolTipsLink;
	}

	public WebElement getHoverButton() {
		return hoverButton;
	}
}
