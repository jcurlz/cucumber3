package com.tem.pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.tem.pageElements.EbayHomePage;

public class EbayHomePageActions {

	private WebDriver driver;
	private EbayHomePage ebayHomePage;

	// Constructor to initialize WebDriver and the Page Object
	public EbayHomePageActions(WebDriver driver) {
		this.driver = driver;
		ebayHomePage = new EbayHomePage();
		// Create instance of the Page Object
		PageFactory.initElements(driver, ebayHomePage);
		// Initialize the WebElements
	}

	// Method to click on the "Advanced" search link
	public void clickAdvancedSearch() {
		ebayHomePage.advancedSearchLink.click();
	}

	// Method to check if the Ebay logo is displayed
	public boolean isLogoDisplayed() {
		return ebayHomePage.ebayLogo.isDisplayed();
	}
}
