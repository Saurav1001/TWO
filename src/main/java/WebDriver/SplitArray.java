package WebDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class SplitArray {

	static WebDriver driver;
	public static void main(String[] args) throws Exception{
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops);
		driver.manage().window().maximize();
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.findElement(By.name("search")).sendKeys("Macbook");
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
//		List<WebElement> eleList=driver.findElements
//		(By.xpath("//div[@class='product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12']"));
//		for(WebElement e:eleList) {
//			String text=e.getText();
//			System.out.println(text);
//			Thread.sleep(3000);
//			if(text.equalsIgnoreCase("MacBook")) {
//				e.click();
//			}
//		}
		Thread.sleep(2000);
		driver.findElement(By.linkText("MacBook")).click();
		//String priceInfo=driver.findElement(By.xpath("(//div[@class='col-sm-4']/ul)[2]")).getText();
		Map<String, String> product=new HashMap<String, String>();
		List<WebElement> proInfo=driver.findElements(By.xpath("(//div[@class='col-sm-4']/ul)[1]/li"));
		for(WebElement e: proInfo) {
			String text=e.getText();
			String metaInfo[]=text.split(":");
			String key=metaInfo[0].trim();
			String value=metaInfo[1].trim();
			product.put(key, value);
			}
		 product.forEach((k,v) -> System.out.println("Key = "
	                + k + ", Value = " + v));
		
		

	}

}
