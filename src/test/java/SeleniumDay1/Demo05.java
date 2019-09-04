package SeleniumDay1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo05 {
	WebDriver driver;
	  @BeforeTest
	  public void configureBrowser() {
		  driver=Driver.configureDriver("chrome");
		  driver.manage().window().maximize();
	  }
	  @Test
	  public void openApplication() {
		  driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		  driver.navigate().to("http://10.232.237.143:443/TestMeApp/login.htm");
		  
		  driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("Admin");
		  driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password456");
		  driver.findElement(By.xpath("//input[@type='submit']")).click();
		  driver.findElement(By.xpath("//div[@class='btn-group'][4]")).click();
		  
		  Select catDrop=new Select(driver.findElement(By.id("categorydropid")));
		  catDrop.selectByVisibleText("Electronics");
		  
		  Select subCat=new Select(driver.findElement(By.id("subcategorydropid")));
		  subCat.selectByVisibleText("Travel Kit");
		  
		  /*or it can be done in this way also
		  
		  WebElement subCat=driver.findElement(By.id("subcategorydropid"));
		  Select subCatDrop=new Select(subCat);
		  subCatDrop.selectByIndex(2);
		 */
		  
		  driver.findElement(By.xpath("//input[@type='submit']")).click();
	  }
	  @AfterTest
	  public void closeApp()
	  {
		  driver.close();
	  }
}
