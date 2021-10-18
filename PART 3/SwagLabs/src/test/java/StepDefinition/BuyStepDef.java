package StepDefinition;

import com.base.Base;
import com.page.BuyPage;
import com.page.LoginPage;
import com.page.SearchFunction;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class BuyStepDef extends Base {

    BuyPage bp;
    LoginPage l;
    SearchFunction s;

    @Before("@buy")
    public void initial(){
        initialization();
        bp = new BuyPage();
        l = new LoginPage();
        s = new SearchFunction();
    }

    @Given("^b\\-User is into cart$")
    public void buser_is_into_cart() throws Throwable {
        getPage("https://www.saucedemo.com");
        l.enterLoginData("standard_user","secret_sauce");
        l.clickLogin();
        s.clickProduct();
        s.clickAddCart();
        s.clickCart();
    }

    @When("^b\\-User clicks Checkout")
    public void buser_clicks_checkout() throws Throwable {
        bp.checkout();
    }

    @Then("^b\\-User Gets page For Details$")
    public void buser_gets_page_for_details() throws Throwable {
        String actualResult = bp.validateDetailPage();
        System.out.println(actualResult);
        String expectedResult = "CHECKOUT: YOUR INFORMATION";
        Assert.assertEquals(actualResult,expectedResult);
    }


    @Given("^b\\-User is on cart and Clicks checkout$")
    public void buser_is_on_cart_and_clicks_checkout() throws Throwable {
        getPage("https://www.saucedemo.com");
        l.enterLoginData("standard_user","secret_sauce");
        l.clickLogin();
        s.clickProduct();
        s.clickAddCart();
        s.clickCart();
        bp.checkout();
    }



    @When("^b-User Enters (.+) (.+) (.+)$")
    public void buser_enters(String firstName, String lastName, String zipCode) throws Throwable {
        bp.enterDetails(firstName,lastName,zipCode);

    }

    @And("^b\\-User Clicks Purchase$")
    public void buser_clicks_purchase() throws Throwable {
        bp.clickContinue();
        bp.clickFinish();
    }


    @Then("^b\\-Validate successful purchase$")
    public void bvalidate_successfull_purchase() throws Throwable {
        String actualResult = bp.validatePurchase();
        String expectedResult = "CHECKOUT: COMPLETE!";
        System.out.println(actualResult);
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Then("^b\\-validate unsuccessful purchase$")
    public void bvalidate_unsuccessful_purchase() throws Throwable {
        boolean result;
        try{
            String actual = bp.validatePurchase();
            result=true;
        }catch (Exception e){
          result = false;
        }
        Assert.assertFalse(result);
    }

    @After("@buy")
    public void finish(){
        tearDown();
    }

}
