package pages_jpet;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;

import base.Base;

public class Home extends Base{
	By signin=By.linkText("Sign In");
	By reg=By.linkText("Register Now!");
	By ui=By.xpath("//input[@name='username']");
	By p=By.xpath("//input[@name='password']");
	By rp=By.xpath("//input[@name='repeatedPassword']");
	By fn=By.xpath("//input[@name='account.firstName']");
	By ln=By.xpath("//input[@name='account.lastName']");
	By email=By.xpath("//input[@name='account.email']");
	By phone=By.xpath("//input[@name='account.phone']");
	By ad1=By.xpath("//input[@name='account.address1']");
	By ad2=By.xpath("//input[@name='account.address2']");
	By city=By.xpath("//input[@name='account.city']");
	By state=By.xpath("//input[@name='account.city']");
	By zip=By.xpath("//input[@name='account.zip']");
	By con=By.xpath("//input[@name='account.country']");
	By logus=By.xpath("//input[@name='username']");
	By logps=By.xpath("//input[@name='password']");
	By logbtn=By.xpath("//input[@name='signon']");
	By regbtn=By.xpath("//input[@name='newAccount']");
	By en=By.linkText("Enter the Store");
	By ser=By.xpath("//input[@name='keyword']");
	By serbtn=By.xpath("//input[@name='searchProducts']");
	By upcrtbtn=By.xpath("//input[@name='updateCartQuantities']");
	By cart=By.xpath("//img[@name='img_cart']");
	public void openUrlr()
	{
		
		driver.get(prop.getProperty("url1"));
		driver.findElement(en).click();
		driver.findElement(signin).click();
		driver.findElement(reg).click();
		//driver.findElement(By.id("switch-account-anchor")).click();
		try 
		{
			Thread.sleep(2000);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void register()
	{
		driver.findElement(ui).sendKeys("OnkarN");
		driver.findElement(p).sendKeys("Onkar@2005");
		driver.findElement(rp).sendKeys("Onkar@2005");
		driver.findElement(fn).sendKeys("Onkar");
		driver.findElement(ln).sendKeys("Navindgikar");
		driver.findElement(email).sendKeys("onkarnavindgikar18@gmail.com");
		driver.findElement(phone).sendKeys("3467185990");
		driver.findElement(ad1).sendKeys("2B COURT COLONY VIJAPUR ROAD");
		driver.findElement(ad2).sendKeys("2B COURT COLONY VIJAPUR ROAD");
		driver.findElement(city).sendKeys("Solapur");
		driver.findElement(state).sendKeys("Maharashtra");
		driver.findElement(zip).sendKeys("413004");
		driver.findElement(con).sendKeys("India");
		driver.findElement(regbtn).click();
		
	}
	public void validatereg()
	{
		String title = driver.getTitle();
		if(title.contains("Demo"))
		{
			//Reporter.log("<font color ='green'><b>Title contains Outdoor toys</b></font>");
			
			testlog = report.createTest("Validate Title");
			testlog.log(Status.PASS, "on home page");
			
			
		}
		else
		{
			//Reporter.log("<font color ='red'><b>Title does not contains Outdoor toys.</b></font>");
			testlog = report.createTest("Validate Title");
			testlog.log(Status.FAIL, "Not on home page");
			

		}
	}
	public void validatelog()
	{
		String title = driver.getCurrentUrl();
		if(title.contains("signonForm"))
		{
			//Reporter.log("<font color ='green'><b>Title contains Outdoor toys</b></font>");
			
			testlog = report.createTest("Validate login page");
			testlog.log(Status.PASS, "on login page");
			
			
		}
		else
		{
			//Reporter.log("<font color ='red'><b>Title does not contains Outdoor toys.</b></font>");
			testlog = report.createTest("Validate login page");
			testlog.log(Status.FAIL, "Not on login page");
			

		}
	}
	public void valid_uname()
	{
		driver.get(prop.getProperty("url1"));
		driver.findElement(en).click();
		driver.findElement(signin).click();
		driver.findElement(logus).clear();
		driver.findElement(logus).sendKeys("OnkarN");
		driver.findElement(logps).clear();
		driver.findElement(logps).sendKeys("hehehe");
		driver.findElement(logbtn).click();
		
	}
	public void invalid_usname()
	{
		driver.get(prop.getProperty("url1"));
		driver.findElement(en).click();
		driver.findElement(signin).click();
		driver.findElement(logus).clear();
		driver.findElement(logus).sendKeys("Onkar44");
		driver.findElement(logps).clear();
		driver.findElement(logps).sendKeys("Onkar@2005");
		driver.findElement(logbtn).click();
	}
	public void valid_creden()
	{
		driver.get(prop.getProperty("url1"));
		driver.findElement(en).click();
		driver.findElement(signin).click();
		driver.findElement(logus).clear();
		driver.findElement(logus).sendKeys("OnkarN");
		driver.findElement(logps).clear();
		driver.findElement(logps).sendKeys("Onkar@2005");
		driver.findElement(logbtn).click();
		//driver.findElement(By.linkText("Sign Out")).click();
	}
	public void error_msg()
	{
		String s=driver.findElement(By.xpath("//li[text()='Invalid username or password.  Signon failed.']")).getText();
		System.out.println(s);
	}
	public void validatehome()
	{
		if(driver.findElement(By.linkText("Sign Out")).isDisplayed() || driver.findElement(By.linkText("My Account ")).isDisplayed())
		{
			//Reporter.log("<font color ='green'><b>Title contains Outdoor toys</b></font>");
			
			testlog = report.createTest("Validate Home");
			testlog.log(Status.PASS, "on Home page");
			
			
		}
		else
		{
			//Reporter.log("<font color ='red'><b>Title does not contains Outdoor toys.</b></font>");
			testlog = report.createTest("Validate Title");
			testlog.log(Status.FAIL, "Not on Home page");
			

		}
	}
	public void serch_pet()
	{
		driver.findElement(ser).sendKeys("Fish");
		driver.findElement(serbtn).click();
		driver.findElement(By.linkText("Fresh Water fish from China")).click();
		driver.findElement(By.linkText("Add to Cart")).click();
		driver.findElement(upcrtbtn).click();
	}
	public void validate_list()
	{
		if(driver.findElement(By.linkText("Return to Main Menu")).isDisplayed())
		{
			testlog = report.createTest("Validate list");
			testlog.log(Status.PASS, "Pets are displaying");
			driver.findElement(By.linkText("Return to Main Menu")).click();
			
		}
		else
		{
			testlog = report.createTest("Validate list");
			testlog.log(Status.FAIL, "Not displaying list");
		}
		
	}
	public void show_cart()
	{
		driver.findElement(cart).click();
	}
	public void validatecart()
	{
		String s=driver.getCurrentUrl();
		if(s.contains("viewCart"))
		{
			testlog = report.createTest("Validate cart");
			testlog.log(Status.PASS, "Pets are displaying from cart");
			driver.findElement(By.linkText("Remove")).click();
		}
		else
		{
			testlog = report.createTest("Validate cart");
			testlog.log(Status.FAIL, "Pets are displaying from cart");
		}
		
		
	}
	
	
}
