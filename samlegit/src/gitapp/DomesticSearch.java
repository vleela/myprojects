package gitapp;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.bcel.generic.DREM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DomesticSearch {
	
	WebDriver driver;
	
	
	@BeforeMethod
	public void open()
	{
		driver =new FirefoxDriver();
		driver.get("http://2995123sandbox.oway.com.mm/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	}
	
	@Test
	public void HotelSearch()
	{
		try {
			driver.findElement(By.xpath(".//*[@id='pageone ']/div[2]/div[1]/a/div[1]")).click();
			driver.findElement(By.id("ui-id-1"));
			driver.findElement(By.id("city_name")).click();
			WebElement city=driver.findElement(By.id("src_city_name"));
			List<WebElement>citylist=city.findElements(By.tagName("li"));
			for (int i = 0; i < citylist.size(); i++) {
				System.out.println(citylist.size());
				citylist.get(i).click();
				
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
	}

}
