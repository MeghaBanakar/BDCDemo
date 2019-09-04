package SeleniumDay1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest1 {
	
	WebDriver driver;
  @BeforeTest
  public void configureBrowser() {
	 // System.setProperty("webdriver.ie.driver",
			 // "C:\\Users\\training_b6b.01.07\\Downloads\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
	 // driver= new InternetExplorerDriver();
	  driver=Driver.configureDriver("explorer");
  }
  @Test
  public void openApplication() {
	  driver.get("http://10.232.237.143:443/TestMeApp");
  }
  /*@AfterTest
  public void closeApp()
  {
	  driver.close();
  }*/
  
}
