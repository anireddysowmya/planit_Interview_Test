package KindredGroup.Unibet;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.Iterables;

import POM.racingPage;

public class betPlacementScenario extends base{

	public WebDriver driver;
	
	
	
	@BeforeTest
	public void driver() throws IOException {
		driver= browserDriver("chrome");
		}
	
 @Test(priority = 0)
public void navigation() {
	 //Navigate to Unibet Url
	 racingPage Page= new racingPage(driver);
	driver.get(prop.getProperty("url"));
//Verify pageload	
	Page.pageLoad();
	}
	
 @Test(priority = 1)
 //Click on the last event in the Next to go
 public void nextToGo() {
	 racingPage Page= new racingPage(driver);
 Page.pricegrid();
 Page.priceButton();

	for (int i = Page.priceButton.size() - 1 ; i >= 0 ; i--) {
		
	try {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
	
		jse.executeScript("scroll(0, 250)"); 
      if(Page.priceButton.get(i).isDisplayed())
       {
    	  Page.priceButton.get(i).click();
		break;
		}
	} 
	catch (Exception e) {
		// TODO: handle exception
	}

	}
 }
		
	@Test(priority=2)
	//Navigate to the event and click on lowest FIXED price
	public void clickOnLowPrice() {
		
	 racingPage Page= new racingPage(driver);
		Page.winPriceGrid();
		Page.winFixedPrice();
		Page.getFixedPriceList();
		List<String> prices = new ArrayList<String>();
		
		for (WebElement e : Page.fixedPriceList)
		{
		    prices.add(e.getText());
		 
		  
		}
		
		List<String> sortedPrices = new ArrayList<String>(prices);
		for(int i=0;i<Page.fixedPriceList.size();i++) {
	
			if(prices.get(i).equals(sortedPrices.get(0))) {
				Page.fixedPriceList.get(i).click();
				break;
		
				}


}
		}
	
	 	 
@Test(priority=3)
//Verify the fields are populated to the betslip
public void betSlip() {
	//Verify BetSlip popup opened
	racingPage Page= new racingPage(driver);
	Page.betSlipPopup();
	
	//Validate eventname
	Page.eventName();
    //Validate price
	Page.betSlipPricePopup();
	
//Validate Event type icon
	Page.betSlipEventIcon();


//Validate runner
	Page.runnerBetSlipPopup();
	
	//Validate market
	Page.marketBetSlipPopup();

}
	@AfterTest
	public void teardown() {
		driver.close();
		
	}
		 

 
}

