package gitapp;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class Sqp {
	HtmlUnitDriver driver;
	@Test
	public void testSearchReturnsResults() {
		try {
			DesiredCapabilities cap=new DesiredCapabilities();
			cap.setBrowserName("Mozilla");
			   HtmlUnitDriver  driver = new  HtmlUnitDriver(cap);
				
	           driver.manage().window().setSize(new Dimension(2920, 2080));
	   
	           driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);  
	           driver.get("http://devtestserver.oway.com.mm/");
	 		  driver.manage().window().setSize(new Dimension(2920, 2080));
	 		  Thread.sleep(3000);
	 		driver.findElement(By.id("newhomecar")).click();
	 		driver.findElement(By.xpath("//input[@class='localusage']")).click();
	 		driver.findElement(By.id("lusg_cty_name")).click();
	 		driver.findElement(By.xpath(".//*[@id='localUsageCarCities']/div[1]/li/div")).click();
	 		WebElement service=driver.findElement(By.id("lusg_service_typ"));
	 		Select sec=new Select(service);
	 		sec.selectByVisibleText("Half day");
	 		driver.findElement(By.id("car_local_usage")).click();
	 	Thread.sleep(1000);
	 	WebElement result=driver.findElement(By.xpath(".//h4[@class='search-results-title ng-binding']"));
	 	System.out.println(result.getText());
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		 
	}

}
