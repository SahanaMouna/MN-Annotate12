package pack6;

public class BASIC1 {
	public class TestNGAnnotationsHierarchy {
		@Test
		public void testCase1() {
		   System.out.println("This is Test Case 1");
		}
		@Test
		public void testCase2() {
		   System.out.println("This is Test Case 2");
		}
		@BeforeMethod
		public void beforeMethod() {
		   System.out.println("This will execute before every Test Method");
		}
		@AfterMethod
		public void afterMethod() {
		   System.out.println("This will execute after every Test Method");
		}
		@BeforeClass
		public void beforeClass() {
		   System.out.println("This will execute before the Class");
		}
		@AfterClass
		public void afterClass() {
		   System.out.println("This will execute after the Class");
		}
		@BeforeTest
		public void beforeTest() {
		   System.out.println("This will execute before the First Test");
		}
		@AfterTest
		public void afterTest() {
		   System.out.println("This will execute after the Last Test");
		}
		@BeforeSuite
		public void beforeSuite() {
		   System.out.println("This will execute before the Test Suite");
		}
		@AfterSuite
		public void afterSuite() {
		   System.out.println("This will execute after the Test Suite");
		}
		}
		view rawTestNGAnnotationsHierarchy.java hosted with ❤ by GitHub
		Upon execution, this is how the output for this code snippet would be, where all the methods get executed as per the hierarchy of the annotations.

		hierarchy of the annotations

		Looking at this code example and the output, it is evident that TestNG diligently sticks to the defined execution order for annotations.

		Observing this example, one might wonder how the two @Test methods decide which to execute first. It is addressed through test case priority while using TestNG in Selenium. The later section of this TestNG in Selenium tutorial will delve into this aspect, providing insights into how test case priority is managed within TestNG to control the execution sequence of multiple test methods.

		TestNG Attributes
		Like a method in Java, TestNG annotations come with attributes that enhance the definition of our tests and provide additional information about the test script during Selenium automation testing with TestNG. These attributes include.

		description: Allows you to provide a description or additional information about the test method.
		 @Test(description = "this is the definition of the test") 
		1
		 @Test(description = "this is the definition of the test") 
		groups: This attribute facilitates grouping test cases with similar functionalities under a common group by assigning them a group name. It is highly useful when a user wants to execute test cases belonging to a particular group or exclude test cases of a specific group from execution. By using the groups attribute, testers can organize and execute tests based on their functionality, making it a valuable tool for managing and executing targeted subsets of test cases during automation testing with TestNG in Selenium.
		 @Test(groups = "DashboardCases") 
		1
		 @Test(groups = "DashboardCases") 
		dependsOnMethods: The test having this attribute is only executed if the dependent test method passes. If it fails or is not executed, then the test with this attribute is skipped from execution.
		 @Test(dependsOnMethods = "LoginFunctionality") 
		1
		 @Test(dependsOnMethods = "LoginFunctionality") 
		alwaysRun: It ensures that this test method always runs and is not dependent on the result of the methods it depends upon.
		 @Test(alwaysRun = true) 
		1
		 @Test(alwaysRun = true) 
		dataProvider: This attribute is used when we want to run a test case on a particular data set (e.g., running the same test case on different browsers). This attribute provides the data to the test case for which it is used with the help of another method annotated with @DataProvider annotation of TestNG.
		 @Test(dataProvider = "CrossBrowserTesting") 
		1
		 @Test(dataProvider = "CrossBrowserTesting") 
		We will learn more about @DataProvider in further sections of this TestNG in Selenium guide.

		enabled: This attribute is helpful when we want to skip executing a particular test case. It helps to do so by setting the value to false.
		 @Test(enabled = false) 
		1
		 @Test(enabled = false) 
		timeOut: This attribute defines the max execution time for a test case. In other words, the test case should be completed in the given time, which is given in milliseconds, or the test execution would be terminated, and the case would be marked as failed with timeout exception org.testng.internal.thread.ThreadTimeoutException.
		 @Test(timeOut = 5000) 
		1
		 @Test(timeOut = 5000) 
		Learn more about handling different types of exceptions in Selenium through this blog on common Selenium exceptions and get valuable insights.

		invocationCount: This attribute is used when we want to execute the test case in a loop for a given number of times.
		 @Test(invocationCount = 3) 
		1
		 @Test(invocationCount = 3) 
		invocationTimeOut: This attribute is combined with the invocationCount attribute. This attribute defines the timeframe within which the test should execute for a given number of times.
		 @Test(invocationCount = 3, invocationTimeOut = 20) 
		1
		 @Test(invocationCount = 3, invocationTimeOut = 20) 
		The above code will execute the case 3 times in 20 milliseconds.

		expectedExceptions: This attribute helps to handle the exceptions that the test method is expected to throw. If the test method throws the exception set on the attribute, then the test case passes, and for any other unhandled exception, the test method fails.
		 @Test(expectedExceptions = {ArithmeticException.class}) 
		1
		 @Test(expectedExceptions = {ArithmeticException.class}) 
		priority: This attribute is used to define the order of execution by assigning priorities to the test cases. A test method with lower priority is always executed first.
		 @Test(priority=1), @Test(priority=2) 
		1
		 @Test(priority=1), @Test(priority=2) 
		In this case, the test with priority 1 is executed first, followed by the test with priority 2.

		Consider the below code example to understand attribute implementation.

		package test;
		 
		import org.testng.annotations.AfterGroups;
		import org.testng.annotations.BeforeGroups;
		import org.testng.annotations.Test;
		 
		public class TestNGAttributesExample {
		 
		@Test(enabled = false, description = "This test will be skipped as enabled is set to false")
		public void disabledTest() {
		System.out.println("This method will be skipped from the test run using the attribute enabled=false");
		}
		 
		@Test(invocationCount = 5, invocationTimeOut = 20, groups = "testngAttributes")
		public void invocationCountTest() {
		System.out.println("This method will be executed by 5 times");
		}
		 
		@Test(timeOut = 500, groups = "testngAttributes")
		public void baseTest() {
		System.out.println("This is base test method");
		}
		 
		@Test(dependsOnMethods = "baseTest", groups = "testngAttributes")
		public void firstDependentTest() {
		System.out.println("This is dependent method 1 and will only execute if baseTest passes");
		}
		 
		@Test(alwaysRun = true, dependsOnMethods = "baseTest", groups = "testngAttributes")
		public void secondDependentTest() {
		System.out.println(
		"This is dependent method 2 and will execute irrespective of baseTest result because of alwaysRun");
		}
		 
		@BeforeGroups("testngAttributes")
		public void beforeGroupMethod() {
		System.out.println("This method is executed before testngAttributes group test cases");
		}
		 
		@AfterGroups("testngAttributes")
		public void afterGroupMethod() {
		System.out.println("This method is executed after testngAttributes group test cases");
		}
		}
		view rawTestNGAttributesExample.java hosted with ❤ by GitHub
		Result:

		Result

		TestNG Priorities
		As mentioned earlier in this TestNG in Selenium tutorial, test case execution is influenced by the priority assigned to test cases. However, if no priority is explicitly assigned, TestNG defaults to executing test cases alphabetically. Without specified priorities, the execution order is determined by the alphabetical order of the test method names.

		For example, in the following code snippet, aTest would be executed before bTest based on their alphabetical order.

		@Test
		public void aTest()
		{}
		 
		@Test
		public void bTest()
		{}
		1
		2
		3
		4
		5
		6
		7
		@Test
		public void aTest()
		{}
		 
		@Test
		public void bTest()
		{}
		Now, let’s consider a scenario where we want to execute bTest first. In such cases, the priority attribute in TestNG is utilized. We can achieve this by assigning a lower priority to the test we want to execute first. Priorities in TestNG can be assigned starting from 0, where lower priority cases are executed first.

		@Test(priority = 2)
		public void aTest()
		{}
		 
		@Test(priority = 1)
		public void bTest()
		{}
		1
		2
		3
		4
		5
		6
		7
		@Test(priority = 2)
		public void aTest()
		{}
		 
		@Test(priority = 1)
		public void bTest()
		{}
		In this case, bTest will be executed before aTest. The next question arises: What if the same priority is assigned to both test cases?

		When the same priority is assigned to multiple test cases, TestNG does not guarantee a specific execution order. In such situations, test cases with the same priority may be executed alphabetically based on their method names. Therefore, it’s essential to avoid relying on the order of test cases with identical priorities and consider alternative approaches if a specific execution order is crucial for your test scenarios. Let us understand this with a simple example below.

		@Test(priority = 1)
		public void aTest()
		{}
		 
		@Test(priority = 1)
		public void bTest()
		{}
		1
		2
		3
		4
		5
		6
		7
		@Test(priority = 1)
		public void aTest()
		{}
		 
		@Test(priority = 1)
		public void bTest()
		{}
		@Test(priority = 1)
		public void aTest()
		{}
		@Test(priority = 1)
		public void bTest()
		{}
		In such a case, TestNG runs the test cases with the same priority in alphabetical order. Therefore, aTest will be executed before bTest.

		Another scenario could be that the test class file is a combination of test cases with and without priority like below

		package test;
		 
		import org.testng.annotations.Test;
		 
		public class TestNGPrioritiesExample {
		@Test(priority = 1)
		public void aTest() {
		System.out.println("This is test a.");
		}
		 
		@Test(priority = 2)
		public void bTest() {
		System.out.println("This is test b.");
		}
		 
		@Test
		public void cTest() {
		System.out.println("This is test c.");
		}
		 
		@Test(priority = 1)
		public void dTest() {
		System.out.println("This is test d.");
		}
		 
		@Test
		public void eTest() {
		System.out.println("This is test e.");
		}
		 
		}
		view rawTestNGPrioritiesExample.java hosted with ❤ by GitHub
		In such a case, TestNG, by default, assigns a priority of 0 to test cases that do not have the priority attribute. These cases are executed alphabetically, followed by others based on their priorities. So, the output for the above code would be.

		Result:

		all about priorities

		This is all about priorities, and these would be highly beneficial to use in any automation script while working with TestNG in Selenium. To learn more about the test case priority, go through our earlier blog on prioritizing tests with TestNG in Selenium.

		This overview covers the priorities in TestNG, which proves highly beneficial when designing and organizing automation scripts with TestNG in Selenium. Priorities allow you to control the order in which test cases are executed, providing flexibility and customization in your test suite. Exploring the various test case priorities will empower you to structure and manage your Selenium test suites effectively, ensuring optimal execution based on your specific requirements.

		As we learned about the attributes in TestNG, we came across data providers, which we will cover in detail in the following section.

		DataProviders in TestNG
		DataProviders in TestNG are an integral part of the built-in TestNG data-driven testing approach. They are used to pass various values to the same TestNG test class through the @DataProvider annotation

		DataProviders enable the creation of data-driven tests where the same test logic can be executed with different input data sets. By leveraging DataProviders, you can enhance the versatility of your tests and ensure thorough coverage of different scenarios, contributing to a more comprehensive and effective testing strategy in your TestNG-based Selenium automation. Let us understand the DataProvider annotation with a sample below.

		TestNG DataProvider sample:

		@DataProvider(name = "dataProvider_name")
		public Object[][] dataProviderMethod() {
		return new Object[][] {<values>};
		}
		1
		2
		3
		4
		@DataProvider(name = "dataProvider_name")
		public Object[][] dataProviderMethod() {
		return new Object[][] {<values>};
		}
		The @DataProvider annotation consists of only one attribute, which is the name attribute, and it is always of type String. If the name is not explicitly provided, the method’s name becomes the data provider name by default, such as dataProviderMethod.

		A DataProvider method in TestNG always returns a 2-D list of objects. The test method associated with this data provider executes using a data-driven approach on each passed argument.

		Let’s consider an example of a simple cross-browser code where we want to navigate to a website on Chrome and Firefox browsers using TestNG DataProvider.

		package test;
		 
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.openqa.selenium.firefox.FirefoxDriver;
		import org.testng.annotations.DataProvider;
		import org.testng.annotations.Test;
		 
		public class DataProviderExample {
		 
		@DataProvider(name = "browserName")
		public Object[][] browserName()
		{
		return new Object[][] { { "chrome" }, { "firefox" } };
		}
		 
		@Test(dataProvider = "browserName")
		public void crossBrowserTest(String browser)
		{
		WebDriver driver = null;
		System.out.println("Launching browser : " + browser);
		switch(browser)
		{
		case "chrome":
		System.setProperty("webdriver.chrome.driver", "<Path_to_your_chrome_driver>");
		driver = new ChromeDriver();
		break;
		case "firefox":
		System.setProperty("webdriver.firefox.driver", "<Path_to_your_firefox_driver>");
		driver = new FirefoxDriver();
		break;
		default:
		System.out.println("Invalid browser name passed");
		}
		driver.navigate().to("http://www.lambdatest.com/");
		System.out.println("Navigated Successfully to the website");
		}
		 
		}
		view rawDataProviderExample.java hosted with ❤ by GitHub
		In the provided code, we have implemented a DataProvider named browserProvider, passing two values: Chrome and Firefox. These values are then passed to the test method testCrossBrowser using the parameter browserName, and the test case is executed sequentially on both browsers.

		This example illustrates a classic implementation of cross-browser testing, where the same script is executed on multiple browsers using TestNG DataProvider.

		The expected output of executing the above code would be.

		implemented a DataProvider named browserProvider

		One thing to note here is that, despite having only one method annotated with @Test, the execution shows two test cases being executed. This is because we passed two different values to the test case using the DataProvider, and hence, TestNG treats it as two separate test cases. The differentiation in test data leads to TestNG considering each data set as an individual test case, demonstrating the versatility of the data-driven approach facilitated by DataProviders.

		TestNG Assertions
		Assertions in TestNG provide a mechanism to verify if the actual and expected results of the test case execution match, determining the outcome of the test case—whether it is a pass or fail. They are extensively used to validate results in any TestNG script for Selenium.

		An example of TestNG assertions could be validating the username on the dashboard after a user logs into a website.

		The syntax for TestNG assert:

		Assert.Method(actual, expected, message)
		1
		Assert.Method(actual, expected, message)
		actual: the actual value fetched from the test case as a part of the execution.
		expected: the expected value we want to compare with the actual value.
		message: string message to be displayed in case of assert failure.
		Types of TestNG Asserts
		Hard Assert: These are the default assertions while working with TestNG in Selenium. These assertions stop the test case execution when any assert fails and subsequent statements are not executed/validated. These are used when subsequent steps in the test cases are not to be executed when a particular step assertion fails.
		Soft Assert: These are the opposite of hard asserts. In the case of soft assert, the test case execution of subsequent steps continues even if some assert fails in between. These are used when we want to continue the execution and see the results for all steps, even if a few fail in between. To use soft asserts, org.testng.asserts.SoftAssert package needs to be included.
		The most commonly used TestNG asserts are:

		assertTrue: This assertion verifies whether the given condition is true. If false, it will fail the test case.
		Assert.assertTrue(condition, message);
		1
		Assert.assertTrue(condition, message);
		assertFalse: This assertion verifies whether the given condition is false. If true, it will fail the test case.
		Assert.assertFalse(condition, message);
		1
		Assert.assertFalse(condition, message);
		assertEquals: This assertion verifies if the actual and expected are a match. If they match, it passes the test case; otherwise, it fails.
		Assert.assertEquals(actual, expected, message);
		1
		Assert.assertEquals(actual, expected, message);
		assertNotEquals: This assertion verifies if the actual and expected are not a match. If they match, the test case fails. Otherwise, it passes.
		Assert.assertNotEquals(actual, expected, message);
		1
		Assert.assertNotEquals(actual, expected, message);
		Watch this video to learn what are TestNG assertions, the different types of TestNG assertions, and how you can use them while performing automation testing with TestNG in Selenium.

		Youtube Thubnail
		Demonstration: Using TestNG in Selenium
		By now, this TestNG in Selenium tutorial has covered almost all the main features of the TestNG framework that you would need to write your first Java automation script. The following code example will combine all the annotations, attributes, priorities, data providers, and assertions we have learned.

		The following test scenario will be executed by this code (to print and verify the sum of 2 numbers)

		Test Scenario:

		Create a dataProvider that passes values as firstValue, secondValue, and expectedSum.
		Navigate to https://www.lambdatest.com/selenium-playground/simple-form-demo.
		Run Test 1 with the first set of values, {1, 4, 5}. This test should pass as the expected sum is correct.
		Clear the old values from the form.
		Run Test 2 with the second set of values, {2, 4, 7}. This test should fail as the expected sum is not correct. We intentionally pass incorrect expected values to see the differences in output and test reports for passed and failed cases. Always remember that ideally, the expected should always be the correct value.
		Execute the code and analyze the reports.
		In addition to this test case, we will add two more test cases with priority to showcase the usage, along with one of them having an invocationCount attribute to show the case getting executed multiple times as per priority.

		package test;


		import java.net.MalformedURLException;
		import java.net.URL;
		import org.openqa.selenium.By;
		import org.openqa.selenium.remote.*;
		import org.testng.Assert;
		import org.testng.annotations.*;
		import java.util.HashMap;
		import org.openqa.selenium.chrome.ChromeOptions;


		public class SeleniumTestNGExample() {


		   public RemoteWebDriver driver = null;
		   String username = System.getenv("LT_USERNAME") == null ? "<lambdatest_username>" : System.getenv("LT_USERNAME");
		   String accessKey = System.getenv("LT_ACCESS_KEY") == null ? "<lambdatest_accesskey>" : System.getenv("LT_ACCESS_KEY");


		   @BeforeSuite
		   public void setUp() {
		       ChromeOptions chromeOptions = new ChromeOptions();
		       chromeOptions.setPlatformName("Windows 10");
		       chromeOptions.setBrowserVersion("121.0");
		      
		       HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		       ltOptions.put("username", username);
		       ltOptions.put("accessKey", accessKey);
		       ltOptions.put("project", "TestNG Selenium");
		       ltOptions.put("build", "TestNG Selenium Demonstration");
		       ltOptions.put("selenium_version", "4.0.0");
		       chromeOptions.setCapability("LT:Options", ltOptions);


		       try {
		           driver = new RemoteWebDriver(
		                   new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"), chromeOptions);
		       } catch (MalformedURLException e) {
		           System.out.println("Invalid grid URL");
		       }
		       System.out.println("The driver setup process is completed using BeforeSuite");
		   }


		   @BeforeTest
		   public void browserProfile() {
		       driver.manage().window().maximize();
		       System.out.println("The browser profile is updated using BeforeTest");


		   }


		   @BeforeClass
		   public void navigateToUrl() {
		       driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
		       System.out.println("Navigated to URL using BeforeClass");
		   }


		   @Test(description = "Test case with priority", priority = 1)
		   public void testPriotity()
		   {
		       System.out.println("This case has priority 1");
		   }
		  
		   @Test(description = "Test case with priority and invocation count", priority = 2, invocationCount = 2)
		   public void testInvocationCount()
		   {
		       System.out.println("This case has priority 2 and invocation count");
		   }
		  
		  
		   @DataProvider(name = "SanityTestData")
		   public Object[][] sanityTestDataProvider() {
		       String[][] testData = { { "1", "4", "5" }, { "2", "4", "7" } };
		       return testData;
		   }
		  
		   @Test(dataProvider = "SanityTestData", description = "Test case with group and data provider but without priority", alwaysRun = true, groups = { "sanity" })
		   public void testSumOfTwoValues(String firstValue, String secondValue, String expectedSum) {
		       // to enter data and submit
		       driver.findElement(By.id("sum1")).sendKeys(firstValue);
		       driver.findElement(By.id("sum2")).sendKeys(secondValue);
		       driver.findElement(By.xpath("//button[text()='Get Sum']")).click();


		       // to fetch actual result
		       String actualSum = driver.findElement(By.id("addmessage")).getText();


		       // to assert actual and expected result
		       Assert.assertEquals(actualSum, expectedSum,
		               "Expected and actual results do not match. Expected : " + expectedSum + " and Actual : " + actualSum);


		   }


		   @AfterMethod()
		   public void clearOldData() {
		       driver.findElement(By.id("sum1")).clear();
		       driver.findElement(By.id("sum2")).clear();
		   }


		   @AfterClass
		   public void closeDriver() {
		       driver.quit();
		       System.out.println("Quit the driver using AfterClass");
		   }


		   @AfterTest
		   public void testReporting() {
		       System.out.println("Test Report generated using AfterTest");
		   }
		}
		