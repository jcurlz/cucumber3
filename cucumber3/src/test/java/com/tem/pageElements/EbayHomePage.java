package com.tem.pageElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EbayHomePage {
    
    // Define WebElements using @FindBy
    @FindBy(linkText = "Advanced")
    public WebElement advancedSearchLink;
    
    @FindBy(id = "gh-logo")  
    // Example of another potential locator
    public WebElement ebayLogo;
}
