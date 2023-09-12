package WebDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		// WebElement country=driver.findElement(By.id("Form_getForm_Country"));
		By dropDown = By.id("Form_getForm_Country");
//		Select select =new Select(country);
//		int countryList=select.getOptions().size();
//		System.out.println(countryList);
//		List<WebElement> name=select.getOptions();
//		for(WebElement e: name) {
//			String listC=e.getText();
//			System.out.println(listC);
//			if(listC.contains("India")) {
//				e.click();
//			}
//		}
  
		getCountryList(dropDown, "India");
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);

	}
	public static int getCountryCount(By locator) {
		Select select=new Select(getElement(locator));
		 int noOfCountry=select.getOptions().size();
		 return noOfCountry;
	}
	public static void getCountryList(By locator, String countryName) {
		Select select=new Select(getElement(locator));
		List<WebElement> counList=select.getOptions();
		for(WebElement e: counList) {
			String list=e.getText();
			System.out.println(list);
			if(list.contains(countryName)) {
				e.click();
			}
		}
	}

}
