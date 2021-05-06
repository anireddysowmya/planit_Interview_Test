package POM;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Planit.main.base;

public class contactPage {
	public WebDriver driver;
	
	
	By submitbtn= By.xpath("//a[contains(text(),'Submit')]");
	public By forenameerr= By.id("forename-err");
	By emailerr= By.id("email-err");
	By msgerr= By.id("message-err");
	By forenametxt= By.id("forename");
	By emailtxt= By.id("email");
	By msgtxt= By.id("message");
	By submissionmsg= By.xpath("//div[@class='alert alert-success']");

public contactPage(WebDriver driver) {
		
		this.driver= driver;
		
		
	}

public void submission() {
	WebDriverWait wait= new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(submissionmsg));
	String message= driver.findElement(submissionmsg).getText();
	if(message.contentEquals("Thanks Sowmya, we appreciate your feedback.")) {
		System.out.println("Message validated");
	}
	else {
		System.out.println("Message not validated");
	}
}
public WebElement forename() {
	WebElement name= driver.findElement(forenametxt);
	name.sendKeys("Sowmya");
	return name;
}

public WebElement email() {
	WebElement mail= driver.findElement(emailtxt);
	mail.sendKeys("anireddy.sowmya@gmail.com");
	return mail;
}

public WebElement message() {
	WebElement msg= driver.findElement(msgtxt);
	msg.sendKeys("Test Message");
	return msg;
}



public void validatemsgerr() {
	
	contactPage page= new contactPage(driver);
	page.message();
	try {
		
		
		driver.findElement(msgerr).isDisplayed();
	}
		
		catch (NoSuchElementException  e) {
			System.out.println("Error is not present");
		}
		
	
	
	
}


public void validateemailerr() {
	
	contactPage page= new contactPage(driver);
	page.email();
	try {
		
		
		driver.findElement(emailerr).isDisplayed();
	}
		
		catch (NoSuchElementException  e) {
			System.out.println("Error is not present");
		}
		
	
	
	
}
public void validateforenameerr() {
	//WebDriverWait wait= new WebDriverWait(driver, 30);
	contactPage page= new contactPage(driver);
	page.forename();
	try {
		
		
		driver.findElement(forenameerr).isDisplayed();
	}
		
		catch (NoSuchElementException  e) {
			System.out.println("Error is not present");
		}
		
	
	
}

public WebElement submitbtn() {
	
	WebElement button= driver.findElement(submitbtn);
	button.click();
	return button;
}


public WebElement forenameerr() {
	
	WebElement forename= driver.findElement(forenameerr);
	if(	forename.isDisplayed()) {
		
		System.out.println("Forename is not entered");
	}
	else {
		System.out.println("Forename is entered");
	}

return forename;
}

public WebElement emailerr() {
	
	WebElement email= driver.findElement(emailerr);
	if(	email.isDisplayed()) {
		
		System.out.println("Email is not entered");
	}
	else {
		System.out.println("Email is entered");
	}

return email;
}


public WebElement msgerr() {
	
	WebElement msg= driver.findElement(msgerr);
	if(	msg.isDisplayed()) {
		
		System.out.println("Message is not entered");
	}
	else {
		System.out.println("Message is entered");
	}

return msg;
}






}
