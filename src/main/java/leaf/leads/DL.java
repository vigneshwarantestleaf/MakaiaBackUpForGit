/*package leaf.leads;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import lib.selenium.WebDriverServiceImpl;

public class DL extends PreAndPost {

	@BeforeTest
	public void setValue() {
		tcname = "Delete Lead";
		tcdesc = "Deleting a lead";
		authorname = "indhu";
		category = "smoke";
		nodename = "Lead";
		excelSheet = "DeleteLead";
	}

	// raw code
	
	 * @Test public void deleteLead() throws InterruptedException {
	 * 
	 * click(locateElement("link", "Leads")); click(locateElement("link",
	 * "Find Leads")); Thread.sleep(5000); type(locateElement("xpath",
	 * "(//input[@name='firstName'])[3]"), "Gopinath"); click(locateElement("xpath",
	 * "//button[text()='Find Leads']")); String leadID =
	 * getText(locateElement("xpath",
	 * "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
	 * click(locateElement("xpath",
	 * "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
	 * click(locateElement("link", "Delete"));
	 

	@Test(dataProvider = "TST")
	public void deleteLead(String fname) throws InterruptedException {

		click(locateElement("link", "Leads"));
		click(locateElement("link", "Find Leads"));
		Thread.sleep(2000);

		type(locateElement("xpath", "(//input[@name='firstName'])[3]"), fname);
		click(locateElement("xpath", "//button[text()='Find Leads']"));

		String leadID = getText(locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		click(locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		click(locateElement("link", "Delete"));
	}
}*/