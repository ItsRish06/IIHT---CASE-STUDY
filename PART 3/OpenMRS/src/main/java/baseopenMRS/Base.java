package baseopenMRS;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
	
	public void openMRSsetup()
	{
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
		prop = new Properties();
		try 
		{
			prop.load(new FileInputStream("src/main/java/config/config.properties"));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		exthtml = new ExtentHtmlReporter(prop.getProperty("reportloc"));
		report = new ExtentReports();
	 	report.attachReporter(exthtml);
	 	report.setSystemInfo("Host Name", "TestSystem");  //name of the system
	 	report.setSystemInfo("Environment", "Test Env");
	 	report.setSystemInfo("User Name", "Rashmi");
	 	   
	 	exthtml.config().setDocumentTitle("openMRS");
	 	exthtml.config().setReportName("OpenMRS Functional Testing");
	 	exthtml.config().setTestViewChartLocation(ChartLocation.TOP);
	 	exthtml.config().setTheme(Theme.STANDARD);
	}
	
	public void tearDown()
	{
		report.flush(); //to save the report.
		driver.quit();
	}

    

}
