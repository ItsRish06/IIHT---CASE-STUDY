package com.page;

import com.base.Base;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SearchFunction extends Base {

    public static String product;


    @FindBy(xpath = "//div[@class='inventory_details_desc_container']/button")
    WebElement addToCart;

    @FindBy(className = "shopping_cart_link")
    WebElement cart;


    public SearchFunction() {
        PageFactory.initElements(driver, this);
    }



    public void selectCategory(String category) {
        if(category == "Name (A to Z)") {
            WebDriverWait wait = new WebDriverWait(driver,10);
            WebElement sel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("product_sort_container")));
            Select s = new Select(sel);
            s.selectByVisibleText("Name (A to Z)");
        }
        else if(category == "Name (Z to A)") {
            WebDriverWait wait = new WebDriverWait(driver,10);
            WebElement sel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("product_sort_container")));
            Select s = new Select(sel);
            s.selectByVisibleText("Name (Z to A)");
        }
        else if(category == "Price (low to high)") {
            WebDriverWait wait = new WebDriverWait(driver,10);
            WebElement sel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("product_sort_container")));
            Select s = new Select(sel);
            s.selectByVisibleText("Price (low to high)");
        }
        else {
            WebDriverWait wait = new WebDriverWait(driver,10);
            WebElement sel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("product_sort_container")));
            Select s = new Select(sel);
            s.selectByVisibleText("Price (high to low)");
        }


    }


    public String validateSearch(String category) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        if(category == "Name (A to Z)") {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='inventory_item']//div[2]/div/a/div")));
            return driver.findElement(By.xpath("//div[@class='inventory_item']//div[2]/div/a/div")).getText();

        }
        else if(category == "Name (Z to A)") {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='inventory_item']//div[2]/div/a/div")));
            return driver.findElement(By.xpath("//div[@class='inventory_item']//div[2]/div/a/div")).getText();
        }
        else if(category == "Price (low to high)") {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='inventory_item']//div[2]/div/a/div")));
            return driver.findElement(By.xpath("//div[@class='inventory_item']//div[2]/div/a/div")).getText();
        }
        else {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='inventory_item']//div[2]/div/a/div")));
            return driver.findElement(By.xpath("//div[@class='inventory_item']//div[2]/div/a/div")).getText();
        }
    }

    public void clickProduct() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='inventory_item']//div[2]/div/a/div")));
        driver.findElement(By.xpath("//div[@class='inventory_item']//div[2]/div/a/div")).click();
    }

    public void clickAddCart() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='row']/div[2]/div[2]/div/a"))).click();
        wait.until(ExpectedConditions.visibilityOf(addToCart)).click();

    }

    public void clickCart() {
        product = driver.findElement(By.xpath("//div[@class='inventory_details_desc_container']/div")).getText();
        cart.click();
    }

    public String validateAddCart() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("inventory_item_name")));
        List<WebElement> products = driver.findElements(By.className("inventory_item_name"));
        //List<WebElement> products = (List<WebElement>) productList;
        System.out.println(products.size());
        System.out.println(products);
        System.out.println((products.get(0).getText()) + "|||" + product);
        System.out.println((products.get(0).getText()).equals(product));
        return products.get(0).getText();
    }


}
