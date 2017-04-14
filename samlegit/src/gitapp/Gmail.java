package gitapp;



//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.util.List;

import java.util.List;

import java.util.concurrent.TimeUnit;

//import org.apache.poi.hssf.usermodel.HSSFWorkbook;

//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;





import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Gmail {
	WebDriver driver;
	@BeforeMethod
	public void open()
	{
		driver =new FirefoxDriver();
		driver.get("http://www.bing.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@Test
	public void link() 
	{
		try {
		
		
			List<WebElement>links=driver.findElements(By.tagName("a"));
			for (int i = 0; i < links.size(); i++) {
				System.out.println(links.size());
				if (links.get(i).isDisplayed()) {
					System.out.println(links.get(i).getText());
					links.get(i).click();
					System.out.println(driver.getCurrentUrl());
					driver.navigate().back();
					links=driver.findElements(By.tagName("a"));
					
				}
				
			}

//			FileInputStream fis=new FileInputStream("D:/Leela/workspace/Test Data/l2.xls");
//	HSSFWorkbook wbo=new HSSFWorkbook(fis);
//	
//		Sheet wso=wbo.getSheet("sheet1");
//		Row r;
//		WebElement drop=driver.findElement(By.xpath(".//*[@id='lang-chooser']"));
//		drop.click();
//		List<WebElement>langlist=drop.findElements(By.tagName("option"));
//		for (int i = 0; i < langlist.size(); i++) {		
//			
//			r=wso.createRow(i);
//		r.createCell(0).setCellValue(langlist.get(i).getText());
//		
//		}
//		
//		FileOutputStream fos=new FileOutputStream("D:/Leela/workspace/Test Data/l2.xls");
//		wbo.write(fos);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
	
		
			
//			langlist.get(i).click();
//			String s=	driver.getCurrentUrl();
//			System.out.println(s);
//			Thread.sleep(3000);
//			driver.navigate().refresh();
//			driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
//			langlist=drop.findElements(By.tagName("option"));
//			drop.click();
//			if(langlist.get(i).isDisplayed())
//			{
//				System.out.println(langlist.get(i).getText()+"Active");
//			}
//			else {
//				System.out.println(langlist.get(i).getText()+"InActive");
//				
//			}
		
			
		
	}


}
