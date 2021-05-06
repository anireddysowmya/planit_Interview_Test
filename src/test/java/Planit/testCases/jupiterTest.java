package Planit.testCases;

import java.io.IOException;
import POM.cartPage;
import POM.contactPage;
import POM.homePage;
import POM.shopPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Planit.main.base;

public class jupiterTest extends base{

public WebDriver driver;

@BeforeTest
	public void driver() throws IOException {
		driver= browserDriver("chrome");
		
		}


@Test(priority=1)
public void test_Case1() {
	//Navigate to Jupiter Toys URL
	driver.get(prop.getProperty("url"));
	//Navigate to Contact page
	homePage page= new homePage(driver);
	page.contactPage();
contactPage contact= new contactPage(driver);
//click submit
contact.submitbtn();
//Validate errors
contact.forenameerr();
contact.emailerr();
contact.msgerr();
//Enter mandatory fields and validate the errors are gone

contact.validateforenameerr();
contact.validateemailerr();
contact.validatemsgerr();
page.home();
}

@Test(priority = 2)
public void test_Case2() {
	homePage page= new homePage(driver);
	contactPage contact= new contactPage(driver);
	
	for(int i=0;i<=4;i++) {
		//Navigate to Contact page
		page.contactPage();
	//Populate mandatory fields
	contact.forename();
	contact.email();
	contact.message();
	//click submit
	contact.submitbtn();
	//Validate successful submission message
	contact.submission();
	page.home();
	}
}
	
	@Test(priority = 3)
	public void test_case3() {
		
	//Navigate to shop page
		homePage page= new homePage(driver);
		page.shop();
		shopPage shop= new shopPage(driver);
		//Click buy button 2 times on Funny Cow
		shop.clickFunnyCow();
	//Click buy button 1 time on Fluffy Bunny
		shop.clickFluffyBunny();
		
		//click Cart menu
		shop.clickCart();
		//Validate items are in cart
		shop.verifyFunnyCowInCart();
		shop.verifyFluffyBunnyInCart();
		driver.navigate().refresh();
		page.shop();
		
	
}




@Test(priority = 4)

public void test_case4() {
	
	homePage page= new homePage(driver);
	page.shop();
	shopPage shop= new shopPage(driver);
	//Buy 2 Stuffed Frog, 5 Fluffy Bunny, 3 Valentine Bear

	shop.clickStuffedFrog();
	shop.clickValentineBear();
	shop.clickFluffyBunnyFive();
	
//Click cart
	shop.clickCart();
//Verify price
	cartPage cart= new cartPage(driver);
	cart.VerifyPriceForFirstrowProduct();
	cart.VerifyPriceForsecondrowProduct();
	cart.VerifyPriceForthirdrowProduct();
	
	//Assert that each product’s sub total
	
  cart.VerifyFirstProductSubtotal();
  cart.VerifySecondProductSubtotal();
  cart.VerifyThirdProductSubtotal();

//Assert total is equal to sum(sub totals)

   cart.total();

	


}
@AfterTest()
public void teardown(){
	
	driver.close();
}















}
