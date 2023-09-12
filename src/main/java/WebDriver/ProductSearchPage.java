package WebDriver;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductSearchPage {
	static WebDriver driver;

	public static void main(String[] args) throws Exception{
		driver=new ChromeDriver();
		driver.get
		("https://naveenautomationlabs.com/opencart/index.php?route=product/product&product_id=43&search=macbook");
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		////ul[@class='thumbnails']/li
		
		int imagesCount=driver.findElements(By.xpath("//ul[@class='thumbnails']/li")).size();
		System.out.println(imagesCount);
		
		String header=driver.findElement(By.xpath("//h1[text()='MacBook']")).getText();
		System.out.println(header);
		////div[@class='col-sm-4']/ul[@class='list-unstyled'][1]/li
		Map<String, String> map= new HashMap<String, String>();
		List<WebElement> product=driver.findElements(By.xpath("//div[@class='col-sm-4']/ul[@class='list-unstyled'][1]/li"));
		for(WebElement e : product) {
			String prod[]=e.getText().split(":");
			String key=prod[0].trim();
			String value=prod[1].trim();
			map.put(key, value);
		}
		Iterator<Entry<String, String>> it=map.entrySet().iterator();
		while(it.hasNext()) {
			Entry<String,String> e=it.next();
			String key=e.getKey();
			String value=e.getValue();
			System.out.println("Value of product info is :"+ key);
			System.out.println("Value of value  is :"+ value);
			
		}

	}

}
