package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import lib.selenium.PreAndPost;
public class CreateLead extends PreAndPost
{
	@BeforeTest
	public void setValue()
	{
		testCaseName = "CreateLead";
		testDesc = "Create a New Lead";
		nodeName = "Leads";
		author = "vignesh";
		category = "smoke";
		excelFileName = "CreateLead";
	}
	
	@Test(dataProvider = "DIT")
	public void createLead(String compName,String name, String lastName,String phoneNo,String email)
	{
		/*WebElement eleCRM = locateElement("link", "CRM/SFA");
		click(eleCRM);*/
		
		WebElement eleCreateLead = locateElement("link", "Create Lead");
		click(eleCreateLead);
		
		WebElement eleCompName = locateElement("id", "createLeadForm_companyName");
		type(eleCompName, compName);
		
		WebElement eleFirstName = locateElement("id", "createLeadForm_firstName");
		type(eleFirstName, name);
		
		WebElement eleLastName = locateElement("id", "createLeadForm_lastName");
		type(eleLastName, lastName);
		
		WebElement elePhoneNumber = locateElement("id", "createLeadForm_primaryPhoneNumber");
		type(elePhoneNumber, phoneNo);
		
		WebElement eleEmailId = locateElement("id", "createLeadForm_primaryEmail");
		type(eleEmailId, email);
		
		WebElement eleCreateLeadButton = locateElement("name", "submitButton");
		click(eleCreateLeadButton);
	}
}




