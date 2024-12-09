package frame2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Child {
	@BeforeTest
	public void testOne() {
		System.out.println("Before Test");
	}
	@AfterTest
	public void testEnd() {
		System.out.println("After Test");
	}
	@BeforeClass
	public void classbefore() {
		System.out.println("Before class");
	}
	@AfterClass
	public void classAfter() {
		System.out.println("After class");
	}
	ChromeDriver driver;
	@BeforeMethod
	public void begin()  {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test(groups={"smoke"})
	public  void mid() {
		driver.get("https://omayo.blogspot.com/");
		
	}
	@Test
	public void shop() {
		driver.get("https://www.flipkart.com/");
	}
	@AfterMethod
	public void end() {
		driver.quit();
	}
	
}
