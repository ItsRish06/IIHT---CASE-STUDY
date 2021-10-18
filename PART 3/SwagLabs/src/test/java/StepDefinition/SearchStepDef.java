package StepDefinition;

import com.page.LoginPage;
import org.testng.Assert;

import com.base.Base;
import com.page.SearchFunction;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchStepDef extends Base {
    LoginPage l;
    SearchFunction s;
    String URL = "https://www.saucedemo.com";


    @Before("@search")
    public void initial(){
        initialization();
        s =  new SearchFunction();
        l = new LoginPage();

    }


    @Given("User is on homepage")
    public void user_is_on_homepage() {
        getPage(URL);
        l.enterLoginData("standard_user","secret_sauce");
        l.clickLogin();
    }


    @When("User selects Name \\(A to Z) category")
    public void user_clicks_on_a_z_category() {
        s.selectCategory("Name (A to Z)");
    }

    @Then("User should be able to successfully sort products by Name \\(A to Z) category.")
    public void user_should_be_able_to_successfully_sort_products_by_a_z_category() {
        String expectedResult = "Sauce Labs Backpack";
        String actualResult = s.validateSearch("Name (A to Z)") ;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @When("User selects Name \\(Z to A) category")
    public void user_clicks_on_z_a_category() {
        s.selectCategory("Name (Z to A)");
    }

    @Then("User should be able to successfully sort products by Name \\(Z to A) category.")
    public void user_should_be_able_to_successfully_sort_products_by_z_a_category() {
        String expectedResult = "Test.allTheThings() T-Shirt (Red)";
        String actualResult = s.validateSearch("Name (Z to A)") ;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @When("User selects Price \\(low to high) category")
    public void user_clicks_on_low_high_category() {
        s.selectCategory("Price (low to high)");
    }

    @Then("User should be able to successfully sort products by Price \\(low to high) category.")
    public void user_should_be_able_to_successfully_sort_products_by_low_high_category() {
        String expectedResult = "Sauce Labs Onesie";
        String actualResult = s.validateSearch("Price (low to high)") ;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @When("User selects Price \\(high to low) category")
    public void user_clicks_on_high_low_category() {
        s.selectCategory("");
    }

    @Then("User should be able to successfully sort products by Price \\(high to low) category.")
    public void user_should_be_able_to_successfully_sort_products_by_high_low_category() {
        String expectedResult = "Sauce Labs Fleece Jacket";
        String actualResult = s.validateSearch("") ;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @When("User clicks on a product")
    public void user_clicks_on_a_product() {
        s.clickProduct();
    }

    @When("User clicks on add to cart button")
    public void user_clicks_on_add_to_cart_button() {
        s.clickAddCart();
    }

    @When("User clicks on cart button")
    public void user_clicks_on_cart_button() {
        s.clickCart();
    }

    @Then("User should be able to successfully see the product in their cart.")
    public void user_should_be_able_to_successfully_see_the_product_in_their_cart() {
        String actualResult = s.validateAddCart();
        String expectedResult = s.product;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @After("@search")
    public void finish() {
        s.tearDown();
    }

}
