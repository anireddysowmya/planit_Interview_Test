package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homePage {
	public WebDriver driver;
	
	public By contactPage= By.linkText("Contact");
	public By homepg= By.linkText("Home");
	public By shoppge= By.linkText("Shop");
	
	
	

	public homePage(WebDriver driver) {
		
		this.driver= driver;
		
		
	}

public WebElement contactPage() {
	
	WebElement contact= driver.findElement(contactPage);
	contact.click();
	return contact;
}
	
public WebElement home() {
	
	WebElement home= driver.findElement(homepg);
	home.click();
	return home;
}

public WebElement shop() {
	
	WebElement page= driver.findElement(shoppge);
	page.click();
	return page;
}




}
