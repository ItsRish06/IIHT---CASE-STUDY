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

    @FindBy(id = "first_name")
    WebElement username;

    @FindBy(id = "icon_telephone")
    WebElement password;

    @FindBy(xpath="//a[text()='asd']")
    WebElement display_username;

    @FindBy(xpath = "//button[@class='btn waves-effect waves-light']")
    WebElement loginBtn;

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    public void loginPage(){
        getPage("https://travel.testsigma.com/login");
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
        return wait.until(ExpectedConditions.visibilityOf(display_username)).getText();
    }

    public boolean validateInvalidLogin(){
        boolean result;
        WebDriverWait wait = new WebDriverWait(driver,5);
        try {
            wait.until(ExpectedConditions.visibilityOf(display_username)).getText();
            result = false;
        }catch(Exception e){
            result = true;
        }
        return result;
    }

    public void clickLogin(){
        loginBtn.click();
    }
}
