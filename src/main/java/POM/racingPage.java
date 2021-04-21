package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class racingPage {
	public WebDriver driver;
	public List<WebElement> eventList;
	
	
	public By racingPage= By.xpath("//div[@id='container']");
	public By nextToGoEventList= By.xpath("//div[@data-test-id='ntg-event-list']//a");
	public By ntggrid= By.xpath("//div[@class='sc-drlKqa lowpKz']");
	public By priceBtn= By.xpath("//button[@data-test-id='ntg-sequence-event-item-content']//*[@variant='pricef']");
	public By winPriceGrid= By.xpath("//div[@class='sc-fPbjcq gzsqMd']");
	public By sortedPrices= By.xpath("//button[@data-test-id='event-card-sortby-Price']");
	public By priceList=  By.xpath("//button[contains(@data-test-id,'FixedWin')]");
	public By betSlipPopup= By.id("betslip");
	public By eventName= By.xpath("//div[@data-test-id='bet-card-race-title']");
	public By betSlipPrice= By.xpath("//*[@class='sc-btzYZH dHHnzr']");
	public By eventIconBetSlip= By.xpath("//div[@class='sc-hMqMXs cPxEnv']");
	public By runnerBetSlip= By.xpath("//div[@data-test-id='bet-history-runner']");
	public By marketBetSlip= By.xpath("//*[@class='sc-elJkPf cRIJkB']");
	public WebElement grid;
	public List<WebElement> priceButton;
	public WebElement winPriceventGrid;
	public List<WebElement> sortedPriceButton;
	public List<WebElement> fixedPriceList;
	public WebElement betSlip;
	public WebElement eventname;
	
	
   public racingPage(WebDriver driver) {
	
	this.driver= driver;
	
	
}
   
   public WebElement marketBetSlipPopup() {
	   
	   WebElement market= betSlip.findElement(marketBetSlip);
		if(market.isDisplayed()) {
			System.out.println("market is populated");
		}
		
		else {
			System.out.println("market is not populated");
		}
		return market;
   }
   
   public WebElement runnerBetSlipPopup() {
	   
	   WebElement runner= betSlip.findElement(runnerBetSlip);
		if(runner.isDisplayed()) {
			System.out.println("runner is populated");
		}
		
		else {
			System.out.println("runner is not populated");
		}
		
		return runner;
   }
   
   public WebElement betSlipEventIcon() {
	   
	   WebElement eventicon= betSlip.findElement(eventIconBetSlip);
		if(eventicon.isDisplayed()) {
			System.out.println("eventicon is populated");
		}
		
		else {
			System.out.println("eventicon is not populated");
		}
		return eventicon;
   }
   
   
   public WebElement betSlipPricePopup() {
	   
	   WebElement price= betSlip.findElement(betSlipPrice);
		if(price.isDisplayed()) {
			System.out.println("price is populated");
		}
		
		else {
			System.out.println("price is not populated");
		}
		
		return price;
   }

   public WebElement eventName() {
	    eventname= betSlip.findElement(eventName);
		if(eventname.isDisplayed()) {
			System.out.println("eventName is populated");
		}
		
		else {
			System.out.println("eventName is not populated");
		}
		return eventname;
	   
   }
   
   public WebElement betSlipPopup() {
		
		  betSlip= driver.findElement(betSlipPopup);
		  if(betSlip.isDisplayed()) {
				System.out.println("Betslip is populated");
			}
			
			else {
				System.out.println("Betslip is not populated");
			}

		  return betSlip;
	}
   
   
   
   
   
   
   
   
   
   
   
   public WebElement pageLoad() {
	   
	   WebDriverWait wait= new WebDriverWait(driver,30);
		WebElement ele=  wait.until(ExpectedConditions.visibilityOfElementLocated(racingPage));
		System.out.println("Page loaded successfully");
		return  ele;
   }
  
   
   
   
   public List<WebElement> getFixedPriceList() {
	   
	   fixedPriceList= driver.findElements(priceList);
	   return fixedPriceList;
   }
   
   
     public List<WebElement> winFixedPrice() {
		
	   WebDriverWait wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(sortedPrices));
		sortedPriceButton= winPriceventGrid.findElements(sortedPrices);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 250)");
		sortedPriceButton.get(1).click();
		return sortedPriceButton;

	}

   public WebElement winPriceGrid() {
		
	   winPriceventGrid=  driver.findElement(winPriceGrid);
	   return winPriceventGrid;

	}
   
   
   public WebElement racingPge() {
	
	 return driver.findElement(racingPage);

}

public WebElement pricegrid() {
	
	grid= driver.findElement(ntggrid);
	return grid;

}

public List<WebElement> priceButton() {
	
priceButton=  grid.findElements(priceBtn);
return priceButton;
}

public List<WebElement> nextToGoEventList() {
	eventList= driver.findElements(nextToGoEventList);
	return eventList;
	
}















}
