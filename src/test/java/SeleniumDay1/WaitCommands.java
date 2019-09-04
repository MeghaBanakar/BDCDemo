package SeleniumDay1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WaitCommands {
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
		  //implict wait
		  //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  //explicit wait
		  WebDriverWait wait=new  WebDriverWait(driver,20);
		  
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='userName']")));
		  driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("Admin");
		  
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='password']")));
		  driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password456");
		  
		  driver.findElement(By.xpath("//input[@type='submit']")).click();
}
	  @AfterTest
	  public void closeApp()
	  {
		  driver.close();
	  }
}
