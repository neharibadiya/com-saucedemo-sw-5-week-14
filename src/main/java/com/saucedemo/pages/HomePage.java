package com.saucedemo.pages;

import com.aventstack.extentreports.Status;
import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//span[@class='title']")
    WebElement headingText;
    @CacheLookup
    @FindBy(xpath = "//div[@class='inventory_item']")
    List<WebElement> number;
    public String getHeadingText(){
        String message = getTextFromElement(headingText);
        CustomListeners.test.log(Status.PASS,"Get HeadingText");
        Reporter.log("Get heading text " + headingText.toString());
        return message;
    }
    public int countingItems(){
        CustomListeners.test.log(Status.PASS,"counting items");
        Reporter.log("counting items " + this.number.toString());
        return countingItems();
    }
}
