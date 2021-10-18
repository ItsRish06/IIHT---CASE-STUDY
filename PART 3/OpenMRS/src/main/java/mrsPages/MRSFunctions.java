package mrsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import baseopenMRS.Base;

public class MRSFunctions extends Base {
	
	By un = By.id("username");
	By pass = By.id("password");
	By loc = By.id("Inpatient Ward");
	By login = By.id("loginButton");
	By perm = By.xpath("//*[@id=\"content\"]/div[2]/div/h4");
	By pr = By.id("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension");
	By pid = By.id("patient-search");
	By rp = By.id("referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension");
	By pn = By.xpath("/html/body/div/div[3]/form/section[1]/div/fieldset[1]/div[1]/p[1]/input");
	By psn = By.xpath("/html/body/div/div[3]/form/section[1]/div/fieldset[1]/div[1]/p[3]/input");
	By nxt = By.id("next-button");
	By g = By.id("gender-field");
	By bd = By.id("birthdateDay-field");
	By bm = By.id("birthdateMonth-field");
	By bye = By.id("birthdateYear-field");
	By add = By.id("address1");
	By city = By.id("cityVillage");
	By state = By.id("stateProvince");
	By coun = By.id("country");
	By pin = By.id("postalCode");
	By sub = By.id("submit");
	By no = By.name("phoneNumber");
	By rt = By.id("relationship_type");
	By rtt = By.xpath("//*[@id=\"relationship\"]/p[2]/input[1]");
	By logout = By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[3]/a");
	 
	
	
	public void url() {
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
	}
	
	public void login() {
		
		driver.findElement(un).sendKeys("admin");
		driver.findElement(pass).sendKeys("Admin123");
		driver.findElement(loc).click();
		driver.findElement(login).click();	
	}
	
	public void userPermissions() {
		String s = driver.findElement(perm).getText();
		System.out.println(s);
		
	}
	
	public void patientRecords() {
		driver.findElement(pr).click();
		driver.findElement(pid).sendKeys("100HPW");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(pid).clear();
		driver.findElement(pid).sendKeys("Jay Park");
		driver.navigate().back();
	}
	
	public void registerPatient() {	
		driver.findElement(rp).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		driver.findElement(pn).sendKeys("Jay");
		driver.findElement(psn).sendKeys("Park");
		driver.findElement(nxt).click();
		Select s1 = new Select(driver.findElement(g));
		s1.selectByVisibleText("Male");
		driver.findElement(nxt).click();
		driver.findElement(bd).sendKeys("22");
		Select s2 = new Select(driver.findElement(bm));
		s2.selectByVisibleText("November");
		driver.findElement(bye).sendKeys("2000");
		driver.findElement(nxt).click();
		driver.findElement(add).sendKeys("Lotus Apartment");
		driver.findElement(city).sendKeys("Pune");
		driver.findElement(state).sendKeys("Maharashtra");
		driver.findElement(coun).sendKeys("India");
		driver.findElement(pin).sendKeys("411002");
		driver.findElement(nxt).click();
		driver.findElement(no).sendKeys("9845672356");
		driver.findElement(nxt).click();
		Select s3 = new Select(driver.findElement(rt));
		s3.selectByVisibleText("Parent");
		driver.findElement(rtt).sendKeys("James Park");
		driver.findElement(nxt).click();
		driver.findElement(sub).click();	
		
	}
	
	public void logoutmet() {
		driver.findElement(logout).click();
	}

}
