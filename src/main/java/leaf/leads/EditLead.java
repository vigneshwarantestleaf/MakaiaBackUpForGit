package leaf.leads;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;

public class EditLead extends PreAndPost {

	@Test(dataProvider = "DIT")
	public void editLead(String fName,String updateCompName) throws InterruptedException {

		click(locateElement("link", "Leads"));
		click(locateElement("link", "Find Leads"));
		type(locateElement("xpath", "(//input[@name='firstName'])[3]"), fName);
		click(locateElement("xpath", "//button[text()='Find Leads']"));
		String leadID = getText(locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		click(locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		click(locateElement("link", "Edit"));
		type(locateElement("id", "updateLeadForm_companyName"), updateCompName);
		click(locateElement("class", "smallSubmit"));
		click(locateElement("link", "Find Leads"));
		type(locateElement("xpath", "//input[@name='id']"), leadID);
		click(locateElement("xpath", "//button[text()='Find Leads']"));
		Thread.sleep(2000);
		click(locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a"));
		verifyPartialText(locateElement("id", "viewLead_companyName_sp"), "TestLeaf Private Ltd");
	}
	
	@DataProvider(name="DIT")
	public Object[][] getData()
	{
		Object[][] data = new Object[1][2];
		data[0][0] = "Gopinath";
		data[0][1] = "TestLeaf Private Ltd";
		return data;
	}
	
}
