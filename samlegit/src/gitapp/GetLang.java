package gitapp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetLang {
	
	
	WebDriver driver;
	String url;
	@BeforeMethod
	public void open()
	{
		driver =new FirefoxDriver();
		driver.get("http:gmail.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@Test
	public void  getlang()
	{
		try {
			FileInputStream fis=new FileInputStream("D:/Test Data/l2.xls");
			HSSFWorkbook wbo=new HSSFWorkbook(fis);
			Sheet wso=wbo.getSheet("Sheet2");
			Row r;
			int rowcount=wso.getLastRowNum();
			for (int i =0; i < rowcount; i++) {
				r=wso.getRow(i);
				WebElement drop=driver.findElement(By.xpath(".//*[@id='lang-chooser']"));
				
			drop.sendKeys(r.getCell(1).getStringCellValue());
			drop.click();
			url=driver.getCurrentUrl();
			r.createCell(1).setCellValue(url);
			FileOutputStream fos=new FileOutputStream("D:/Test Data/l2.xls");
			wbo.write(fos);
			//System.out.println(url);			
				
			}
//			WebElement drop=driver.findElement(By.xpath(".//*[@id='lang-chooser']"));
//			drop.click();
//			List<WebElement>langlist=drop.findElements(By.tagName("option"));
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
