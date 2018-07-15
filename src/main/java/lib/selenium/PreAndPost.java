package lib.selenium;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import tests.ReadExcel;

public class PreAndPost extends WebDriverServiceImpl{
	
	public String testCaseName,testDesc,nodeName,author,category,excelFileName;
	
	@Parameters({"URL","userName","password"})
	@BeforeMethod
	public void beforeMethod(String url,String uName,String pWord) 
	{
		//for reports
		startTestModule(nodeName);
		test.assignAuthor(author);
		test.assignCategory(category);
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		webdriver = new ChromeDriver();
		driver = new EventFiringWebDriver(webdriver);
		driver.register(this);
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		type(locateElement("id", "username"), uName);	
		type(locateElement("id", "password"), pWord);
		click(locateElement("class", "decorativeSubmit"));
		click(locateElement("link", "CRM/SFA"));
	}
	
	@DataProvider(name = "DIT", indices= {0})
	public Object[][] getData() throws IOException
	{
		ReadExcel obj = new ReadExcel();
		return obj.readExcel(excelFileName);
	}

	@AfterMethod
	public void afterMethod()
	{
		closeActiveBrowser();
	}

	@BeforeClass
	public void beforeClass() 
	{
		startTestCase(testCaseName, testDesc);		
	}

	@AfterClass
	public void afterClass() 
	{
		System.out.println("afterClass");
	}

	@AfterTest
	public void afterTest()
	{
		System.out.println("afterTest");
	}

	@BeforeSuite
	public void beforeSuite() 
	{
		startReport();
	}


	@AfterSuite
	public void afterSuite()
	{
		endResult();
	}
	
}
