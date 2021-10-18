package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.lang.String;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Base {

	
	public static WebDriver driver;
	public static ExtentHtmlReporter exthtml;
	public static ExtentReports report;
	public static ExtentTest testlog;
	public static Properties prop;
	
	@BeforeSuite
	public void setup()
	{
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		prop = new Properties();
		try 
		{
			prop.load(new FileInputStream("src/main/java/config_jpet/jpet.properties"));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		   
		   	exthtml = new ExtentHtmlReporter("D://Reports/jpet.html");
			report = new ExtentReports();
		 	report.attachReporter(exthtml);
		 	report.setSystemInfo("Host Name", "TestSystem");  //name of thesystem
		 	report.setSystemInfo("Environment", "Test Env");
		 	report.setSystemInfo("User Name", "Mayuri");
		 	   
		 	exthtml.config().setDocumentTitle("Jpet_Store");
		 	exthtml.config().setReportName("jpet functionality");
		 	exthtml.config().setTestViewChartLocation(ChartLocation.TOP);
		 	exthtml.config().setTheme(Theme.STANDARD);
	}
	@AfterSuite
	public void tearDown()
	{
		driver.quit();
		report.flush();	
	}
	


}
