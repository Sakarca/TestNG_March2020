package com.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hubspot.base.BasePage;
import com.hubspot.util.Constants;
import com.hubspot.util.ElementUtil;

public class ContactsPage extends BasePage{
	WebDriver driver;
	ElementUtil elementUtil;
	
//	By createContact = By.xpath("//span[text()='Create contact']");
//	By email= By.id("UIFormControl-10");
//	By firstName= By.id("UIFormControl-12");
//	By lastName= By.id("UIFormControl-16");
//	By jobTitle= By.id("UIFormControl-24");
	
	By createContactButton = By.xpath("//span[contains(text(), 'Create contact')]");
	By email = By.xpath("//input[@name='textInput']");
	By firstName = By.xpath("//input[@class='form-control private-form__control' and @data-field='firstname']");
	By lastName = By.xpath("//input[@class='form-control private-form__control' and @data-field='lastname']");
	By jobTitle = By.xpath("//input[@class='form-control private-form__control' and @data-field='jobtitle']");
	By createContactFormBtn = By.xpath("//div[@class='private-layer']//li[1]");
	
	public ContactsPage(WebDriver driver){
		this.driver=driver;
		elementUtil= new ElementUtil(driver);
	}
	public String getContactsPageTitle(){
		return elementUtil.waitForGetPageTitle(Constants.CONTACTS_PAGE_TITLE);
	}
public void createNewContact(String emailID, String FN, String LN, String jobTitleVal) throws InterruptedException{
		elementUtil.doClick(createContactButton);
		Thread.sleep(2000);
		elementUtil.doSendKeys(email, emailID);
		Thread.sleep(2000);
		elementUtil.doSendKeys(firstName, FN);
		Thread.sleep(2000);
		elementUtil.doSendKeys(lastName, LN);
		Thread.sleep(2000);
		elementUtil.doSendKeys(jobTitle, jobTitleVal);
		Thread.sleep(2000);
		elementUtil.doClick(createContactFormBtn);
		Thread.sleep(2000);
	}
	
}

