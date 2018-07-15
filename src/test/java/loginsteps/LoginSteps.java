/*package loginsteps;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps 
{
	ChromeDriver driver;
	
	@Given("open the browser")
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@And("launch the URL")
	public void launchBrowser()
	{
		driver.get("http://leaftaps.com/opentaps/control/main/");
	}
	
	@And("set the timeouts")
	public void implicitlyWait()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@And("maximize the browser")
	public void maxBrowser()
	{
		driver.manage().window().maximize();
	}
	
	@And("enter the username as (.*)")
	public void enterUserName(String uName)
	{
		driver.findElement(By.id("username")).sendKeys(uName);
	}
	
	@And("enter the password as (.*)")
	public void enterPassword(String pWord)
	{
		driver.findElement(By.id("password")).sendKeys(pWord);
	}
	
	@When("click the login button")
	public void clickOnLogin()
	{
		driver.findElement(By.className("decorativeSubmit")).click();
	}
	
	@Then("login should be success")
	public void verifyLoginPage()
	{
		WebElement eleVerifyLogin = driver.findElement(By.xpath("//a[text()='Create Lead']"));
		if(eleVerifyLogin.getText().contains("Create Lead"))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		System.out.println("pass");
	}
	
}
*/