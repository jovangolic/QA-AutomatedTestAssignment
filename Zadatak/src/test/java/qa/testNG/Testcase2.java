package qa.testNG;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.BaseTest;



public class Testcase2 extends BaseTest {
	
	@Test
    public void testGoogleSearchResultsCount() {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("cheese");
        searchBox.submit();
        WebElement resultsStats = driver.findElement(By.id("result-stats"));
        String resultsText = resultsStats.getText();
        int resultsCount = parseResultsCount(resultsText);
        int expectedCount = 777;
        Assert.assertEquals(resultsCount, expectedCount, "There is too much cheese on the internet");
    }
    
    private int parseResultsCount(String text) {
        String cleanedText = text.replaceAll("(?i)About|results|results", "").trim();
        cleanedText = cleanedText.replaceAll("[^0-9]", "");
        return cleanedText.isEmpty() ? 0 : Integer.parseInt(cleanedText);
    }
}
