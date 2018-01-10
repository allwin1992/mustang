package Qtech.Expedia;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class ExpediaSearch {
	WebDriver driver;
	
  @Test
  public void f() {
	 // Exputilities exp = new Exputilities();
	  Exputilities.selectjourneytype(driver, "one way");
	  Exputilities.Selectfromdestination(driver, "Delhi");
	  Exputilities.Selecttodestination(driver, "Mumbai");
	  Exputilities.seletdate(driver, "15");
	 // Exputilities.economytype(driver);
	  Exputilities.searchbtn(driver);
	String flightcount =  Exputilities.getflightreceivednum(driver);
	System.out.println(flightcount);
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "E://1//ChromeDriver//chromedriverwin32//chromedriver.exe");
		driver = new ChromeDriver();
		String baseUrl = "https://www.makemytrip.com/";
		driver.get(baseUrl);
		driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(3000);
	 driver.quit();
  }

}
