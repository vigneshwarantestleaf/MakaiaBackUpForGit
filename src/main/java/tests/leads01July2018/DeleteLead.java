package tests.leads01July2018;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import lib.selenium.PreAndPost;
import page.leads.FindLeadsPage;
import page.leads.MyHomePage;

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
		FindLeadsPage flp = new MyHomePage(driver, test)
		.clickLeadsLink()
		.clickFindLeadsLink()
		.clickOnPhoneTab()
		.enterPhoneNumber("9176347427")
		.clickFindLeadsButton();
		String firstResLead = flp.getFirstResultLeadID();
		flp.clickFirstLeadID()
		.clickDeleteButton()
		.clickFindLeadsLink()
		.enterLeadID(firstResLead)
		.verifyErrorMsg("No records to display");
		
		
		
	}
}
