package openMrs;

import baseopenMRS.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mrsPages.MRSFunctions;

public class OpenMRSStepDef {
	Base obj = new Base();
	MRSFunctions obj1 = new MRSFunctions();
	
	 @Given("^user has opened the browser$")
	 public void user_has_opened_the_browser() throws Throwable {
		 obj.openMRSsetup();
	     
	 }

	 @When("^user enters the url$")
	 public void user_enters_the_url() throws Throwable {
		 obj1.url();
	     
	 }

	 @Then("^application login page should open$")
	 public void application_login_page_should_open() throws Throwable {
	     
	 }
	 
	 @Given("^user is on the login page$")
	 public void user_is_on_the_login_page() throws Throwable {
	       
	 }

	 
	 @When("user enters username and password")
	 public void user_enters_username_and_password() {
	     obj1.login();
	 }



	 @Then("^user should be able to login$")
	 public void user_should_be_able_to_login() throws Throwable {
		 obj1.logoutmet();
	       
	 }

	 @And("^selects location$")
	 public void selects_location() throws Throwable {
	       
	 }
	 
	 
	 @Given("user selects particular location")
	 public void user_selects_particular_location() {
	     obj1.url();
	 }


	 @When("^clicks on login$")
	 public void clicks_on_login() throws Throwable {
		 obj1.login();
	       
	 }

	 @Then("^statement should be displayed logged in as selected location$")
	 public void statement_should_be_displayed_logged_in_as_selected_location() throws Throwable {
		 obj1.userPermissions();
	        
	 }
	 
	 
	 @Given("user has logged in")
	 public void user_has_logged_in() {
		 obj1.logoutmet();
		 obj1.url();
	    
	 }



	 @When("^user clicks on Find patient Record$")
	 public void user_clicks_on_find_patient_record() throws Throwable {
		 obj1.login();
	        
	 }

	 @Then("^records should be displayed$")
	 public void records_should_be_displayed() throws Throwable {
		 obj1.patientRecords();
	       
	 }

	 @And("^user should be able to search by id or name$")
	 public void user_should_be_able_to_search_by_id_or_name() throws Throwable {
	       
	 }
	 

	 @Given("^user clicks on Register a patient$")
	 public void user_clicks_on_register_a_patient() throws Throwable {
		 obj1.url();
	       
	 }

	 
	 @When("user enters patient information")
	 public void user_enters_patient_information() {
	    obj1.registerPatient();
	 }


	 @Then("^patient should be registered$")
	 public void patient_should_be_registered() throws Throwable {
		 obj.tearDown();
	      
	 }



	
	
	
	

}
