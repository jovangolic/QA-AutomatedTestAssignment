package qa.testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.DemoQaDroppablePage;
import pageObjects.DemoQaHomePage;
import pageObjects.DemoQaToolTipsPage;
import utils.BaseTest;

public class Testcase1 extends BaseTest {
	
	@BeforeMethod
	@Parameters("browser")
	public void setUp(@Optional("chrome") String browser) {
		setUpDriver(browser);
		driver.manage().window().maximize();
		driver.get("https://google.com/");
	}
  
	@Test
    public void testGoogleSearchAndDemoqa() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q"))).sendKeys("demoqa.com");
        driver.findElement(By.name("q")).submit();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[normalize-space()='DEMOQA']"))).click();
        DemoQaHomePage homePage = new DemoQaHomePage(driver);
        WebElement intersectionsMeni = wait.until(ExpectedConditions.elementToBeClickable(homePage.getIntersectionsMeni()));
        try {
            intersectionsMeni.click();
        } catch (Exception e) {
            // Ako regularan klik ne uspe, koristimo JavaScript izvršavanje klika
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", intersectionsMeni);
        }
        
        WebElement droppableLink = wait.until(ExpectedConditions.elementToBeClickable(homePage.getDroppableLink()));
        droppableLink.click();

        DemoQaDroppablePage droppablePage = new DemoQaDroppablePage(driver);
        wait.until(ExpectedConditions.visibilityOf(droppablePage.getDragMeBox()));
        new Actions(driver).dragAndDrop(droppablePage.getDragMeBox(), droppablePage.getDropHereBox()).perform();
        String droppedText = droppablePage.getDropHereBox().getText();
        System.out.println("Dropped text: " + droppedText);

        takeScreenshot("DragAndDrop");

        wait.until(ExpectedConditions.elementToBeClickable(homePage.getWidgetsSection())).click();
        //wait.until(ExpectedConditions.elementToBeClickable(homePage.getToolTipsLink())).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('fixedban').style.display='none';");
        WebElement toolTipsLink = wait.until(ExpectedConditions.elementToBeClickable(homePage.getToolTipsLink()));
        js.executeScript("arguments[0].click();", toolTipsLink);

        DemoQaToolTipsPage toolTipsPage = new DemoQaToolTipsPage(driver);
        wait.until(ExpectedConditions.visibilityOf(toolTipsPage.getHoverButton()));
        new Actions(driver).moveToElement(toolTipsPage.getHoverButton()).perform();
        String tooltipText = wait.until(ExpectedConditions.visibilityOf(toolTipsPage.getToolTipText())).getText();
        System.out.println("Tooltip text: " + tooltipText);

        takeScreenshot("Tooltip");

        Assert.assertEquals(droppedText, "Dropped!");
    }
	    @AfterMethod
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}
