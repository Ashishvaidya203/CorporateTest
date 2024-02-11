package CorporateTest1.CorporateTest1;

import static org.junit.Assert.assertArrayEquals;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class TestCorporateScenarios {
	
	static WebDriver driver;
	 ExtentReports report = new ExtentReports();
	////static ExtentReports report;
	
	@BeforeTest
	void initializeReport()
	{
		//ExtentReports report = new ExtentReports(System.getProperty("user.dir")+"ExtentReportResults.html");
		   report = new ExtentReports();
		  ExtentSparkReporter spark = new ExtentSparkReporter("report.html");
		System.out.print("Default path is   "+System.getProperty("user.dir") );
		 report.attachReporter(spark);
		 
	}
	@AfterTest
	void closeReport() throws IOException
	{
		report.flush();
		Desktop.getDesktop().browse(new File("report.html").toURI());
	}
	
	@BeforeMethod
	void InitiateBrowser() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "\\src\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.tendable.com");
		driver.manage().window().maximize();
		
	}

	@AfterMethod
	void CloseBrowser() {
			driver.quit();	
		
	}

	@Test(priority=1)
	void VerifyMainMenus() {
		 ExtentTest test=report.createTest("Test 1", "VerifyMainMenus");
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
		 PageClass pg=new PageClass(driver);
		 pg.Homepage.click();
		 wait.until(ExpectedConditions.elementToBeClickable(pg.Homepage));
		 pg.VerifyHomePageHeading();
		 pg.OurStory.click();
		 pg.VerifyOurStoryHeading();	
		 wait.until(ExpectedConditions.elementToBeClickable(pg.OurSolution));
		 pg.OurSolution.click();
		 WebElement e=pg.OurSolutionPageText;
		 wait.until(ExpectedConditions.visibilityOf(e));
		 pg.VerifyOurSolutionHeading();
		
		 wait.until(ExpectedConditions.elementToBeClickable(pg.WhyTenable));
		 pg.WhyTenable.click();
		 e=pg.TenablePageText;
		 wait.until(ExpectedConditions.visibilityOf(e));
		 pg.VerifyWhyTenableHeading();
		 test.pass("All the main Menus are visible");

		 
	}
	
	@Test(priority=2)
	void VerifyRequestDemoButton() {
		PageClass pg=new PageClass(driver);
		ExtentTest test=report.createTest("Test 2", "VerifyRequestDemoButton");
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
		//wait.until(ExpectedConditions.visibilityOf(pg.DemoButton));
		 pg.Homepage.click();
		 wait.until(ExpectedConditions.elementToBeClickable(pg.DemoButton));
	
		 pg.OurSolution.click();
		 System.out.print("Page is on Our solution");
		 wait.until(ExpectedConditions.elementToBeClickable(pg.DemoButton));
		
		 pg.WhyTenable.click(); System.out.print("Page is on Our Whyt Tenable");
		 wait.until(ExpectedConditions.elementToBeClickable(pg.DemoButton));
		test.pass("Demo button is activated for all the main menus");
	}
	
	@Test(priority=3)
	void FormSubmissionValidation()
	{
		 PageClass pg=new PageClass(driver);
		 ExtentTest test=report.createTest("Test 3", "FormSubmissionValidation");
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
		 
		 Actions a=new Actions(driver);

		 wait.until(ExpectedConditions.elementToBeClickable(pg.AboutUS));
		 a.moveToElement(pg.AboutUS).perform();
		 
		 pg.ContactUSSubMenu.click();
		 wait.until(ExpectedConditions.elementToBeClickable(pg.MarketingContactTab));
		 pg.MarketingContactTab.click();
		 
		 pg.InputFirstName.sendKeys("Ashish");
		 pg.InputOrganisationName.sendKeys("ABC");
		 pg.InputPhoneNumber.sendKeys("1234567890");
		 pg.InputEmail.sendKeys("abc@gmail.com");
		 
		 Select src=new Select(pg.SelectJobRole);
		 src.selectByIndex(1);
		 wait.until(ExpectedConditions.elementToBeClickable( pg.RadioButtonAgree));
		 pg.RadioButtonAgree.click();
		 pg.ButtonAgree.click();
		 try {
		 if(pg.ErrorBox.isDisplayed());
		 System.out.println("Element is dispalyed");
		 test.pass("Verified That error message is displayed after submitting the FORM");
		 Assert.assertTrue(true);
	
		
		 }
		 catch(Exception e)
		 {
			test.fail("Verified That error message is not displayed after submitting the FORM");
			 Assert.assertFalse(true);
			 System.out.println("Element is  not dispalyed");
			 System.out.println("" +e); System.out.println("" +e);
			
		 }
	}

}
