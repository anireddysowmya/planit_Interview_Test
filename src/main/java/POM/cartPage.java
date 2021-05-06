package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class cartPage {
	
	
public WebDriver driver;

By stuffedFrogprice= By.xpath("//tbody/tr[1]//td[2]");
By cartTable= By.xpath("//table[@class='table table-striped cart-items']");
By firstrowProductName= By.xpath("//tbody/tr[1]/td[1]");
By firstrowProductprice= By.xpath("//tbody/tr[1]/td[2]");
By secondrowProductName= By.xpath("//tbody/tr[2]/td[1]");
By secondrowProductprice= By.xpath("//tbody/tr[2]/td[2]");
By thirdrowProductName= By.xpath("//tbody/tr[3]/td[1]");
By thirdrowProductprice= By.xpath("//tbody/tr[3]/td[2]");
By firstrowQuantity= By.xpath("//tbody/tr[1]/td[3]/input[1]");
By secondrowQuantity= By.xpath("//tbody/tr[2]//td[3]/input[1]"); 
By thirdrowQuantity= By.xpath("//tbody/tr[3]/td[3]/input[1]"); 
By firstProductSubTotal= By.xpath("//tbody//tr[1]//td[4]");
By secondProductSubTotal= By.xpath("//tbody//tr[2]//td[4]");
By thirdProductSubTotal= By.xpath("//tbody//tr[3]//td[4]");
By totalPrice= By.xpath("//table[@class='table table-striped cart-items']/tfoot/tr[1]/td/strong");


public WebElement table;
public String firstpricenum;
public String secondpricenum;
public String thirdpricenum;
public String firstProductQuantity;
public String secondProductQuantity;
public String thirdProductQuantity;
public String firstSubTotal;
public String secondSubTotal;
public String thirdSubTotal;
public String[] totaltxt;
public double firstProductPrice;
public double secondProductPrice;
public double thirdProductPrice;
public int firstProductQuantitynum;
public int secondProductQuantitynum;
public int thirdProductQuantitynum;
public double firstSubTotalnum;
public double secondSubTotalnum;
public double thirdSubTotalnum;
public String totaltxtnum;
public double totalprice;
public double sumOfSubTotals;;
public double firstProductSubTotalnum;
public double secondProductSubTotalnum;
public double thirdProductSubTotalnum;


public cartPage(WebDriver driver) {
		
		this.driver= driver;
		
		
	}

public WebElement cartTable() {
	
	table= driver.findElement(cartTable);
	return table;
}


public void VerifyPriceForFirstrowProduct() {
	
	WebElement productname= driver.findElement(firstrowProductName);
	String productnametext= productname.getText();
	WebElement price= driver.findElement(firstrowProductprice);
	firstpricenum= price.getText().replace("$", "");
	System.out.println("The price for " + productnametext +  "is"  +  firstpricenum);
	
	
}

public void VerifyPriceForsecondrowProduct() {
	
	WebElement productname= driver.findElement(secondrowProductName);
	String productnametext= productname.getText().replace("$", "");;
	WebElement price= driver.findElement(secondrowProductprice);
	secondpricenum= price.getText().replace("$", "");
	System.out.println("The price for " + productnametext +  "is"  +  secondpricenum);
	
	
}
public void VerifyPriceForthirdrowProduct() {
	
	WebElement productname= driver.findElement(thirdrowProductName);
	String productnametext= productname.getText().replace("$", "");;
	WebElement price= driver.findElement(thirdrowProductprice);
thirdpricenum= price.getText().replace("$", "");
	System.out.println("The price for "  + productnametext +  "is"  +  thirdpricenum);
	
	
}
public void VerifyFirstProductSubtotal() {
	
	WebElement quantity= driver.findElement(firstrowQuantity);
   firstProductQuantity = quantity.getAttribute("value").toString();
	 firstProductQuantitynum= Integer.parseInt(firstProductQuantity);
	 firstProductPrice= Double.parseDouble(firstpricenum);
	 WebElement subtotal1= driver.findElement(firstProductSubTotal);
		firstSubTotal= subtotal1.getText().replace("$", "");;
	 firstSubTotalnum=  Double.parseDouble(firstSubTotal);
	firstProductSubTotalnum= firstProductPrice*firstProductQuantitynum;
	Assert.assertEquals(firstProductSubTotalnum, firstSubTotalnum);
	
	
}

public void VerifySecondProductSubtotal() {
	
	WebElement quantity= driver.findElement(secondrowQuantity);
  secondProductQuantity= quantity.getAttribute("value").toString();
  secondProductQuantitynum= Integer.parseInt(secondProductQuantity);
  secondProductPrice= Double.parseDouble(secondpricenum);
  WebElement subtotal2= driver.findElement(secondProductSubTotal);
	secondSubTotal= subtotal2.getText().replace("$", "");;
	secondSubTotalnum=  Double.parseDouble(secondSubTotal);
   secondProductSubTotalnum =secondProductPrice*secondProductQuantitynum;
   Assert.assertEquals(secondProductSubTotalnum, secondSubTotalnum);
   
  
  
	
	
}
public void VerifyThirdProductSubtotal() {
	
	WebElement quantity= driver.findElement(thirdrowQuantity);
	thirdProductQuantity= quantity.getAttribute("value").toString();
	thirdProductQuantitynum= Integer.parseInt(thirdProductQuantity);
	  thirdProductPrice= Double.parseDouble(thirdpricenum);
	  WebElement subtotal3= driver.findElement(thirdProductSubTotal);
		thirdSubTotal= subtotal3.getText().replace("$", "");;
		thirdSubTotalnum=  Double.parseDouble(thirdSubTotal);
	  thirdProductSubTotalnum =thirdProductPrice*thirdProductQuantitynum;
	   Assert.assertEquals(thirdProductSubTotalnum, thirdSubTotalnum);
	   
}




public void total() {
	WebElement subtotal1= driver.findElement(firstProductSubTotal);
	firstSubTotal= subtotal1.getText().replace("$", "");;
	WebElement subtotal2= driver.findElement(secondProductSubTotal);
	secondSubTotal= subtotal2.getText().replace("$", "");;
	WebElement subtotal3= driver.findElement(thirdProductSubTotal);
	thirdSubTotal= subtotal3.getText().replace("$", "");;
   firstSubTotalnum=  Double.parseDouble(firstSubTotal);
   secondSubTotalnum=  Double.parseDouble(secondSubTotal);
	thirdSubTotalnum=  Double.parseDouble(thirdSubTotal);
	sumOfSubTotals= firstSubTotalnum+secondSubTotalnum+thirdSubTotalnum;
	
	WebElement total= driver.findElement(totalPrice);
	totaltxt= total.getText().split("(?<=\\D)(?=\\d+)(?=\\d+)");
totaltxtnum= totaltxt[1];
String totaltxtnum2= totaltxt[2];
String totalnum= totaltxtnum+totaltxtnum2;
totalprice= Double.parseDouble(totalnum);

Assert.assertEquals(totalprice, sumOfSubTotals);
System.out.println("Total price is equals to sum of subtotals");

}







}
