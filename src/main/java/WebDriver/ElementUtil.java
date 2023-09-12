package WebDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	private WebDriver driver;
	private Actions act;

	/**
	 * we create private webdriver so that no body can't access the driver for this
	 * class and if they access they will get NPE Hence creating constructor for
	 * this class generally we create variables of util class as private
	 * 
	 * @param driver
	 */

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		act = new Actions(driver);
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public void doSendKeys(By locator, String value) {
		driver.findElement(locator).sendKeys(value);
	}

	// this method will be using for string locator way
	public By getBy(String locatorType, String selector) {
		By locator = null;
		switch (locatorType.toLowerCase()) {
		case "id":
			locator = By.id(selector);
			break;
		case "name":
			locator = By.name(selector);
			break;
		case "classname":
			locator = By.className(selector);
			break;

		default:
			break;
		}
		return locator;
	}

	// this is for string dosendkeys
	public void doSendKeys(String locatorType, String locatorValue, String value) {
		By locator = getBy(locatorType, locatorValue);
		getElement(locator).sendKeys(value);
	}

	// for By locator
	public void doLogin(By locator) {
		getElement(locator).click();
	}

	public void doLogin(String locatorType, String locatorValue) {
		By locator = getBy(locatorType, locatorValue);
		getElement(locator).click();
	}

	public String doGetTextElement(By locator) {
		String element_text = getElement(locator).getText();
		return element_text;
	}

	public String doGetAttribute(By locator, String attributeName) {
		return getElement(locator).getAttribute(attributeName);
	}

	// for All the links
	// for links with text
	// count for blank link
	public List<WebElement> getElements(By locator) {

		return driver.findElements(locator);

	}

	public int getTotalElementLinkCount(By locator) {
		List<WebElement> linkList = getElements(locator);
		int totalLink = linkList.size();
		return totalLink;
	}

//important method
	public List<String> notBlankLinks(By locator) {
		List<WebElement> linkList = getElements(locator);
		List<String> eleText = new ArrayList<String>();
		for (WebElement e : linkList) {
			String text = e.getText();
			if (!text.isEmpty()) {
				eleText.add(text);
			}
		}
		return eleText;
	}

	public int getNotBlankElementCount(By locator) {
		return notBlankLinks(locator).size();
	}

	public int blankElementCount(By locator) {
		int totalLinks = getTotalElementLinkCount(locator);
		int totalNonLinks = getNotBlankElementCount(locator);
		return totalLinks - totalNonLinks;
	}

	/**
	 * To perform action on suggestion list
	 */
	public void suggestionList(By serachLocator, String value, By suggLocator, String enterValue) throws Throwable {
		doSendKeys(serachLocator, value);
		Thread.sleep(3000);
		List<WebElement> suggList = getElements(suggLocator);
		System.out.println(suggList.size());
		for (WebElement e : suggList) {
			String text = e.getText();
			System.out.println(text);
			if (text.contains(enterValue)) {
				e.click();
				break;
			}
		}
	}

	// ******************For finding element is visible on page******//

	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public int getElementCount(By locator) {
		List<WebElement> elementList = driver.findElements(locator);
		return elementList.size();
	}

	public void doSingleCountElementExits(By locator) {
		if (getElementCount(locator) == 1) {
			System.out.println("Webelement exits for single time only");
		}
	}

	public void doMultiCountElementExits(By locator) {
		if (getElementCount(locator) > 1) {
			System.out.println("Webelement exits for multiple time ");
		}
	}

	// ********************for Select
	// DropDown*********************************************

	public void getDropDownValueByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public void getDropDownValueByText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
		;
	}

	public void getDropDownValueByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
		;
	}

	public void doGetSelectElementCount(By locator) {
		Select select = new Select(getElement(locator));
		int countryList = select.getOptions().size();
		System.out.println(countryList);
	}

	public void doGetSelectElementValue(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> countryList = select.getOptions();
		for (WebElement e : countryList) {
			String text = e.getText();
			System.out.println(text);
		}

	}

	// ********************************ACTION
	// CLASS*********************************************
	public void moveToElement(By locator, By targetElement) throws Exception {
		// Actions act = new Actions(driver);
		// we have declared it private and then intailizing same from constructor and
		// applying the same driver
		act.moveToElement(getElement(locator)).perform();
		Thread.sleep(3000);
		act.click(getElement(targetElement)).perform();
	}

	public void doRightClick(By locator) {
		// Actions act = new Actions(driver);
		act.contextClick(getElement(locator)).perform();
	}

	public  void doGetRightClickOption(By locator, By optionLocator) throws Exception {
		//Actions act = new Actions(driver);
		act.contextClick(getElement(locator)).perform();
		Thread.sleep(3000);
		List<WebElement> options=getElements(optionLocator);
		System.out.println(options.size());
		for(WebElement e: options) {
			String text=e.getText();
			System.out.println(text);
			if(text.equals("Copy")) {
				e.click();
				break;
			}
		}
}
	public  void doSendKeysByAction(By locator, String value) {
		//Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value);
	}
	public  void doClickByAction(By locator) {
		//Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}
	
	//************************Alerts handle by WebDriver Wait************************
	public  Alert getAlertByWait(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
	    return wait.until(ExpectedConditions.alertIsPresent());
		
	}
	public  void acceptAlertByWait(int timeout) {
		getAlertByWait(timeout).accept();
	}
	public  String getTextAlertByWait(int timeout) {
		return getAlertByWait(timeout).getText();
	}
	public  void dismissAlertByWait(int timeout) {
		getAlertByWait(timeout).dismiss();
	}
	public  void sendKeysAlertByWait(int timeout ,String value) {
		getAlertByWait(timeout).sendKeys(value);
	}
	
	//************************Get Title by WebDriver Wait************************
	public  String getTitleByWait(String value) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10) );
		if(wait.until(ExpectedConditions.titleContains(value))){
			return driver.getTitle();
		}else {
			System.out.println("Title is not correct");
			return null;
		}
	}
}
