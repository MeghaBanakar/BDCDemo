package SeleniumDay1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Cart {
	WebDriver driver;
	  @BeforeTest
	  public void configureBrowser() {
		  driver=Driver.configureDriver("chrome");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  }
	  @Test
	  public void openApplication() {
		  driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
		  driver.findElement(By.id("userName")).sendKeys("Lalitha");
		  driver.findElement(By.id("password")).sendKeys("Password123");
		  driver.findElement(By.name("Login")).click();
		 
		  WebElement search=driver.findElement(By.id("myInput"));
		  Actions act=new Actions(driver);
		  act.keyDown(search, Keys.SHIFT).perform();
		  act.sendKeys("h").pause(3000).sendKeys("e").pause(3000).sendKeys("a").pause(3000).sendKeys("d").perform();
		  act.keyUp(Keys.SHIFT).perform();
		  act.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Headphone')]"))).click().perform();
		  
		  driver.findElement(By.xpath("//input[@value='FIND DETAILS']")).click();
		  driver.findElement(By.xpath("//a[@class='btn btn-success btn-product']")).click();
		  driver.findElement(By.xpath("//a[@href='displayCart.htm']")).click();
		  driver.findElement(By.xpath("//a[@href='checkout.htm']")).click();  
		  driver.findElement(By.xpath("//input[@value='Proceed to Pay']")).click(); 
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  
		  driver.findElement(By.xpath("//label[contains(text(),'Andhra Bank')]")).click(); 
		  driver.findElement(By.xpath("//a[@id='btn']")).click(); 
		  
		  driver.findElement(By.xpath("//input[@name='username']")).sendKeys("123456");  
		  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Pass@456"); 
		  driver.findElement(By.xpath("//input[@value='LOGIN']")).click(); 
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.findElement(By.xpath("//input[@name='transpwd']")).sendKeys("Trans@456");
		  driver.findElement(By.xpath("//input[@value='PayNow']")).click(); 
		  driver.findElement(By.xpath("//a[@href='logout.htm']")).click();

	  }
	  @AfterTest
	  public void closeApp()
	  {
		  driver.close();
	  }
}
