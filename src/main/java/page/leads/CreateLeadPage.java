package page.leads;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;
import lib.selenium.WebDriverServiceImpl;

public class CreateLeadPage extends PreAndPost
{
	public CreateLeadPage(EventFiringWebDriver driver, ExtentTest test)
	{
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id = "createLeadForm_companyName")
	WebElement eleCompName;
	
	@FindBy(id = "createLeadForm_firstName")
	WebElement eleFirstName;
	
	@FindBy(id = "createLeadForm_lastName")
	WebElement eleLastName;
	
	@FindBy(id = "createLeadForm_primaryPhoneNumber")
	WebElement elePhoneNumber;
	
	@FindBy(id = "createLeadForm_primaryEmail")
	WebElement eleEmailId;
	
	@FindBy(name = "submitButton")
	WebElement eleCreateLeadButton;
	
	public CreateLeadPage typeCompName(String cName)
	{
		type(eleCompName, cName);
		return this;
	}
	
	
	public CreateLeadPage typeFirstName(String fName)
	{
		type(eleFirstName, fName);
		return this;
	}
	
	public CreateLeadPage typeLastName(String lName)
	{
		type(eleLastName, lName);
		return this;
	}
	
	public CreateLeadPage typePhoneNumber(String phNum)
	{
		type(elePhoneNumber, phNum);
		return this;
	}
	
	public CreateLeadPage typeEmailId(String email)
	{
		type(eleEmailId, email);
		return this;
	}
	
	public ViewLeadsPage clickCreateLeadButton()
	{
		click(eleCreateLeadButton);
		return new ViewLeadsPage(driver, test);
	}
}
