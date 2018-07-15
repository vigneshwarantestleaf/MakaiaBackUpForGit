package week3.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LearnAlert {

	@Test
	public void alert() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to("https://www.irctc.co.in/eticketing/loginHome.jsf");
		driver.findElementById("loginbutton").click();
		
		Alert alert = driver.switchTo().alert();
		
		String text = alert.getText();
		alert.sendKeys("sample");
		alert.accept();


		//System.out.println(text);
		//driver.switchTo().alert().accept();






		driver.findElementById("usernameId").sendKeys("username");


	}

}














