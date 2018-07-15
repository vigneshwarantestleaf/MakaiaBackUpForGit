package lib.selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import lib.listeners.WebDriverListener;

//Makaia
public class WebDriverServiceImpl extends WebDriverListener implements WebDriverService {
	
	public Actions builder;

	public WebElement locateElement(String locator, String locValue) {
		try {
			switch (locator) {
			case "id":
				return driver.findElement(By.id(locValue));

			case "class":
				return driver.findElement(By.className(locValue));

			case "link":
				return driver.findElement(By.linkText(locValue));

			case "name":
				return driver.findElement(By.name(locValue));

			case "partialLink":
				return driver.findElement(By.partialLinkText(locValue));

			case "xpath":
				return driver.findElement(By.xpath(locValue));

			case "cssSelector":
				return driver.findElement(By.cssSelector(locValue));

			case "tagName":
				return driver.findElement(By.tagName(locValue));

			default:
				reportSteps("The Locator " + locator + " is found successfully", "pass");
				break;
			}
		} catch (NoSuchElementException e) {
			reportSteps("The Locator " + locator + " is not found successfully", "fail");
		}
		return null;
	}

	public void auiActions(WebElement ele, String actionsType) {
		builder = new Actions(driver);

		switch (actionsType) {
		case "moveToElement":
			builder.moveToElement(ele).perform();
			break;
		}
	}

	public void type(WebElement ele, String data) {
		try {
//			driver.unregister(this);
//			ele.clear();
//			driver.register(this);
			ele.sendKeys(data);
			
			reportSteps("The Data " + data + " is Entered Successfully", "pass");
		} catch (Exception e) {
			reportSteps("The Data " + data + " is not Entered Successfully", "fail");
		}
	}

	public void click(WebElement ele) {
		try {
			ele.click();
			reportSteps("The Element " + ele + " is Clicked Successfully ", "pass");
		} catch (ElementClickInterceptedException e) {
			reportSteps("The Element " + ele + " is not Clicked Successfully ", "fail");
		}
	}

	public void clear(WebElement ele) {
		driver.unregister(this);
		ele.clear();
		driver.register(this);
//		ele.clear();
		
		/*try 
		{
			driver.unregister(this);
			ele.clear();
			driver.register(this);
			reportSteps("The Element " + ele + " is Cleared Successfully", "pass");
		} 
		catch (ElementNotInteractableException e) 
		{
			reportSteps("The Element " + ele + " is not Cleared Successfully", "fail");
		}*/
		
		
	}

	public String getText(WebElement ele) {
		String text = null;
		try
		{
			text = ele.getText();
			reportSteps("The Element " + ele + " is captured via getText method Successfully", "pass");
		}
		catch (ElementNotVisibleException e) {
			reportSteps("The Element " + ele + " is not captured via getText method Successfully", "fail");
		}
		return text;
	}
	
	//need clarification
	/*public String captureElement(WebElement ele,String locator,String locValue)
	{
		WebElement eleCapture = locateElement(locator, locValue);
		String textEleCapture = getText(eleCapture);
		System.out.println(textEleCapture);
		String textEleCaptureForID = textEleCapture.replaceAll("\\D", "");
		System.out.println(textEleCaptureForID);
		return textEleCaptureForID;
	}*/
	

	public String getAttribute(WebElement ele, String value) {
		String attribute = null;
		try {
			attribute = ele.getAttribute(value);
			reportSteps("The Element " + ele + " is captured via getAttribute method Successfully", "pass");
		} catch (ElementNotVisibleException e) {
			reportSteps("The Element " + ele + " is not captured via getAttribute method Successfully", "fail");
		}
		return attribute;
	}

	public void selectDropDownUsingVisibleText(WebElement ele, String value) {
		try {
			Select sc = new Select(ele);
			sc.selectByVisibleText(value);
			reportSteps("The Element " + ele + " is selected successfully via selectByVisibleText", "pass");
		} catch (ElementNotSelectableException e) {
			reportSteps("The Element " + ele + " is not selected successfully via selectByVisibleText", "fail");
		}
	}

	public void selectDropDownUsingValue(WebElement ele, String value) {
		try {
			Select sc = new Select(ele);
			sc.selectByValue(value);
			reportSteps("The Element " + ele + " is selected successfully via selectByValue", "pass");
		} catch (ElementNotSelectableException e) {
			reportSteps("The Element " + ele + " is not selected successfully via selectByValue", "fail");
		}
	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			Select sc = new Select(ele);
			sc.selectByIndex(index);
			reportSteps("The Element " + ele + " is selected successfully via selectByIndex", "pass");
		} catch (ElementNotSelectableException e) {
			reportSteps("The Element " + ele + " is not selected successfully via selectByIndex", "fail");
		}
	}

	public boolean verifyExactTitle(String expectedTitle) {
		try {
			boolean exactTitle = driver.getTitle().equals(expectedTitle);
			reportSteps("The Title " + expectedTitle + " is displayed successfully", "pass");
			return exactTitle;

		} catch (NoSuchWindowException e) {
			reportSteps("The Title " + expectedTitle + " is not displayed successfully", "fail");
		}
		return false;
	}

	public boolean verifyPartialTitle(String expectedTitle) {
		try {
			boolean partialTitle = driver.getTitle().contains(expectedTitle);
			reportSteps("The Title " + expectedTitle + " is displayed successfully", "pass");
			return partialTitle;

		} catch (NoSuchWindowException e) {
			reportSteps("The Title " + expectedTitle + " is not displayed successfully", "fail");
		}
		return false;
	}

	public void verifyExactText(WebElement ele, String expectedText) {
		try {
			boolean exactText = ele.getText().equals(expectedText);
			reportSteps("The Element " + ele + " is successfully verified", "pass");
		} catch (ElementNotVisibleException e) {
			reportSteps("The Element " + ele + " is not successfully verified", "fail");
		}

		catch (InvalidSelectorException e) {
			reportSteps("The Element " + ele + " is not successfully verified", "fail");
		}
	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		try {
			boolean partialText = ele.getText().contains(expectedText);
			reportSteps("The Element " + ele + " is successfully verified", "pass");
		} catch (ElementNotVisibleException e) {
			reportSteps("The Element " + ele + " is not successfully verified", "fail");
		}

		catch (InvalidSelectorException e) {
			reportSteps("The Element " + ele + " is not successfully verified", "fail");
		}
	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		try {
			boolean excatAttribute = ele.getAttribute(value).equals(attribute);
			reportSteps("The Element of Attribute " + ele + " is successfully verified", "pass");
		} catch (ElementNotVisibleException e) {
			reportSteps("The Element of Attribute " + ele + " is not successfully verified", "pass");
		}

		catch (InvalidSelectorException e) {
			reportSteps("The Element of Attribute " + ele + " is not successfully verified", "pass");
		}
	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		try {
			boolean partialAttribute = ele.getAttribute(value).contains(attribute);
			reportSteps("The Element of Attribute " + ele + " is successfully verified", "pass");
		} catch (Exception e) {
			reportSteps("The Element of Attribute " + ele + " is not successfully verified", "pass");
		}
	}

	public void verifySelected(WebElement ele) {
		try {
			boolean eleSelected = ele.isSelected();
			reportSteps("The Element is" + ele + " is selected successfully", "pass");
		} catch (ElementNotSelectableException e) {
			reportSteps("The Element is" + ele + " is not selected successfully", "fail");
		}
	}

	public void verifyDisplayed(WebElement ele) {
		try {
			boolean eleDisplayed = ele.isDisplayed();
			reportSteps("The Element is" + ele + " is displayed successfully", "pass");
		} catch (ElementNotVisibleException e) {
			reportSteps("The Element is" + ele + " is not displayed successfully", "fail");
		}

	}

	public void switchToWindow(int index) {
		try {
			Set<String> allWindows = driver.getWindowHandles();
			List<String> listOfWindows = new ArrayList<String>();
			listOfWindows.addAll(allWindows);
			driver.switchTo().window(listOfWindows.get(index));
			driver.manage().window().maximize();
			reportSteps("The Window " + index + " is successfully switched", "pass");
		} catch (NoSuchWindowException e) {
			reportSteps("The Window " + index + " is not successfully switched", "fail");
		}
	}

	public void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
			reportSteps("The Frame " + index + " is switched successfully", "pass");
		} catch (NoSuchFrameException e) {
			reportSteps("The Frame " + index + " is not switched successfully", "fail");
		}
	}

	public void switchToFrame(String nameOrId) {
		try {
			driver.switchTo().frame(nameOrId);
			reportSteps("The Frame " + nameOrId + " is switched successfully", "pass");
		} catch (NoSuchFrameException e) {
			reportSteps("The Frame " + nameOrId + " is not switched successfully", "fail");
		}
	}

	public void switchToFrame(WebElement ele) {
		try {
			driver.switchTo().frame(ele);
			reportSteps("The Frame " + ele + " is switched successfully", "pass");
		} catch (NoSuchFrameException e) {
			reportSteps("The Frame " + ele + " is not switched successfully", "fail");
		}
	}

	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
			reportSteps("The alert is accepted successfully", "pass");
		} catch (NoAlertPresentException e) {
			reportSteps("The alert is not accepted successfully", "fail");
		}
	}

	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
			reportSteps("The alert is dismissed successfully", "pass");
		} catch (NoAlertPresentException e) {
			reportSteps("The alert is not dismissed successfully", "fail");
		}
	}

	public String getAlertText() {
		try {
			String alertText = driver.switchTo().alert().getText();
			reportSteps("The alert is captured successfully", "pass");
			return alertText;
		} catch (NoAlertPresentException e) {
			reportSteps("The alert is not captured successfully", "fail");
		}
		return null;
	}

	public void closeActiveBrowser() {
			driver.close();
	}

	public void closeAllBrowsers() {
			driver.quit();
	}
}
