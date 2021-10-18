package testsuitebddjpet;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages_jpet.Home;
import base.Base;
public class Jpet_steps {

	Home h=new Home();
	Base b=new Base();

	@Given("^User is on home page$")
    public void user_is_on_home_page() throws Throwable {
        h.openUrlr();
    }

    @When("^User Provides valid (.+) (.+) (.+) (.+) (.+) (.+) (.+) (.+) (.+) (.+) (.+) (.+) (.+) credentials$")
    public void user_provides_valid_credentials(String username, String newpass, String reppass, String fn, String ln, String email, String phone, String add1, String add2, String city, String state, String zip, String country) throws Throwable {
        h.register();
    }

    @Then("^Home page will open$")
    public void home_page_will_open() throws Throwable {
        h.validatereg();
    }
    @When("^User enters valid (.+) and invalid (.+)$")
    public void user_enters_valid_and_invalid(String username, String pass) throws Throwable {
        h.valid_uname();
    }

    @When("^User enters invalid (.+) and valid (.+)$")
    public void user_enters_invalid_and_valid(String username, String pass) throws Throwable {
        h.invalid_usname();
    }

    @Then("^Error message will display$")
    public void error_message_will_display() throws Throwable {
        h.error_msg();
    }
    @Given("^User is on login page$")
    public void user_is_on_login_page() throws Throwable {
    	h.validatelog();
    }

    @When("^User Provides valid (.+) and (.+) and click box$")
    public void user_provides_valid_and_and_click_box(String username, String pass) throws Throwable {
       h.valid_creden();
    }

    @Then("^Home page will open of pet$")
    public void home_page_will_open_of_pet() throws Throwable {
        h.validatehome();
    }
    @Given("User is on home page after login")
    public void user_is_on_home_page_after_login() throws Throwable {
       h.validatehome();
    }

    @When("^User enter type of pet as (.+)$")
    public void user_enter_type_of_pet_as(String type) throws Throwable {
        h.serch_pet();
    }

    @Then("^Product list will display$")
    public void product_list_will_display() throws Throwable {
        h.validate_list();
    }

    @Given("^User back on home page$")
    public void user_back_on_home_page() throws Throwable {
        h.validatehome();
    }

    @When("^Click on cart$")
    public void click_on_cart() throws Throwable {
        h.show_cart();
    }

    @Then("^Cart is displayed$")
    public void cart_is_displayed() throws Throwable {
        h.validatecart();
    }




}