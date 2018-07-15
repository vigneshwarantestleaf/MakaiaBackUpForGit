package tests.leads01July2018;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import lib.selenium.PreAndPost;
import page.leads.MyHomePage;
public class CreateLead02 extends PreAndPost
{
	@BeforeTest
	public void setValue()
	{
		testCaseName = "CreateLead02";
		testDesc = "Create a New Lead";
		nodeName = "Leads";
		author = "vignesh";
		category = "smoke";
		excelFileName = "CreateLead";
	}
	
	@Test(dataProvider = "DIT")
	public void createLead(String compName,String firstName, String lastName,String phoneNo,String email)
	{
		new MyHomePage(driver, test)
		.clickLeadsLink()
		.clickCreateLeadsLink()
		.typeCompName(compName)
		.typeFirstName(firstName)
		.typeLastName(lastName)
		.typePhoneNumber(phoneNo)
		.typeEmailId(email)
		.clickCreateLeadButton()
		.verifyCompName(firstName);
	}
}




