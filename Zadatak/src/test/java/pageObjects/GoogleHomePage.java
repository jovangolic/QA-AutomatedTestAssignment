package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage {

	@FindBy(name = "q")
	private WebElement searchBox;
	
	@FindBy(xpath = "(//h3)[1]")
    private WebElement firstResult;
	
	public GoogleHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getFirstResult() {
		return firstResult;
	}
}
