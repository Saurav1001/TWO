package WebDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DailyJava {   

	static WebDriver driver;  
	public static void main(String[] args) {
		
		driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		String value="Germany";
		int rowCount=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
		int colCount=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/th")).size();
		boolean flag=false;
		for(int i=1;i<rowCount;i++) {
			for(int j=1;j<=colCount;j++) {
			
				String text=driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+(i+1)+"]/td["+j+"]")).getText();
				System.out.println(i + " "+ j);
				if(text.equals(value)) {
					flag= true;
				}
			}
		}System.out.println(flag);
		}
		
	}

	


