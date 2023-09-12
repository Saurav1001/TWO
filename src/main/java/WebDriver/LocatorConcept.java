package WebDriver;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorConcept {
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver=new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
//		String attr=driver.findElement(By.id("input-firstname")).getAttribute("placeholder");
//		System.out.println(attr);
		String id_String="input-firstname";
		//By id_Locator=By.id(id_String);
		System.out.println(doGetAttribute("ID", id_String, "placeholder"));
		//String text=doGetAttribute(id_Locator, "placeholder");
//		System.out.println(text);
	}
	
	public static By getBy(String locator_type, String elementValue ) {
		By locator=null;
		switch (locator_type.toLowerCase()) {
		case "id":
			locator=By.id(elementValue);
			
			break;
		case "name":
			locator=By.name(elementValue);
			
			break;

		default:
			break;
		}return locator;
	}
	
	
	public static WebElement doGetElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static String doGetAttribute(String locator_type, String elementValue, String attrValue) {
		By locator=getBy(locator_type, elementValue);
		return doGetElement(locator).getAttribute(attrValue);
	}
	
	public static String doGetAttribute(By locator, String attribute_value) {
		return doGetElement(locator).getAttribute(attribute_value);
	}
	
	

}
