package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class shopPage {
	public WebDriver driver;

public shopPage(WebDriver driver) {
		
		this.driver= driver;
		
		
	}

By cart= By.xpath("//li[@id='nav-cart']");
By verifyFunnyCowInCart=By.xpath("//tbody/tr[1]/td[1]");
By verifyFluffyBunnyInCart= By.xpath("//tbody/tr[2]/td[1]");
By shopProductslist= By.xpath("//div[@class='products ng-scope']//li//div//h4");
public By buyProduct= By.xpath("//div[@class='products ng-scope']//li//div//p//a");
public List<WebElement> productlist;
public  List<WebElement> buy;


public List<WebElement> shopProducts() {
	productlist= driver.findElements(shopProductslist);
	return productlist;



}


public List<WebElement> buyProduct() {
	buy= driver.findElements(buyProduct);
	return buy;



}

public void clickFluffyBunny() {
	shopPage shop= new shopPage(driver);
	for(int i=0;i<shop.shopProducts().size();i++) {
		if(shop.shopProducts().get(i).getText().equalsIgnoreCase("Fluffy Bunny")){
			
			shop.buyProduct().get(i).click();
			break;
		}
	}
}
public void clickStuffedFrog() {
	shopPage shop= new shopPage(driver);
	for(int frog=0;frog<shop.shopProducts().size();frog++) {
		if(shop.shopProducts().get(frog).getText().equalsIgnoreCase("Stuffed Frog")){
			for(int count1=frog;count1<=2;count1++) {
			shop.buyProduct().get(frog).click();
			
			}
			break;
		}
	}
}

public WebElement verifyFunnyCowInCart() {
	WebElement verify= driver.findElement(verifyFunnyCowInCart);
	String text= verify.getText();

	if(text.contains("Funny Cow")) {
		System.out.println("Funny cow is in cart");
	}
	else {
		System.out.println("Funny cow is not in cart");
	}
	return verify;
}

public WebElement verifyFluffyBunnyInCart() {
	WebElement verify= driver.findElement(verifyFluffyBunnyInCart);
	String text= verify.getText();
	if(text.contains("Fluffy Bunny")) {
		System.out.println(" Fluffy Bunny is in cart");
	}
	else {
		System.out.println(" Fluffy Bunny is not in cart");
	}
	return verify;
}




public WebElement clickCart() {
	
	WebElement element= driver.findElement(cart);
	element.click();
	return element;
}
public void clickValentineBear() {
	shopPage shop= new shopPage(driver);
	for(int bear=0;bear<shop.shopProducts().size();bear++) {
		if(shop.shopProducts().get(bear).getText().equalsIgnoreCase("Valentine Bear")){
			for(int count2=bear;count2<=8;count2++) {
			shop.buyProduct().get(bear).click();
			
			}
			break;
		}
	}
}

public void clickFluffyBunnyFive() {
	shopPage shop= new shopPage(driver);
	for(int Bunny=0;Bunny<shop.shopProducts().size();Bunny++) {
		if(shop.shopProducts().get(Bunny).getText().equalsIgnoreCase("Fluffy Bunny")){
			for(int count3=Bunny;count3<=7;count3++) {
			shop.buyProduct().get(Bunny).click();
			
			}
			break;
		}
	}
}
public void clickFunnyCow() {
	shopPage shop= new shopPage(driver);
	for(int i=0;i<shop.shopProducts().size();i++) {
		if(shop.shopProducts().get(i).getText().equalsIgnoreCase("Funny Cow")){
			shop.buyProduct().get(i).click();
			shop.buyProduct().get(i).click();
			break;
		}
	}
}


























}
