package page.leads;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.WebDriverServiceImpl;

public class MyHomePage extends WebDriverServiceImpl
{
	public MyHomePage(EventFiringWebDriver driver, ExtentTest test)
	{
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Leads")
	WebElement eleLeadsLink;
	
	public MyLeadsPage clickLeadsLink()
	{
		click(eleLeadsLink);
		return new MyLeadsPage(driver, test);
	}
}
