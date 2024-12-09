package frame4;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class parent_1 {
	ChromeDriver driver;
//	 @BeforeSuite
//	 public void term1() {
//		 System.out.println("started Sucessfully");
//	 }
	@BeforeMethod
	public void begin()  {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void demoTest() {
		driver.get("https://omayo.blogspot.com/");
		driver.findElement(By.id("ironman4")).click();
	}
	 
	@AfterMethod

public void end() {
	driver.quit();
	System.out.println("end of TEST");
}
//	 @AfterTest
//	   public void testReporting() {
//	       System.out.println("Test Report generated using AfterTest");
//	   }
//	 @AfterSuite
//	 public void term() {
//		 System.out.println("Running Sucessfully");
//	 }
}


