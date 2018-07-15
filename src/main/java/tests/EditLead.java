package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import lib.selenium.PreAndPost;

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
		WebElement eleLeadsLink = locateElement("link", "Leads");
		click(eleLeadsLink);
		
		WebElement eleFindLeadsLink = locateElement("link", "Find Leads");
		click(eleFindLeadsLink);
		
		WebElement eleFirstName = locateElement("xpath", "(//input[@name='firstName'])[3]");
		type(eleFirstName, name);
		
		WebElement eleFindLeadsButton = locateElement("xpath", "//button[text()='Find Leads']");
		click(eleFindLeadsButton);
		
		WebElement eleFirstLeadResult = locateElement("xpath", "(//a[@class='linktext'])[4]");
		click(eleFirstLeadResult);
		
		verifyExactTitle("View Lead | opentaps CRM");
		
		WebElement eleEditButton = locateElement("link", "Edit");
		click(eleEditButton);
		
		WebElement eleEditCompanyName = locateElement("xpath", "//input[@id='updateLeadForm_companyName']");
		String attributeEleEditCompanyName = getAttribute(eleEditCompanyName, "value");
		System.out.println(attributeEleEditCompanyName);
		
		clear(eleEditCompanyName);
		
		type(eleEditCompanyName, changeCompName);
		
		WebElement eleUpdateButton = locateElement("name", "submitButton");
		click(eleUpdateButton);
		
		WebElement eleUpdCompName = locateElement("xpath", "(//span[@class='requiredField']/following::span)[1]");
		String textEleUpdCompName = getText(eleUpdCompName);
		System.out.println(textEleUpdCompName);
		
		String textEleUpdCompNameForId = textEleUpdCompName.replaceAll("\\D", "");
		System.out.println(textEleUpdCompNameForId);
		String textEleUpdCompNameForName = textEleUpdCompName.replaceAll("\\d", "");
		String textEleUpdCompNameForNamea = textEleUpdCompNameForName.replaceAll("[(,), ]", "");
		System.out.println(textEleUpdCompNameForNamea);
		
		verifyPartialText(eleUpdCompName, "CTS");
	}
}
