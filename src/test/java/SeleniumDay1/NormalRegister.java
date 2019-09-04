package SeleniumDay1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NormalRegister {
	WebDriver driver;
    @BeforeTest
	  public void configureBrowser() {
	  driver=Driver.configureDriver("explorer");
	  driver.manage().window().maximize();
     driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
	  }
    @Test
    public void testRegistration() {
   	 
   	 driver.findElement(By.xpath("//a[@href='RegisterUser.htm']")).click();
   	 driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("Meghaaa");
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
    }
}
