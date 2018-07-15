package tests.leads01July2018;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import page.leads.EditLeadPage;
import page.leads.MyHomePage;
public class EditLead extends PreAndPost
{
	@BeforeTest
	public void setValue()
	{
		testCaseName = "EditLead";
		testDesc = "Edit a Lead";
		nodeName = "Leads";
		author = "vignesh";
		category = "smoke";
		excelFileName = "EditLead";
	}
	
	@Test(dataProvider = "DIT")
	public void editLead(String name, String changeCompName)
	{
		new MyHomePage(driver, test)
		.clickLeadsLink()
		.clickFindLeadsLink()
		.typeFirstName(name)
		.clickFindLeadsButton()
		.clickFirstLeadID()
		.verifyTitle()
		.clickEditButton()
		.clearCompanyName()
		.changeCompanyName(changeCompName)
		.clickUpdateButton();
	}
}
