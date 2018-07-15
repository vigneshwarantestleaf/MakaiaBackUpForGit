package page.leads;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.WebDriverServiceImpl;

public class MyLeadsPage extends WebDriverServiceImpl
{
	public MyLeadsPage(EventFiringWebDriver driver, ExtentTest test)
	{
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText ="Create Lead")
	WebElement eleCreateLeadLink;
	
	public CreateLeadPage clickCreateLeadsLink()
	{
		click(eleCreateLeadLink);
		return new CreateLeadPage(driver, test);
	}
	
	@FindBy(linkText = "Find Leads")
	WebElement eleFindLeadsLink;
	
	public FindLeadsPage clickFindLeadsLink()
	{
		click(eleFindLeadsLink);
		return new FindLeadsPage(driver,test);
	}
}
