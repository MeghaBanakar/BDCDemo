package SeleniumDay1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SummerWear {
	WebDriver driver;
	  @BeforeTest
	  public void configureBrowser() {
		  driver=Driver.configureDriver("explorer");
		  driver.manage().window().maximize();
	  }
	  @Test
	  public void openApplication() {
		  driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		  WebElement search=driver.findElement(By.id("myInput"));
		  Actions act=new Actions(driver);
		 
		  act.keyDown(search, Keys.SHIFT).perform();
		  act.sendKeys("w").pause(3000).sendKeys("e").pause(3000).sendKeys("a").pause(3000).sendKeys("r").perform();
		  act.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Summer wear')]"))).click().perform();
		  
		  driver.findElement(By.cssSelector("input[type='submit']")).click();
		  
		  String text=driver.findElement(By.xpath("//h4[contains(text(),'Summer wear')]")).getText();
		  Assert.assertTrue(text.contains("Summer wear"));
		  
	  }
}
