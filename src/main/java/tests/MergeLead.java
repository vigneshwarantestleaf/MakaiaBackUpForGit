package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import lib.selenium.PreAndPost;

public class MergeLead extends PreAndPost 
{
	@BeforeTest
	public void setValue()
	{
		testCaseName = "MergeLead";
		testDesc = "Merging two Leads and verify it is merged or not";
		nodeName = "Leads";
		author = "vignesh";
		category = "smoke";
		excelFileName = "MergeLead";
	}
	
	@Test
	public void mergeLeads() throws InterruptedException 
	{
		WebElement eleLeadsLink = locateElement("link", "Leads");
		click(eleLeadsLink);
		
		WebElement eleMergeLeadsLink = locateElement("link", "Merge Leads");
		click(eleMergeLeadsLink);
		
		WebElement eleFromLeadImg = locateElement("xpath", "(//span[text()='From Lead']/following::a)[1]");
		click(eleFromLeadImg);
		Thread.sleep(3000);
		
		switchToWindow(1);
		Thread.sleep(2000);
		
		//Get First Lead for FromLead
		WebElement firstLeadForFromLead = locateElement("xpath", "(//a[@class='linktext'])[1]");
		String textFirstLeadForFromLead = firstLeadForFromLead.getText();
		
		WebElement eleEnterFromLeadId = locateElement("xpath", "//input[@name='id']");
		type(eleEnterFromLeadId, textFirstLeadForFromLead);
		
		WebElement eleFromFindLeadsButton = locateElement("xpath", "//button[text()='Find Leads']");
		click(eleFromFindLeadsButton);
		Thread.sleep(2000);
		
		WebElement eleFromFirstResultLeadId = locateElement("xpath", "(//a[@class='linktext'])[1]");
		click(eleFromFirstResultLeadId);
		
		switchToWindow(0);
		
		WebElement eleToLeadIcon = locateElement("xpath", "(//span[text()='To Lead']/following::a)[1]");
		click(eleToLeadIcon);
		
		switchToWindow(1);
		
		//Get Second Lead for ToLead
		WebElement secondLeadForToLead = locateElement("xpath", "(//a[@class='linktext'])[6]");
		String textSecondLeadForToLead = secondLeadForToLead.getText();
		
		WebElement eleEnterToLeadId = locateElement("xpath", "//input[@name='id']");
		type(eleEnterToLeadId, textSecondLeadForToLead);
		
		WebElement eleToFindLeadsButton = locateElement("xpath", "//button[text()='Find Leads']");
		click(eleToFindLeadsButton);
		Thread.sleep(2000);
		
		WebElement eleToFirstResultLeadId = locateElement("xpath", "(//a[@class='linktext'])[1]");
		click(eleToFirstResultLeadId);
		
		switchToWindow(0);
		
		WebElement eleMergeLeadButton = locateElement("link", "Merge");
		click(eleMergeLeadButton);
		
		acceptAlert();
		
		WebElement eleFindLeadsLink = locateElement("link", "Find Leads");
		click(eleFindLeadsLink);
		
		WebElement eleEnterLeadId = locateElement("xpath", "//input[@name='id']");
		type(eleEnterLeadId, textFirstLeadForFromLead);
		
		click(eleFindLeadsLink);
		Thread.sleep(2000);
		
		WebElement eleErrorMsgDisplay = locateElement("xpath", "//div[@class='x-paging-info']");
		verifyExactText(eleErrorMsgDisplay, "No records to display");
	}
}
