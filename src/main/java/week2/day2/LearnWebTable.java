package week2.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWebTable {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.get("https://www.crystalcruises.com/travel-calendar?year=2018");
		List<WebElement> allQuotes = driver.findElementsByLinkText("REQUEST A QUOTE");
		int size = allQuotes.size();
		System.out.println(size);
		
		WebElement last = allQuotes.get(size-1);
		last.click();
		
		
		
		
		
		
		
		
		
		
		
	}

}


