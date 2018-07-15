package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import lib.selenium.PreAndPost;

public class DuplicateLead extends PreAndPost
{	
	@BeforeTest
	public void setValue()
	{
		testCaseName = "DuplicateLead";
		testDesc = "Duplicate a Lead";
		nodeName = "Leads";
		author = "vignesh";
		category = "smoke";
		excelFileName = "DuplicateLead";
	}
	
	@Test(dataProvider = "DIT")
	public void duplicateLead(String email) 
	{
		WebElement eleLeadsLink = locateElement("link", "Leads");
		click(eleLeadsLink);
		
		WebElement eleFindLeadsButton = locateElement("xpath", "//a[text()='Find Leads']");
		click(eleFindLeadsButton);
		
		WebElement eleEmailTab = locateElement("xpath", "//span[text()='Email']");
		click(eleEmailTab);
		
		WebElement eleEnterEmail = locateElement("name", "emailAddress");
		type(eleEnterEmail, email);
		
		WebElement eleFindLeadsButtonEmail = locateElement("xpath", "//button[text()='Find Leads']");
		click(eleFindLeadsButtonEmail);
		
		WebElement eleFirstResLeadId = locateElement("xpath", "(//a[@class='linktext'])[4]");
		System.out.println(eleFirstResLeadId.getText());
		String textEleFirstResLeadId = getText(eleFirstResLeadId);
		String textEleFirstResLeadIdForName = textEleFirstResLeadId.replaceAll("\\d", "");
		String textEleFirstResLeadIdForName01 = textEleFirstResLeadIdForName.replaceAll("\\d", "[(,), ]");
		
		WebElement eleFirstLeadResult = locateElement("xpath", "(//a[@class='linktext'])[4]");
		click(eleFirstLeadResult);
		
		WebElement eleDupLeadButton = locateElement("xpath", "//a[text()='Duplicate Lead']");
		click(eleDupLeadButton);
		
		verifyExactTitle("Duplicate Lead | opentaps CRM");
		
		WebElement eleCreateLeadButton = locateElement("name", "submitButton");
		click(eleCreateLeadButton);
		
		WebElement eleCompNameAftrDup = locateElement("xpath", "(//span[@class='requiredField']/following::span)[1]");
		String textEleCompNameAftrDup = getText(eleCompNameAftrDup);
		String textEleCompNameAftrDupForName = textEleCompNameAftrDup.replaceAll("\\d", "");
		String textEleCompNameAftrDupForName01 = textEleCompNameAftrDupForName.replaceAll("[(,), ]", "");
		System.out.println(textEleCompNameAftrDupForName01);
		
		verifyPartialText(eleCompNameAftrDup, "DucenIT");
	}
}


