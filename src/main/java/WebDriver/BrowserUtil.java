package WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtil {
	
	private WebDriver driver;
	/**
	 * generally we  create variables of util class as private
	 * @param browserName
	 * @return WebDriver
	 */
	
	public WebDriver launchBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}else {
			System.out.println(browserName  + ": "+"Browser is not available");
		}return driver;
	}
	
	public void launchUrl(String url) {
		if(url==null) {
			System.out.println("Browser is null...please enter the valid url");
			return;
		}
		if(url.indexOf("http")==-1) {
			System.out.println("Http is missing...please enter the valid url");
			return;
		}
		if(url.indexOf("https")==-1) {
			System.out.println("Https is missing...please enter the valid url");
			return;
		}
		if((url.length())==0) {
			System.out.println("Browser is blank...please enter the valid url");
			return;
		}
		driver.get(url);
	}
	
	public String getTitle() {
		String title=driver.getTitle();
		System.out.println(title);
		return title;
	}
	
	public String getPageUrl() {
		String currenturl=driver.getCurrentUrl();
		System.out.println(currenturl);
		return currenturl;
	}
	
	public boolean urlFraction(String fraction) {
		if(getPageUrl().contains(fraction)) {
			return true;
		}else {
			return false;
		}
	}
	
	public void close() {
		driver.close();
	}
	public void quit() {
		driver.quit();
	}

}
