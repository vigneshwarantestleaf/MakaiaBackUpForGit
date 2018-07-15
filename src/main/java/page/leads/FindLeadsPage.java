package page.leads;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.aventstack.extentreports.ExtentTest;
import lib.selenium.WebDriverServiceImpl;

public class FindLeadsPage extends WebDriverServiceImpl 
{
	public FindLeadsPage(EventFiringWebDriver driver, ExtentTest test) 
	{
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//input[@name='firstName'])[3]")
	WebElement eleFirstNameTextbox; 
	
	@FindBy(xpath="//button[text()='Find Leads']")
	WebElement eleFindLeadsButton;
	
	@FindBy(xpath = "(//a[@class='linktext'])[4]")
	WebElement eleFirstResultLeadID;
	
	@FindBy(xpath="//span[text()='Phone']")
	WebElement elePhoneTab;
	
	@FindBy(xpath="//input[@name='phoneNumber']")
	WebElement eleEnterPhoneNum;
	
	@FindBy(xpath="//input[@name='id']")
	WebElement eleLeadIdTextBox;
	
	@FindBy(xpath="//div[@class='x-paging-info']")
	WebElement afterDelPhNoRec;
	
	public FindLeadsPage typeFirstName(String name)
	{
		type(eleFirstNameTextbox, name);
		return this;
	}
	
	public FindLeadsPage clickFindLeadsButton()
	{
		click(eleFindLeadsButton);
		return this;
	}
	
	public String getFirstResultLeadID()
	{
		String textFirstResID = getText(eleFirstResultLeadID);
		return textFirstResID;
	}
	
	public ViewLeadsPage clickFirstLeadID()
	{
		click(eleFirstResultLeadID);
		return new ViewLeadsPage(driver, test);
	}
	
	public FindLeadsPage clickOnPhoneTab()
	{
		click(elePhoneTab);
		return this;
	}
	
	public FindLeadsPage enterPhoneNumber(String phoneNumber)
	{
		type(eleEnterPhoneNum, phoneNumber);
		return this;
	}
	
	//need clarify for capture first lead ID
	/*public String captureFirstResult(WebElement ele,String locator,String locValue)
	{
		String textCaptureElement = captureElement(ele,locator,locValue);
		return textCaptureElement;
	}*/
	
	public FindLeadsPage enterLeadID(String capturedLeadID)
	{
		type(eleLeadIdTextBox, capturedLeadID);
		return this;
	}
	
	public FindLeadsPage verifyErrorMsg(String errorMsg)
	{
		verifyExactText(afterDelPhNoRec, errorMsg);
		return this;
	}
	
}
