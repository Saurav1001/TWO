package WebDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownList {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		By country=By.id("Form_getForm_Country");
		doGetSelectElementCount(country);
		doGetSelectElementValue(country);
//		Select select=new Select(driver.findElement(country));
//		System.out.println(select.getOptions().size());
		
//		List<WebElement> countryList=select.getOptions();
//		
//		for(WebElement e:countryList) {
//			String text=e.getText();
//			System.out.println(text);
//		}
		
	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator)
;	}
	
	public static void doGetSelectElementCount(By locator) {
		Select select= new Select(getElement(locator));
		int countryList=select.getOptions().size();
		System.out.println(countryList);
	}
	public static void doGetSelectElementValue(By locator) {
		Select select= new Select(getElement(locator));
		List<WebElement> countryList=select.getOptions();
		for(WebElement e:countryList) {
			String text=e.getText();
			System.out.println(text);
		}
		
	}

}
