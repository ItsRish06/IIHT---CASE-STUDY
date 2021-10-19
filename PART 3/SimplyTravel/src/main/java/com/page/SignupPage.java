package com.page;

import com.base.Base;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SignupPage extends Base {
    @FindBy(id="name")
    WebElement firstName;


    @FindBy(id = "pass")
    WebElement password;

    @FindBy(id = "emailid")
    WebElement email;

    @FindBy(id = "phone")
    WebElement phone;

    @FindBy(id="address")
    WebElement address;

    @FindBy(id = "cpass")
    WebElement cpassword;


    @FindBy(xpath="//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")
    WebElement btn;

    @FindBy(id="btnid")
    WebElement signupBtn;

    @FindBy(xpath="//div[@class='dropdown-menu dropdown-menu-right']/a")
    WebElement display_username;


    JavascriptExecutor executor;


    public SignupPage() {
        this.executor = (JavascriptExecutor) this.driver;
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return driver.getTitle();
    }


    public void signup (String fullname, String emailid, String phoneNo, String add,String pass, String cpass){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(firstName));
        firstName.sendKeys(fullname);
        password.sendKeys(pass);
        cpassword.sendKeys(pass);
        email.sendKeys(emailid);
        phone.sendKeys(phoneNo);
        address.sendKeys(add);
        password.sendKeys(pass);
        cpassword.sendKeys(cpass);

    }

    public void clickSignUp() {
        signupBtn.click();
    }

    public String validateSignUp() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        return wait.until(ExpectedConditions.visibilityOf(display_username)).getText();
    }



}
