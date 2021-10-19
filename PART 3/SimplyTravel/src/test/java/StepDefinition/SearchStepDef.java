package StepDefinition;

import com.page.LoginPage;
import io.cucumber.java.PendingException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.base.Base;
import com.page.SearchFunction;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchStepDef extends Base {
    String URL = "https://travel.testsigma.com/";


    @Before("@search")
    public void initial(){
        initialization();

    }

    @Given("^User is on homepage$")
    public void user_is_on_homepage() throws Throwable {
        getPage(URL);
    }

    @When("^User selects Price Low to High category$")
    public void user_selects_price_low_to_high_category() throws Throwable {
        WebDriverWait wait= new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sorter_btn"))).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='dropdown-menu custom-scroll show']/li[1]/a"))).click();
    }

    @When("^User selects Duration Low to High category$")
    public void user_selects_duration_low_to_high_category() throws Throwable {
        WebDriverWait wait= new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sorter_btn"))).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='dropdown-menu custom-scroll show']/li[2]/a"))).click();
    }

    @When("^User selects Departure Early category$")
    public void user_selects_departure_early_category() throws Throwable {
        WebDriverWait wait= new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sorter_btn"))).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='dropdown-menu custom-scroll show']/li[3]/a"))).click();
    }

    @When("^User selects Departure Delay category$")
    public void user_selects_departure_delay_category() throws Throwable {
        WebDriverWait wait= new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sorter_btn"))).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='dropdown-menu custom-scroll show']/li[4]/a"))).click();
    }

    @When("^User selects Departure Arrival Early category$")
    public void user_selects_departure_arrival_category() throws Throwable {
        WebDriverWait wait= new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sorter_btn"))).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='dropdown-menu custom-scroll show']/li[5]/a"))).click();
    }
    @When("^User selects Departure Arrival Delay category$")
    public void user_selects_departure_arrivalDelay_category() throws Throwable {
        WebDriverWait wait= new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sorter_btn"))).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='dropdown-menu custom-scroll show']/li[6]/a"))).click();
    }

    @When("^User selects Departure and Arrival location category$")
    public void user_selects_departure_and_arrival_location_category() throws Throwable {
        driver.findElement(By.id("departure_cities")).click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Los Angeles']"))).click();
        driver.findElement(By.id("arraival_cities")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='dropdown-menu fixed_dropdown left show']/a[3]"))).click();
    }

    @Then("^User should be able to successfully sort flights by Price Low to High category$")
    public void user_should_be_able_to_successfully_sort_flights_by_price_low_to_high_category() throws Throwable {
        String price = driver.findElement(By.xpath("//div[@class='splitVw clearfix']/div[3]/div[2]/span/span[2]")).getText();
        Assert.assertEquals(price,"37917");
    }

    @Then("^User should be able to successfully sort flights by Duration Low to High category$")
    public void user_should_be_able_to_successfully_sort_flights_by_duration_low_to_high_category() throws Throwable {
        String price = driver.findElement(By.xpath("//div[@class='splitVw clearfix']/div[3]/div/div/div/div[2]/div[3]/strong")).getText();
        Assert.assertEquals(price,"35000");
    }

    @Then("^User should be able to successfully sort flights by Departure Early category$")
    public void user_should_be_able_to_successfully_sort_flights_by_departure_early_category() throws Throwable {
        String price = driver.findElement(By.xpath("//div[@class='splitVw clearfix']/div[3]/div/div/div/div[2]/div/strong")).getText();
        Assert.assertEquals(price,"19:35");
    }

    @Then("^User should be able to successfully sort flights by Departure Delay category$")
    public void user_should_be_able_to_successfully_sort_flights_by_departure_delay_category() throws Throwable {
        String price = driver.findElement(By.xpath("//div[@class='splitVw clearfix']/div[3]/div/div/div/div[2]/div/strong")).getText();
        Assert.assertEquals(price,"20:35");
    }

    @Then("^User should be able to successfully sort flights by Arrival Early category$")
    public void user_should_be_able_to_successfully_sort_flights_by_arrival_early_category() throws Throwable {
        String price = driver.findElement(By.xpath("//div[@class='splitVw clearfix']/div[3]/div/div/div/div[2]/div[3]/strong")).getText();
        Assert.assertEquals(price,"02:25");
    }

    @Then("^User should be able to successfully sort flights by Arrival Delay category$")
    public void user_should_be_able_to_successfully_sort_flights_by_arrival_delay_category() throws Throwable {
        String price = driver.findElement(By.xpath("//div[@class='splitVw clearfix']/div[3]/div/div/div/div[2]/div[3]/strong")).getText();
        Assert.assertEquals(price,"04:25");
    }

    @Then("^User should be able to successfully search flights$")
    public void user_should_be_able_to_successfully_search_flights() throws Throwable {
        String price = driver.findElement(By.xpath("//div[@class='splitVw clearfix']/div[3]/div/div/div/div[2]/div[3]/span")).getText();
        Assert.assertEquals(price,"New York City");
    }



    @After("@search")
    public void finish() {
        tearDown();
    }

}
