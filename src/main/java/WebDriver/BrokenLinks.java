package WebDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
	static WebDriver driver;
	public static void main(String[] args) throws Exception{
		driver=new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(1000));
		
		Thread.sleep(2000);
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		for(WebElement e : links) {
			String url=e.getAttribute("href");
			verifyLink(url)
;			
		}
	
	}
	public static void verifyLink(String linkurl) {
		
		try {
			URL url = new URL(linkurl);
			HttpURLConnection cts=(HttpURLConnection)url.openConnection();
			cts.connect();
			if(cts.getResponseCode()==200) {
				System.out.println(url + ": ok" );
			}else if(cts.getResponseCode()==400) {
				System.out.println(url + ": Bad Request" );
			}else if(cts.getResponseCode()==401) {
				System.out.println(url + ": unautorized" );
			}else if(cts.getResponseCode()==403) {
				System.out.println(url + ": Forbidden" );
			}else if(cts.getResponseCode()==404) {
				System.out.println(url + ": not found" );
			}else if(cts.getResponseCode()==500) {
				System.out.println(url + ": Server Error" );
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	

}
