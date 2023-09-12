package WebDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllLinksList {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		// get the link count available on page
		// Get all the links text available on page
		// get all the link that are not blank
//		List<WebElement> linkList = driver.findElements(By.tagName("a"));
//		System.out.println(linkList.size());
		By links = By.tagName("a");
		System.out.println(getTotalElementLinkCount(links));
		notBlankLinks(links);
		int blankLinks = getNotBlankElementCount(links);
		System.out.println(blankLinks);
//		for (int i = 0; i < linkList.size(); i++) {
//			String text = linkList.get(i).getText();
//			if (!text.isEmpty()) {
//				System.out.println(i + " : " + text);
//			}
//		}

	}

	public static List<WebElement> getElements(By locator) {

		return driver.findElements(locator);

	}

	public static int getTotalElementLinkCount(By locator) {
		List<WebElement> linkList = getElements(locator);
		int totalLink = linkList.size();
		return totalLink;
	}

	public static List<String> notBlankLinks(By locator) {
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

	public static int getNotBlankElementCount(By locator) {
		return notBlankLinks(locator).size();
	}

	public static int blankElementCount(By locator) {
		int totalLinks = getTotalElementLinkCount(locator);
		int totalNonLinks = getNotBlankElementCount(locator);
		return totalLinks - totalNonLinks;
	}

}
