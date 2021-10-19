package StepDefinition;

import com.page.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.base.Base;
import com.page.SignupPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignupStepDef extends Base {
    String URL = "https://travel.testsigma.com/signup";
    SignupPage rp;
    LoginPage lp;
    @Before("@register")
    public void initial() {
        initialization();
        rp = new SignupPage();
        lp = new LoginPage();
    }

    @Given("^r\\-User enters SimplyTravel url$")
    public void user_enters_SimplyTravel_url() {
        getPage(URL);
    }

    @Then("^r\\-User should be able to navigate to url successfully$")
    public void user_should_be_able_to_navigate_to_url_successfully() {
        String expectedTitle = "Simply Travel";
        String actualTitle = rp.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Given("^r\\-User is on Signup Page$")
    public void user_is_on_registration_page() {
        //rp.initialization(URL);
        getPage(URL);
    }


    @When("^r\\-User enters (.+) (.+) (.+) (.+) (.+) (.+)$")
    public void user_enters_and(String fullname, String email, String phoneNo, String address,String pass, String cpass) throws Throwable {
        rp.signup(fullname, email,phoneNo,address,pass,cpass);
    }

    @When("^r\\-User clicks on Signup Button$")
    public void user_clicks_on_signup_button() {
        rp.clickSignUp();
    }

    @Then("^r\\-User should be able to Register successfully$")
    public void user_should_be_able_to_register_successfully() throws InterruptedException {
        Thread.sleep(4000);
        String actualResult = rp.validateSignUp();
        String expectedResult1 = "test";
        String expectedResult2 = "abc";

        if(actualResult.equals(expectedResult1) ) {
            Assert.assertTrue(true);
        }
        else if(actualResult.equals(expectedResult2) ){
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue(false);
        }

    }

    @After("@register")
    public void finish(){
        tearDown();
    }

}
