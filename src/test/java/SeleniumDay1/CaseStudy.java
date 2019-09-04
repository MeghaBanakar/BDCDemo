package SeleniumDay1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CaseStudy {
	 WebDriver driver;
     @BeforeTest
	  public void configureBrowser() {
	  driver=Driver.configureDriver("explorer");
	  driver.manage().window().maximize();
      driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
	  }
     @Test(dataProvider="login")
     public void testRegistration(String uname,String fname,String lname,String pwd,String cpwd,String d,String mail,String num,
      String mon1,String year1,String date1,String add,String sec,String ans)
     {
    	 driver.findElement(By.xpath("//a[@href='RegisterUser.htm']")).click();
     driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(uname);
     driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(fname);
     driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lname);
     driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
     driver.findElement(By.xpath("//input[@id='pass_confirmation']")).sendKeys(cpwd);
     driver.findElement(By.xpath("//label[@class='form-control input-lg']")).sendKeys(d);
     if(d.equals("Female"))
     {
      driver.findElement(By.xpath("//input[@value='Female']")).click();
     }
     else
     {
      driver.findElement(By.xpath("//input[@value='Male']")).click();
     }
     driver.findElement(By.xpath("//input[@id='emailAddress']")).sendKeys(mail);
     driver.findElement(By.xpath("//input[@id='mobileNumber']")).sendKeys(num);
     driver.findElement(By.xpath("//img[@class='ui-datepicker-trigger']")).click();
     Select mon=new Select(driver.findElement(By.className("ui-datepicker-month")));
     mon.selectByVisibleText(mon1);
     Select year=new Select(driver.findElement(By.className("ui-datepicker-year")));
     year.selectByVisibleText(year1);
     driver.findElement(By.linkText(date1)).click();

     driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys(add);
     Select que=new Select(driver.findElement(By.xpath("//select[@id='securityQuestion']")));
     que.selectByVisibleText(sec);
     driver.findElement(By.xpath("//input[@id='answer']")).sendKeys(ans);
     driver.findElement(By.xpath("//input[@type='submit']")).click();
     }
     @DataProvider
	  public Object[][] login() throws IOException{
		  return Demo.readData();
	  }
	  
  
}
