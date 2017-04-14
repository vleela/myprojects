package gitapp;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Sample {
	 WebDriver  driver;
	@Test
	
	public void testSearchReturnsResults() {
	    //Create instance of PhantomJS driver
		 {
				/*Capabilities caps = new DesiredCapabilities();
				((DesiredCapabilities) caps).setJavascriptEnabled(true);                
		        ((DesiredCapabilities) caps).setCapability("takesScreenshot", false);  
		        ((DesiredCapabilities) caps).setCapability(
		                PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
		                
		                "D:/Leela/Seleniumjarfiles/phantomjs-2.1.1-windows/phantomjs-2.1.1-windows/bin/phantomjs.exe"
		            );*/
		        // WebDriver  driver = new  PhantomJSDriver(caps);
			 DesiredCapabilities cap=new DesiredCapabilities();
				cap.setBrowserName("Mozilla");
		           driver = new  HtmlUnitDriver(cap);
			 
			 
	    //Navigate to the page
	    driver.get("http://www.appneta.com/");
	    driver.manage().window().setSize( new Dimension( 1124, 850 ) );
	 
	    //Click the Blog link
	    driver.findElement(By.linkText("Blog")).click();
	 
	    //Input the search term into the search box
	    String searchTerm = "Testing";
	    driver.findElement(By.id("s")).sendKeys(searchTerm);
	 
	    //Click the Search button
	    driver.findElement(By.cssSelector("input[value='Search']")).click();
	 
	    //Find the results
	    List<WebElement> results = driver.findElements(By.cssSelector(".post"));
	 
	    //Verify that at least one post is found
	    Assert.assertTrue(results.size() > 0);
	 
	    //Navigate to the first post result
	    results.get(0).findElement(By.cssSelector("a[rel='bookmark']")).click();
	 
	    //Verify that the search term is contained within the post
	    Assert.assertTrue(driver.getPageSource().toLowerCase().contains(searchTerm.toLowerCase()));
	  }
	}
}

