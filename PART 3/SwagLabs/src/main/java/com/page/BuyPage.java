package com.page;

import com.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuyPage extends Base {

    @FindBy(id="checkout")
    WebElement placeOrderBtn;

    @FindBy(id="continue")
    WebElement Continue;

    @FindBy(id="finish")
    WebElement finish;

    @FindBy(xpath = "//div[@id='orderModal']/div/div/div[3]/button[2]")
    WebElement purchaseBtn;

    @FindBy(id ="first-name")
    WebElement fName;

    @FindBy(id ="last-name")
    WebElement lName;

    @FindBy(id ="postal-code")
    WebElement zip;



    public BuyPage(){
        PageFactory.initElements(driver,this);
    }

    public void checkout(){
        placeOrderBtn.click();
    }

    public String validateDetailPage(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title"))).getText();
    }

    public void enterDetails(String firstName, String lastName, String zipCode){
        fName.sendKeys(firstName);
        lName.sendKeys(lastName);
        zip.sendKeys(zipCode);
    }

    public void clickContinue(){
        Continue.click();
    }
    public void clickFinish(){
        finish.click();
    }

    public String validatePurchase(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title"))).getText();

    }

}
