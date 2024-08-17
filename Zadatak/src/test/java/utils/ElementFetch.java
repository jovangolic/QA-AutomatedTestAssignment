package utils;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import enumeration.IdentifierType;

public class ElementFetch {

	public WebElement getWebElement(IdentifierType identifierType, String identifierValue) {
		try {
			switch (identifierType) {
			case XPATH:
				return BaseTest.driver.findElement(By.xpath(identifierValue));
				
			case CSS:
				return BaseTest.driver.findElement(By.cssSelector(identifierValue));	
			case ID:
				return BaseTest.driver.findElement(By.id(identifierValue));
			case NAME:
				return BaseTest.driver.findElement(By.name(identifierValue));
			case TAGNAME:
				return BaseTest.driver.findElement(By.tagName(identifierValue));	
			default:
				throw new IllegalArgumentException("Invalid identifier type: " + identifierType);
			}
		}
		catch (NoSuchElementException e) {
	        System.out.println("Element not found with " + identifierType + ": " + identifierValue);
	        return null;
	    }
	}
	public List<WebElement> getWebElements(IdentifierType identifierType, String identifierValue) {
		try {
			switch (identifierType) {
			case XPATH:
				return BaseTest.driver.findElements(By.xpath(identifierValue));
				
			case CSS:
				return BaseTest.driver.findElements(By.cssSelector(identifierValue));	
			case ID:
				return BaseTest.driver.findElements(By.id(identifierValue));
			case NAME:
				return BaseTest.driver.findElements(By.name(identifierValue));
			case TAGNAME:
				return BaseTest.driver.findElements(By.tagName(identifierValue));	
			default:
				throw new IllegalArgumentException("Invalid identifier type: " + identifierType);
			}
		}
		catch (NoSuchElementException e) {
	        System.out.println("Element not found with " + identifierType + ": " + identifierValue);
	        return null;
	    }
	}	
}
