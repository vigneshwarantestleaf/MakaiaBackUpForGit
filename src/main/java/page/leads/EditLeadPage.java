package page.leads;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.aventstack.extentreports.ExtentTest;
import lib.selenium.WebDriverServiceImpl;

public class EditLeadPage  extends WebDriverServiceImpl 
{
	public EditLeadPage(EventFiringWebDriver driver,ExtentTest test)
	{
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "updateLeadForm_companyName")
	WebElement eleCompanyName;
	
	@FindBy(xpath = "(//input[@name='submitButton'])[1]")
	WebElement eleUpdateButton;
	
	public EditLeadPage clearCompanyName()
	{
		clear(eleCompanyName);
		return this;
	}
	
	public EditLeadPage changeCompanyName(String changeCompanyName)
	{
		type(eleCompanyName, changeCompanyName);
		return this;
	}
	
	public ViewLeadsPage clickUpdateButton()
	{
		click(eleUpdateButton);
		return new ViewLeadsPage(driver, test);
	}
}
