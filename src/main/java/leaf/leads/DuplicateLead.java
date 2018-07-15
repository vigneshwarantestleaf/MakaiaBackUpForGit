package leaf.leads;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lib.selenium.WebDriverServiceImpl;

public class DuplicateLead extends WebDriverServiceImpl {

	@Test(dataProvider = "DIT")
	public void duplicateLead(String email,String fName) throws InterruptedException {

		click(locateElement("link", "Leads"));
		click(locateElement("link", "Find Leads"));
		click(locateElement("xpath", "//span[text()='Email']"));
		type(locateElement("name", "emailAddress"), email);
		click(locateElement("xpath", "//button[text()='Find Leads']"));
		String leadName = getText(locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a"));
		click(locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a"));
		click(locateElement("link", "Duplicate Lead"));
		type(locateElement("id", "createLeadForm_firstName"), fName);
		click(locateElement("class", "smallSubmit"));
		String leadID = getText(locateElement("id", "viewLead_companyName_sp")).replaceAll("\\D", "");
		click(locateElement("link", "Find Leads"));
		type(locateElement("xpath", "//input[@name='id']"), leadID);
		click(locateElement("xpath", "//button[text()='Find Leads']"));
		Thread.sleep(2000);
		verifyExactText(locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a"), "Gopi");
	}
	
	@DataProvider(name = "DIT")
	public Object[][] getData()
	{
		Object[][] data = new Object[1][2];
		data[0][0] = "gopinath@testleaf.com";
		data[0][1] = "Gopi";
		return data;
	}
}
