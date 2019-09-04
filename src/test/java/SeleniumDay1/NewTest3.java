package SeleniumDay1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest3 {
	WebDriver driver;
	  @BeforeTest
	  public void configureBrowser() {
		  /*System.setProperty("webdriver.gecko.driver",
				  "C:\\Users\\training_b6b.01.07\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		  driver= new FirefoxDriver();*/
		  driver=Driver.configureDriver("firefox");
	  }
	  @Test
	  public void openApplication() {
		  driver.get("http://10.232.237.143:443/TestMeApp");
	  }
	 /* @AfterTest
	  public void closeApp()
	  {
		  driver.close();
	  }*/
}
