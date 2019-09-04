package SeleniumDay1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest4 {
	WebDriver driver;
	  @BeforeTest
	  public void configureBrowser() {
		  /*System.setProperty("webdriver.gecko.driver",
				  "C:\\Users\\training_b6b.01.07\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		  driver= new FirefoxDriver();*/
		  driver=Driver.configureDriver("explorer");
		  driver.manage().window().maximize();
	  }
	  @Test
	  public void openApplication() {
		  driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
		  driver.findElement(By.id("userName")).sendKeys("Lalitha");
		  driver.findElement(By.id("password")).sendKeys("Password123");
		  driver.findElement(By.name("Login")).click();
		  
		  System.out.println(driver.getTitle());
		  Assert.assertEquals(driver.getTitle(), "Home");
		  driver.findElement(By.linkText("SignOut")).click();
		
	  }
	  @AfterTest
	  public void closeApp()
	  {
		  driver.close();
	  }
}
