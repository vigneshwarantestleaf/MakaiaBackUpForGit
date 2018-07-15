package loginsteps;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateLeads 
{
	ChromeDriver driver;
	
	@Given("open the browser")
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@And("launch the URL")
	public void launchBrowser()
	{
		driver.get("http://leaftaps.com/opentaps/");
	}
	
	@And("set the timeouts")
	public void implicitlyWait()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@And("maximize the browser")
	public void maxBrowser()
	{
		driver.manage().window().maximize();
	}
	
	@And("enter the username as (.*)")
	public void enterUserName(String uName)
	{
		driver.findElement(By.id("username")).sendKeys(uName);
	}
	
	@And("enter the password as (.*)")
	public void enterPassword(String pWord)
	{
		driver.findElement(By.id("password")).sendKeys(pWord);
	}
	
	@And("click the login button")
	public void clickOnLogin()
	{
		driver.findElement(By.className("decorativeSubmit")).click();
	}
	
	@And("click the CRMSFA link")
	public void clickOnCRMSFALink()
	{
		driver.findElement(By.linkText("CRM/SFA")).click();
	}
	
	@And("click on create lead link")
	public void createLeadLink()
	{
		driver.findElement(By.linkText("Create Lead")).click();
	}
	
	@And("enter the companyname as (.*)")
	public void enterCompName(String cName)
	{
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
	}
	
	
	@And("enter the firstName as (.*)")
	public void enterFirstName(String fName)
	{
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
	}
	
	@And("enter the lastName as (.*)")
	public void enterLastName(String lName)
	{
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
	}
	
	@When("click on create lead button")
	public void clickOnCreateLeadButton()
	{
		driver.findElement(By.name("submitButton")).click();
	}
	
	@Then("lead created success")
	public void verifyCreateLeadPage()
	{
		System.out.println("pass");
	}
	
}
