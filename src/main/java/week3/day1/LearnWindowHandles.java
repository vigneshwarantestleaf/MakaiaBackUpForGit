package week3.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindowHandles {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://legacy.crystalcruises.com/");
		driver.findElementByLinkText("GUEST CHECK-IN").click();
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		System.out.println("************");
		
		Set<String> allWindows = driver.getWindowHandles();
		List<String> listOfWin =  new ArrayList<String>();
		listOfWin.addAll(allWindows);
		driver.switchTo().window(listOfWin.get(1));
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		System.out.println("************");
		driver.findElementByLinkText("View Offer»").click();
		Set<String> allWindows1 = driver.getWindowHandles();
		
		List<String> listOfWin1 = new ArrayList<String>();
		listOfWin1.addAll(allWindows1);
		driver.switchTo().window(listOfWin1.get(2));
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		
		
		
		
		
		
		
		
		
		
		

	}

}














