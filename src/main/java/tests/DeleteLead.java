package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import lib.selenium.PreAndPost;

public class DeleteLead extends PreAndPost
{
	@BeforeTest
	public void setValue()
	{
		testCaseName = "DeleteLead";
		testDesc = "Delete a Lead";
		nodeName = "Leads";
		author = "vignesh";
		category = "smoke";
		excelFileName = "DeleteLead";
	}
	
	@Test(dataProvider = "DIT")
	public void deleteLead(String phoneNo) 
	{
		WebElement eleLeadsLink = locateElement("link", "Leads");
		click(eleLeadsLink);
		
		WebElement eleFindLeadsLink = locateElement("link", "Find Leads");
		click(eleFindLeadsLink);
		
		WebElement elePhoneTab = locateElement("xpath", "//span[text()='Phone']");
		click(elePhoneTab);
		
		WebElement eleEnterPhoneNum = locateElement("xpath", "//input[@name='phoneNumber']");
		type(eleEnterPhoneNum, phoneNo);
		
		WebElement eleFindLeadsButton = locateElement("xpath", "//button[text()='Find Leads']");
		click(eleFindLeadsButton);
		
		WebElement eleFirstLeadIDCapture = locateElement("xpath", "(//a[@class='linktext'])[4]");
		String textEleFirstLeadIDCapture = getText(eleFirstLeadIDCapture);
		System.out.println(textEleFirstLeadIDCapture);
		
		String textEleFirstLeadIDCaptureForID = textEleFirstLeadIDCapture.replaceAll("\\D", "");
		System.out.println(textEleFirstLeadIDCaptureForID);
		
		WebElement eleFirstLeadIDClick = locateElement("xpath", "(//a[@class='linktext'])[4]");
		click(eleFirstLeadIDClick);
		
		WebElement eleDeleteButton = locateElement("xpath", "//a[text()='Delete']");
		click(eleDeleteButton);
		
		WebElement eleFindLeadsAfterDelete = locateElement("xpath", "//a[text()='Find Leads']");
		click(eleFindLeadsAfterDelete);
		
		WebElement eleLeadIdTextBox = locateElement("xpath", "//input[@name='id']");
		type(eleLeadIdTextBox, textEleFirstLeadIDCaptureForID);
		
		WebElement eleFindLeadsButtonAfterDelete = locateElement("xpath", "//button[text()='Find Leads']");
		click(eleFindLeadsButtonAfterDelete);
		
		WebElement afterDelPhNoRec = locateElement("xpath", "//div[@class='x-paging-info']");
		verifyExactText(afterDelPhNoRec, "No records to display");
	}
}
