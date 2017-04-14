package gitapp;

import java.util.List;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Gmail {
	WebDriver driver;

	@BeforeMethod
	public void open() {
		driver = new FirefoxDriver();
		driver.get("http://www.bing.com/");
		System.out.println("Open bing site");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void link() {
		try {
			List<WebElement> links = driver.findElements(By.tagName("a"));
			for (int i = 0; i < links.size(); i++) {
				System.out.println(links.size());
				if (links.get(i).isDisplayed()) {
					System.out.println(links.get(i).getText());
					links.get(i).click();
					System.out.println(driver.getCurrentUrl());
					driver.navigate().back();
					links = driver.findElements(By.tagName("a"));
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
