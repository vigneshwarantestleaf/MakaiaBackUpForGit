package leaf.leads;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;

public class CreateLead extends PreAndPost {

	@Test(dataProvider = "TST")
	public void createLead(String cName, String fName, String lName, String email, String phone) {
		click(locateElement("link", "Leads"));
		click(locateElement("link", "Create Lead"));
		type(locateElement("id", "createLeadForm_companyName"), cName);
		type(locateElement("id", "createLeadForm_firstName"), fName);
		type(locateElement("id", "createLeadForm_lastName"), lName);
		type(locateElement("id", "createLeadForm_primaryEmail"), email);
		type(locateElement("id", "createLeadForm_primaryPhoneNumber"), "");
		click(locateElement("class", "smallSubmit"));
	}
	
	@DataProvider(name = "UAT")
	public Object[][] getData1() {
		Object[][] data = new Object[1][5];
		data[0][0] = "Cg";
		data[0][1] = "arun";
		data[0][2] = "f";
		data[0][3] = "arun@CG.com";
		data[0][4] = 1234567890;
		return data;

	}

	@DataProvider(name = "TST", indices = { 1 })
	public String[][] getData() {
		String[][] data = new String[2][5];
		data[0][0] = "TestLeaf";
		data[0][1] = "sarath";
		data[0][2] = "M";
		data[0][3] = "Sarath@testLeaf.com";
		data[0][4] = "1234567890";

		data[1][0] = "TCS";
		data[1][1] = "govarathan";
		data[1][2] = "s";
		data[1][3] = "govarathan@TCS.com";
		data[1][4] = "9009000122";
		return data;
	}

}
