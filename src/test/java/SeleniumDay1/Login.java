package SeleniumDay1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login {
	WebDriver driver;
	  @BeforeTest
	  public void configureBrowser() {
		  driver=Driver.configureDriver("explorer");
		  driver.manage().window().maximize();
	  }
	  @Test(dataProvider="login" )
	  public void openApplication(String uname,String pwd) {
		  driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
		  driver.findElement(By.id("userName")).sendKeys(uname);
		  driver.findElement(By.id("password")).sendKeys(pwd);
		  driver.findElement(By.name("Login")).click();
		  
		  driver.findElement(By.linkText("SignOut")).click();
		
	  }
	  @DataProvider
	  public Object[][] login() throws IOException{
		  return Demo.readData();
	  }
	  
	  @AfterTest
	  public void closeApp()
	  {
		  driver.close();
	  }
}
