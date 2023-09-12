package WebDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	static WebDriver driver;
	public static void main(String[] args) {
		driver= new ChromeDriver();
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
//		String footer="Information";
//		List<WebElement> list=driver.findElements(By.xpath("//h5[text()='"+footer+"']/parent::div/ul/li"));
//		System.out.println(list.size());
//		for(WebElement e : list) {
//			String text=e.getText();
//			System.out.println(text);
		//footerText();
		subFooter();
		}
	
	
	public static ArrayList<String>  footerText() {
		List<WebElement> list=driver.findElements(By.xpath("(//div[@class='row'])[last()]/div/h5"));
		System.out.println(list.size());
		ArrayList<String> al = new ArrayList<String>();
		for(WebElement e : list) {
			 String text=e.getText();
			System.out.println(text);
			al.add(text);
		}return al;
		
	}
	public static void subFooter() {
		ArrayList<String> al=footerText();
		for(String i : al) {
			List<WebElement> list=driver.findElements(By.xpath("//h5[text()='"+i+"']/parent::div/ul/li"));
			System.out.println("size of "+ i +" : " + list.size());
			//System.out.println("footer for "+ i + " are");
			for(WebElement e : list) {
				String text=e.getText();
				System.out.println(text);
			}System.out.println("****************");
		}
	}

}
