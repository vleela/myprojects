package gitapp;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SampleFlight {
	WebDriver driver;
	String str=null;	
@BeforeMethod 

public void openapp()
{
		driver=new FirefoxDriver();
		driver.get("https://8947674sandbox.com.mm/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
}



@Test
public void EnterSearchdetails()
{
	try {
		
				
				//From,To Mouse actions
				Actions action =new Actions(driver);
				
				WebElement from=driver.findElement(By.xpath(".//*[@id='intorgcity1']"));
				action.moveToElement(from).click();
				WebElement origin=driver.findElement(By.xpath(".//*[@id='internationalselect_dom_hot_cities']/div[1]/li/div"));
				
				action.moveToElement(origin).click();
				action.moveToElement(from).moveToElement(origin).build().perform();	
				//to actions
				WebElement to=driver.findElement(By.xpath(".//*[@id='intdescity1']"));
				action.moveToElement(to).click();
				WebElement destiny=driver.findElement(By.xpath(".//*[@id='internationalselect_dom_hot_cities1']/div[3]/li/div"));
				action.moveToElement(destiny).click();
				action.moveToElement(to).moveToElement(destiny).build().perform();
				//select date
				driver.findElement(By.xpath(".//*[@id='dom_checkin_date']")).click();
				//select adults
				WebElement Fromddl=driver.findElement(By.xpath(".//*[@id='dom_adults']"));
				Select oselect=new Select(Fromddl);
				oselect.selectByIndex(0);
				//click seach
					driver.findElement(By.xpath(".//*[@id='search-domesticflights']")).click();
					
					Thread.sleep(2000);
					
				//serach panel		
			//WebElement Serachitems= driver.findElement(By.xpath(".//*[@id='flight_book']/div[1]"));
					
					
					/*WebDriverWait wait=new WebDriverWait(driver, 10);*/
			WebElement flighttime= driver.findElement(By.xpath(".//*[@id='cabin_class']"));
			Thread.sleep(2000);
			
			//List<WebElement>checklist=flighttime.findElements(By.xpath(".//*[@id='active']"));
			
				List<WebElement>checklist=flighttime.findElements(By.tagName("input"));
				Thread.sleep(2000);
				//WebDriverWait wait=new WebDriverWait(driver, 20);
				for (int i = 0; i < checklist.size(); i++) 
				{
					System.out.println(checklist.get(i).getAttribute("value"));
					
					//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					
					/*WebElement e1=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.tagName("input"))));
					e1.click();*/
					Thread.sleep(2000);
						checklist.get(i).click();
					
					WebElement searchlistpage=driver.findElement(By.xpath(".//*[@id='flight_book']/div[2]"));
					
				List<WebElement>ftlist=searchlistpage.findElements(By.className("tab-content"));
				
				if(!ftlist.isEmpty())
				{
					
					//System.out.println(flighttime.getText());
						
				for (int j = 0; j < ftlist.size(); j++) {
					
					Thread.sleep(2000);
				System.out.println(ftlist.get(j).getText());
		
				//System.out.println(ftlist.get(i).findElement(By.id("results_flights")));
									
				}
				}
				checklist.get(i).click();
					
					
					
				}
					
				
				//str= driver.getCurrentUrl();
				///String exp=str;
				//if(exp.equals(str))
				//{
				//	System.out.println("succefully searched");
				//}
				
				
		
	} catch (Exception e) 
	{
		
		System.out.println(e);
	}
	
	
}


@AfterTest
public void CloseOway()
{
	driver.quit();
}

}
