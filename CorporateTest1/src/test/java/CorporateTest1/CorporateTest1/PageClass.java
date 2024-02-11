package CorporateTest1.CorporateTest1;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PageClass extends TestCorporateScenarios{
	
	
	static String OurStoryURL="https://www.tendable.com/our-story";
	static String OurSolutionURL="https://www.tendable.com/our-solution";
	static String WhyTenableURL="https://www.tendable.com/why-tendable";

	
	
	@FindBy(xpath = "//a[@class='logo']")
	WebElement Homepage;
	
	@FindBy(xpath = "//a[contains(text(),'Our Story')]")
	WebElement OurStory;
	
	
	@FindBy(xpath="//a[contains(text(),'Our Solution')]")
	WebElement OurSolution;
	
	@FindBy(xpath="//a[contains(text(),'Why Tendable?')]")
	WebElement WhyTenable;
	
	@FindBy(xpath="//a[contains(text(),'About Us')]")
	WebElement AboutUS;
	
	@FindBy(xpath="//a[contains(text(),'Request A Demo')]")
	WebElement DemoButton;
	
	////div[@class='button-links']//following-sibling::a[@href='https://www.tendable.com/book-a-demo']
	//a[@class='button']
	//
	
	@FindBy(xpath="//a[contains(text(),'Contact Us')]")
	WebElement ContactUS;
	
	@FindBy(xpath="//a[contains(text(),'About Us')]//following::li[6]/a")
	WebElement ContactUSSubMenu;
	//a[contains(text(),'About Us')]//following::li[6]/a
	
	@FindBy(xpath="//div[contains(text(),'Marketing')]")
	WebElement MarketingTab;
	
	
	@FindBy(xpath="//div[contains(text(),'Marketing')]//following::button[contains(text(),'Contact')][1]")
	WebElement MarketingContactTab;
	
	@FindBy(xpath="//a[@class='logo']")
	By HomePageLogo;
	
	@FindBy(xpath="//h2[contains(text(),'Why should you')]")
	WebElement TenablePageText;
	
	@FindBy(xpath="//h1[contains(text(),'Quality inputs deliver')]")
	WebElement OurSolutionPageText;
	
	@FindBy(xpath="//input[@name='fullName'][1]")
	WebElement InputFirstName;
	
	@FindBy(xpath="//input[@name='organisationName'][1]")
	WebElement InputOrganisationName;
	
	@FindBy(xpath="//input[@name='cellPhone'][1]")
	WebElement InputPhoneNumber;
	
	@FindBy(xpath="//input[@name='email'][1]")
	WebElement InputEmail;
	
	@FindBy(xpath="//select[@name='jobRole'][1]")
	WebElement SelectJobRole;
	

	@FindBy(xpath="//label[contains(text(),'Consent Agreed')]//following::input")
	WebElement RadioButtonAgree;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement ButtonAgree;
	
	@FindBy(xpath="//p[contains(text(),'Sorry, there was an error submitting the form. Please try again.')]")
	WebElement ErrorBox;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(5));
	
	
		
		public void VerifyHomePageHeading()
	{
		 String URL=driver.getCurrentUrl();
		 wait.until(ExpectedConditions.urlContains(URL));
		  String Expected_URL="https://www.tendable.com/";
		  Assert.assertEquals(URL,Expected_URL); 
		  System.out.print("Page is switched to Home page");
	}
	
	public void VerifyOurStoryHeading()
	{
		 String URL=driver.getCurrentUrl();
		 wait.until(ExpectedConditions.urlContains(URL));
		  String Expected_URL="https://www.tendable.com/our-story";
		  Assert.assertEquals(URL,Expected_URL); 
		  System.out.print("Page is switched to Our Story page");
	}
	
	
	public void VerifyOurSolutionHeading()
	{
		String URL=driver.getCurrentUrl();
		 wait.until(ExpectedConditions.urlContains(URL));
		 String Expected_URL="https://www.tendable.com/our-solution";
		 Assert.assertEquals(URL,Expected_URL); 
		  System.out.print("Page is switched to Our Solution page");
		 
		
	}
	
	public void VerifyWhyTenableHeading()
	{
		String URL=driver.getCurrentUrl();
		 wait.until(ExpectedConditions.urlContains(URL));
		 String Expected_URL="https://www.tendable.com/why-tendable";
		 Assert.assertEquals(URL,Expected_URL); 
		  System.out.print("Page is switched to why-tendable page");
	}
	
	public PageClass(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		}
	

}
