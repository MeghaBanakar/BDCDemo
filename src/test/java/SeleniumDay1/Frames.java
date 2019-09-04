package SeleniumDay1;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Frames {	  
	  ExtentHtmlReporter reporter;
	  ExtentReports extent;
	  ExtentTest logger;
	  WebDriver driver;
	  
	  @BeforeTest
	  public void startReport()
	  {
		  //user.dir gets the location of current java/maven project  It is automatically generated after executing the class
		  String path=System.getProperty("user.dir")+"/extent-reports/report1.html";
		  //reporter class helps to set the path of the project
		  reporter=new ExtentHtmlReporter(path);
		  //extent class helps to define tests and track the status of the tests(pass/fail)
		  extent=new ExtentReports();
		  extent.attachReporter(reporter);
		  extent.setSystemInfo("HostName", "Next Gen Automated Testing");
		  extent.setSystemInfo("Environment", "Selenium Automated Test");
		  extent.setSystemInfo("Username", "Megha");
		  reporter.config().setDocumentTitle("Testing in Selenium");
		  reporter.config().setTheme(Theme.DARK);
		  reporter.config().setReportName("TestMe End to End Automation Report");
		  driver=Driver.configureDriver("chrome");
		  driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
		  driver.manage().window().maximize();
		  
	  }
	  
	  @Test(priority=1)
	  public void testRegistration()
	  {
		  logger=extent.createTest("testRegistration","Customer registers the details in TestMethod");
		  //code
		  driver.findElement(By.xpath("//a[@href='RegisterUser.htm']")).click();
		   	 driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("Megha002");
		   	 driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Megha");
		   	 driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Banakar");
		   	 driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Pass123");
		   	 driver.findElement(By.xpath("//input[@id='pass_confirmation']")).sendKeys("Pass123");
		   	 driver.findElement(By.xpath("//input[@value='Female']")).click();
		   	 driver.findElement(By.xpath("//input[@id='emailAddress']")).sendKeys("Megha@gmail.com");
		   	 driver.findElement(By.xpath("//input[@id='mobileNumber']")).sendKeys("1234567890");
		   	 
		   	 driver.findElement(By.xpath("//img[@title='Ch']")).click();
		   	 
		   	 Select monthDrop=new Select(driver.findElement(By.className("ui-datepicker-month")));
			  monthDrop.selectByVisibleText("May");
			  
			  Select yearDrop=new Select(driver.findElement(By.className("ui-datepicker-year")));
			  yearDrop.selectByVisibleText("1995");
			  
			  driver.findElement(By.linkText("10")).click();
			
		   	 driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys("RRnagar,Bangalore"); 
		   	 
		   	Select secDrop=new Select(driver.findElement(By.xpath("//select[@name='securityQuestion']")));
			  secDrop.selectByVisibleText("What is your Birth Place?");
		   	
		   	 driver.findElement(By.xpath("//input[@id='answer']")).sendKeys("Bangalore");
		   	 driver.findElement(By.xpath("//input[@type='submit']")).click();
		  Assert.assertTrue(true);
		  
	  }
	  @Test(priority=2)
	  public void testLogin()
	  {
		  logger=extent.createTest("testLogin","Registered Customer logins with the credentials"); 
		  //code
		 
		  driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
		  driver.findElement(By.id("userName")).sendKeys("Lalitha");
		  driver.findElement(By.id("password")).sendKeys("Password123");
		  driver.findElement(By.name("Login")).click();
		  
		  System.out.println(driver.getTitle());
		  Assert.assertEquals(driver.getTitle(), "Home");
		  
		  Assert.assertTrue(true);
	  }
	  @Test(priority=3)
	  public void testAddToCart()
	  {
		  logger=extent.createTest("testAddToCart","Customer adds the items to cart");
		  //code
		  WebElement search=driver.findElement(By.id("myInput"));
		  Actions act=new Actions(driver);
		  act.keyDown(search, Keys.SHIFT).perform();
		  act.sendKeys("h").pause(3000).sendKeys("e").pause(3000).sendKeys("a").pause(3000).sendKeys("d").perform();
		  act.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Headphone')]"))).click().perform();
		  
		  driver.findElement(By.xpath("//input[@value='FIND DETAILS']")).click();
		  driver.findElement(By.xpath("//a[@class='btn btn-success btn-product']")).click();
		  driver.findElement(By.xpath("//a[@href='displayCart.htm']")).click();
		  driver.findElement(By.xpath("//a[@href='checkout.htm']")).click();  
		  driver.findElement(By.xpath("//input[@value='Proceed to Pay']")).click(); 
		  
		  Assert.assertTrue(true);
	  }
	  @Test(priority=4)
	  public void testPayment()
	  {
		  logger=extent.createTest("testPayment","Customer pays for the items in cart");
		  //code
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  
		  driver.findElement(By.xpath("//label[contains(text(),'Andhra Bank')]")).click(); 
		  driver.findElement(By.xpath("//a[@id='btn']")).click(); 
		  driver.findElement(By.xpath("//input[@name='username']")).sendKeys("123456");  
		  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Pass@456"); 
		  driver.findElement(By.xpath("//input[@value='LOGIN']")).click(); 
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.findElement(By.xpath("//input[@name='transpwd']")).sendKeys("Trans@456");
		  driver.findElement(By.xpath("//input[@value='PayNow']")).click(); 
		  driver.findElement(By.xpath("//a[@href='logout.htm']")).click();
		  Assert.assertTrue(true);
		  //throw new SkipException("This functionality is yet to be coded,hence skipped");
	  }
	  @AfterMethod
	  public void getResult(ITestResult result) throws IOException {
		  if(result.getStatus()==ITestResult.SUCCESS) {
			  logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+"Test Passed", ExtentColor.GREEN));
		  }
		  else if(result.getStatus()==ITestResult.FAILURE){
			  logger.log(Status.FAIL, MarkupHelper.createLabel("Test Failed", ExtentColor.RED));
			  
			  TakesScreenshot capture=(TakesScreenshot)driver;
			  File source=capture.getScreenshotAs(OutputType.FILE);
			  String imgpath=System.getProperty("user.dir"+"/extent-reports/snapshots/"+result.getName()+".png");
			 
			  FileUtils.copyFile(source,new File(imgpath));
			  logger.addScreenCaptureFromPath(imgpath,result.getName());
		  }
		  else if(result.getStatus()==ITestResult.SKIP){
			  logger.log(Status.SKIP, MarkupHelper.createLabel("Test Skipped", ExtentColor.PINK));
		  }
		  
	  }
	  @AfterTest
	  public void endReport() {
		  extent.flush(); //commits the generated report 
	  }
  }

