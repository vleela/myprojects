import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class gvffd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			
		
		// TODO Auto-generated method stub
		WebDriver driver;
		driver =new FirefoxDriver();
		driver.get("https://devtestserver.oway.com.mm/");
		driver.manage().window().maximize();
		//click CarRental tab
		driver.findElement(By.xpath("//*[@id='newhomecar']")).click();
		//click Local Usage tab
		driver.findElement(By.xpath("//*[@id='car']/div[1]/input[1]")).click();
		//click city name
		driver.findElement(By.id("city_name")).click();
		//select city
		driver.findElement(By.xpath(".//*[@id='localUsageCarCities']/div[1]/li/div")).click();
		//select Service Type
		WebElement serviceType=driver.findElement(By.id("serviceType"));
		Select	sec=new Select(serviceType);
		sec.selectByVisibleText("Half day");
		//select Number of Days
		WebElement numberofDays=driver.findElement(By.id("noOfDays"));
		sec=new Select(numberofDays);
		sec.selectByIndex(2);
		 //Click Search
		driver.findElement(By.id("car_local_usage")).click();
		//WebElement slider=driver.findElement(By.id("price-filter"));
		WebElement left=driver.findElement(By.xpath("//*[@id='price-filter']/div/div/div/div/i"));
		WebElement StartValue=driver.findElement(By.xpath("//*[@id='price-filter']/div/span[1]"));
		String d=StartValue.getText().substring(1, 4);
		int b=Integer.parseInt(d);
		WebElement EndValue=driver.findElement(By.xpath("//*[@id='price-filter']/div/span[2]"));
		String c=EndValue.getText().substring(1, 3);
		int a=Integer.parseInt(c);
 		Actions action = new Actions(driver);
		//int numberOfPixelsToDragTheScrollbarDown = 9;
		for (int  i = 42; i<a;  i ++)
        {
			if(b!=a){
            // this causes a gradual drag of the scroll bar, 10 units at a time
			action.dragAndDropBy(left, i, i).build().perform();
           // action.moveToElement(left). clickAndHold().moveByOffset(i, 0).release().perform();
			 Thread.sleep(100);
			}
        }
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
}
}
