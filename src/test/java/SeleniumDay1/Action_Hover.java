package SeleniumDay1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Action_Hover {
	WebDriver driver;
	  @BeforeTest
	  public void configureBrowser() {
		  driver=Driver.configureDriver("chrome");
		  driver.manage().window().maximize();
	  }
	  @Test
	  public void openApplication() {
		  driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		  
		  //to hover over the about Us then our offices and the to bangalore options
		  Actions act=new Actions(driver);
		  act.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'AboutUs')]"))).
		  moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Our\n" + 
		  		"												Offices')]"))).
		  moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Bangalore')]"))).click().build().perform();
		  
		  
		  
	  }
}
