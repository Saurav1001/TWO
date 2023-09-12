package WebDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributeConcept {
	static WebDriver driver;

	public static void main(String[] args) {
		driver=new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		By links=By.tagName("a");
		//get all the href value for links
//		List<WebElement> hrL=driver.findElements(By.xpath("//a[@href]"));
//		System.out.println(hrL.size());
//		for(WebElement e: hrL) {
//			String text=e.getAttribute("href");
//			System.out.println(text);
		System.out.println(getHrefCount(links, "href"));
		System.out.println(getHrefText(links, "href"));
		
		}

	 public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static int getHrefCount(By locator, String attValue) {
		return getHrefText(locator, attValue).size();
		
	}
	public static List<String> getHrefText(By locator, String attValue)
	{
		List<WebElement> hrL=getElements(locator);
		List<String> hrefList=new ArrayList<String>();
		for(WebElement e: hrL) {
			String text=e.getAttribute(attValue);
			hrefList.add(text);
	}
		return hrefList;

}
}
