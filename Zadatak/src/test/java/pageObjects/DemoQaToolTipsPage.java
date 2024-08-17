package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoQaToolTipsPage {

	@FindBy(id = "toolTipButton")
	private WebElement hoverButton;
	
	@FindBy(xpath = "//div[@class='tooltip-inner']")
	private WebElement toolTipText;
	
	public DemoQaToolTipsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getHoverButton() {
		return hoverButton;
	}

	public WebElement getToolTipText() {
		return toolTipText;
	}
	
}
