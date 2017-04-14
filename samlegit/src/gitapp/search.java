package gitapp;



	import java.io.FileInputStream;
import java.io.FileOutputStream;

	import java.util.concurrent.TimeUnit;

	import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

	public class search {
		//CommonLocators cl=new CommonLocators();
		String url;
		WebDriver driver;
		//Actions action =new Actions(driver);
		
		@BeforeSuite
		public void OpenOway()
		{
//			cl.OpenBrowser();
			 driver=new FirefoxDriver();
			driver.get("http://8947674sandbox.oway.com.mm/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
		
		@Test
		public void search1()
		{
		
		
				try {
					FileInputStream fis=new FileInputStream("D:\\owayTestData\\searchdetails.xls");
					HSSFWorkbook wbo=new HSSFWorkbook(fis);
					Sheet wso=wbo.getSheet("citylist");
					Row r;
					int rowcount=wso.getLastRowNum();
					for (int i =1; i < rowcount; i++) {
						r=wso.getRow(i);
						
						driver.findElement(By.xpath(".//*[@id='tab-2']/a/span")).click();
						//click domestic
						driver.findElement(By.xpath(".//*[@id='flight']/div[1]/input[1]")).click();
						//click one way
						driver.findElement(By.xpath(".//*[@id='lo-oneway']")).click();
												
						//xpath of "To" text box
						WebElement from=driver.findElement(By.xpath(".//*[@id='intorgcity1']"));
						
						from.sendKeys(r.getCell(0).getStringCellValue());
						from.click();
						for(int j=1;j<rowcount;j++)
						{
							r=wso.getRow(j);
							WebElement To=driver.findElement(By.xpath(".//*[@id='intdescity1']"));
							To.sendKeys(r.getCell(1).getStringCellValue());
							To.click();
							driver.findElement(By.xpath(".//*[@id='dom_checkin_date']")).click();
							Select Adult=new Select(driver.findElement(By.xpath(".//*[@id='dom_adults']")));
							Adult.selectByIndex(0);
							driver.findElement(By.xpath(".//*[@id='search-domesticflights']")).click();
						
							url=driver.getCurrentUrl();
							wso=wbo.getSheet("result");
							System.out.println(url);
							//driver.navigate().back();
//						url=driver.getCurrentUrl();
					r.createCell(1).setCellValue(url);
					FileOutputStream fos=new FileOutputStream("D:\\owayTestData\\searchdetails.xls");
					wbo.write(fos);
					//System.out.println(url);			
						
					}
					}

					
				} catch (Exception e) {
					// TODO: handle exception
				}
			
	}
	}



	
	
	
	

