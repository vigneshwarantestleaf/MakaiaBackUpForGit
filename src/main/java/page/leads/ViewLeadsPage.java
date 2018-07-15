package page.leads;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.aventstack.extentreports.ExtentTest;
import lib.selenium.WebDriverServiceImpl;

public class ViewLeadsPage extends WebDriverServiceImpl
{
	public ViewLeadsPage(EventFiringWebDriver driver, ExtentTest test)
	{
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "viewLead_firstName_sp")
	WebElement eleFirstLeadResult;
	
	@FindBy(linkText = "Edit")
	WebElement eleEditButton;
	
	@FindBy(xpath = "(//span[@class='requiredField']//following::td)[1]")
	WebElement eleUpdatedCompanyName;
	
	@FindBy(xpath="//a[text()='Delete']")
	WebElement eleDeleteButton;
	
	public ViewLeadsPage verifyTitle() {
		verifyExactTitle("View Lead | opentaps CRM");
		return this;
	}
	
	public ViewLeadsPage verifyCompName(String firstName)
	{
		verifyPartialAttribute(eleFirstLeadResult, "value", firstName);
		return this;
	}
	
	public EditLeadPage clickEditButton()
	{
		click(eleEditButton);
		return new EditLeadPage(driver, test);
	}
	
	public ViewLeadsPage verifyUpdatedCompanyName(String updatedCompanyName)
	{
		verifyPartialText(eleUpdatedCompanyName, updatedCompanyName);
		return this;
	}
	
	public MyLeadsPage clickDeleteButton()
	{
		click(eleDeleteButton);
		return new MyLeadsPage(driver, test);
	}
}
