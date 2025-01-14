package com.tem.stepDefinitions;
import com.tem.pageActions.EbayHomePageActions;
import com.tem.testUtils.CommonSteps;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Scenario1 {

    private WebDriver driver;
    private EbayHomePageActions ebayHomePageActions;
    
    // Create a logger instance
    private static final Logger logger = LoggerFactory.getLogger(Scenario1.class);

    public Scenario1(CommonSteps url) {
        this.driver = url.returnURL();
        ebayHomePageActions = new EbayHomePageActions(driver);
    }

    @Given("I am on Ebay Homepage")
    public void i_am_on_ebay_homepage() {
    	System.out.println("I am on Ebay Homepage");
        logger.info("I am on Ebay Homepage");  // Log info message
        Assert.assertTrue("Ebay logo should be visible", ebayHomePageActions.isLogoDisplayed());
    }

    @When("I click on Advanced search link search")
    public void i_click_on_advanced_search_link_search() {
    	System.out.println("I click on Advanced search link search");
    	logger.info("I click on Advanced search link search");  // Log info message
        ebayHomePageActions.clickAdvancedSearch();
    }

    @Then("I navigate to search page")
    public void i_navigate_to_search_page() {
       	System.out.println("I navigate to search page");   
    	logger.info("I navigate to search page");  // Log info message
    	String expectedURL = "https://www.ebay.com/sch/ebayadvsearch";
        //String expectedURL = "https://www.ebay.com/sch/ebayadvsearch12345";
        String actualURL = driver.getCurrentUrl();
        try {
            Assert.assertEquals("URLs do not match", expectedURL, actualURL);
            logger.info("Test Passed: Navigation successful");
        } catch (Exception e) {
            logger.error("Test Failed: Navigation failed", e);  // Log error with exception
            Assert.fail();
        }
    }
}
