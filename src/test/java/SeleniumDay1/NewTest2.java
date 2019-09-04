package SeleniumDay1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest2 {
	WebDriver driver;
	  @BeforeTest
	  public void configureBrowser() {
		  /*System.setProperty("webdriver.chrome.driver",
				  "C:\\Users\\training_b6b.01.07\\Downloads\\chromedriver_win32\\chromedriver.exe");
		  driver= new ChromeDriver();*/
		  driver=Driver.configureDriver("chrome");
	  }
	  @Test
	  public void openApplication() {
		  driver.get("http://newtours.demoaut.com/");
	  }
	 /* @AfterTest
	  public void closeApp()
	  {
		  driver.close();
	  }*/
}
