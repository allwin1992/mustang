package Qtech.Expedia;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Exputilities {
	
	public static void Selectfromdestination(WebDriver driver, String destinationfromname){
		String expectedname = "Top Cities : New Delhi, India ";
		WebElement destinationfield = driver.findElement(By.id("hp-widget__sfrom"));
		destinationfield.clear();
		destinationfield.sendKeys(destinationfromname);
		
		WebElement results = driver.findElement(By.id("ui-id-1"));
		List<WebElement> elements = results.findElements(By.tagName("li"));
		//int size = elements.size();
		
		for (WebElement element : elements){
			if(element.getText().equals(expectedname)){
				element.click();
			}
		}
	}
		public static void Selecttodestination(WebDriver driver, String destinationtoname){
			String expectedname = "Top Cities : Mumbai, India";
			WebElement destinationfield = driver.findElement(By.id("hp-widget__sTo"));
			destinationfield.clear();
			destinationfield.sendKeys(destinationtoname);
			
			WebElement results = driver.findElement(By.id("ui-id-2"));
			List<WebElement> elements = results.findElements(By.tagName("li"));
			
			for (WebElement element : elements){
				if(element.getText().equals(expectedname)){
					element.click();
				}
			}
		
	}
		public static void selectjourneytype(WebDriver driver, String journeytype){
			WebElement journeytypebutton = driver.findElement(By.xpath
					("//div[@id='js-switch__option']//label[contains(text(),'"+journeytype+"')]"));
			journeytypebutton.click();
		}
		public static void seletdate(WebDriver driver, String ToDate){
			driver.findElement(By.id("hp-widget__depart")).click();
			WebElement calender = driver.findElement(By.className("ui-datepicker-calendar"));
			List<WebElement> dates = calender.findElements(By.tagName("a"));
			
			for(WebElement date : dates){
				if(date.getText().equals(ToDate)){
					date.click();
					break;
				}
			}
		}
		public static void searchbtn(WebDriver driver){
			try {
				WebElement searchButton = driver.findElement(By.id("searchBtn"));
				searchButton.click();
			}
			catch(org.openqa.selenium.StaleElementReferenceException ex)
			{
				WebElement searchButton = driver.findElement(By.id("searchBtn"));
				searchButton.click();
			}
		}
		public static void economytype(WebDriver driver){
			WebElement ecotypebtn = driver.findElement(By.id("hp-widget__class"));
			ecotypebtn.click();
			WebElement ecotypeoptn = driver.findElement(By.id("classBTN__input_3"));
			ecotypeoptn.click();
		}
		public static String getflightreceivednum(WebDriver driver){
			WebDriverWait wait = new WebDriverWait(driver, 30);
			WebElement flightnum = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
					("//div[@id='content']//span[contains(@class,'light_gray') and contains(text(),'flights')]")));
		String numberofflight = flightnum.getText();
		return numberofflight;
		}
}
