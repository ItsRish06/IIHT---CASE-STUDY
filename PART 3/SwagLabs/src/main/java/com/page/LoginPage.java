package com.page;

import com.base.Base;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Base {
    @FindBy(id = "login-button")
    WebElement getLoginBtn;

    @FindBy(id = "user-name")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(xpath="/html/body/div/div/div/div[1]/div[2]/span")
    WebElement products;

    @FindBy(id = "login-button")
    WebElement loginBtn;

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    public void loginPage(){
        getPage("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    public void enterLoginData(String uname,String pass){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(uname);
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(pass);
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public String validateSuccessLogin(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        return wait.until(ExpectedConditions.visibilityOf(products)).getText();
    }

    public boolean validateInvalidLogin(){
        boolean result;
        WebDriverWait wait = new WebDriverWait(driver,5);
        try {
            wait.until(ExpectedConditions.visibilityOf(products)).getText();
            result = true;
        }catch(Exception e){
            result = false;
        }
        return result;
    }

    public void clickLogin(){
        loginBtn.click();
    }
}
