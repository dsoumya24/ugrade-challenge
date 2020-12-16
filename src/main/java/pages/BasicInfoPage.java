package pages;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class BasicInfoPage extends TestBase{
	
	//locators for elements on Basic Information page
		@FindBy(xpath="//h1[contains(text(),\"Let's get started \")]")
		WebElement header;
		
		@FindBy(name="borrowerFirstName")
		WebElement firstName;
		
		@FindBy(name="borrowerLastName")
		WebElement lastName;
		
		@FindBy(name="borrowerStreet")
		WebElement address;
		
		@FindBy(name="borrowerCity")
		WebElement city;
		
		@FindBy(name="borrowerState")
		WebElement state;
		
		@FindBy(name="borrowerZipCode")
		WebElement zipCode;
		
		@FindBy(name="borrowerDateOfBirth")
		WebElement dob;
		
		@FindBy(xpath="//div[@class=\"sc-csTaMs faZVee\"]/div[1]/div[contains(text(),\"Sorry, the state you’ve selected\")]")
		WebElement invalidState;
		
		@FindBy(xpath="//div[@class=\"sc-csTaMs faZVee\"]/div[1]/div[contains(text(),\"Sorry, the state you’ve selected\")]")
		WebElement invalidZip;
		
		
		@FindBy(xpath="//div[@class=\"sc-csTaMs faZVee\"]/div[1]/div[contains(text(),\"This field is required\")]")
		WebElement requiredField;
	
		@FindBy(xpath="//div[@class=\"sc-csTaMs faZVee\"]/div[1]/div[contains(text(),\"You must be at least 18\")]")
		WebElement dobNot18;
		
		@FindBy(xpath="//div[@class=\"sc-csTaMs faZVee\"]/div[1]/div[contains(text(),\"Please enter a valid date\")]")
		WebElement inValidDOB;
		
		
		@FindBy(css="button.kPkGiO")
		WebElement continueButton;
		
		public BasicInfoPage() {
			//this.driver=driver;
			PageFactory.initElements(driver,this);
		}
		
		//method to validate if BasicInformation page appears
			public void validateIfBasicInfoPageIsLoaded()
			{
				if(header.isDisplayed())
					System.out.println("Basic information Page loaded");
				else
					System.out.println("Basic information ßPage is not loaded");
				
			}
			
		//method to enter firstName
			public void enterFirstName(String borrowerFirstName)
			{
				firstName.sendKeys(borrowerFirstName);
			}
		
		//method to enter lasttName
			public void enterLastName(String borrowerLastName)
			{
				lastName.sendKeys(borrowerLastName);
			}
		//method to enter address
			public void enterStreet(String borrowerStreet)
			{
				address.sendKeys(borrowerStreet);
			}	
		//method to enter city
			public void enterCity(String borrowerCity)
			{
				city.sendKeys(borrowerCity);
			}	
					
		//method to enter state
			public void enterState(String borrowerState)
			{
				state.sendKeys(borrowerState);
			}	
								
		//method to enter zipCode
			public void enterZipCode(String borrowerZipCode)
			{
				zipCode.sendKeys(borrowerZipCode);
			}	
				
		//method to enter DOB
			public void enterDOB(String borrowerDOB)
			{
				dob.sendKeys(borrowerDOB);
			}	
			
		//method to click on ContinueButton
			public void clickContinue()
			{
				continueButton.submit();
			}
	//Validate if any invalid data entered inthe textboxes or data is not entered in the textboxes
			public void validateInputText()
			{
				try
				{
				if(requiredField.isDisplayed() || dobNot18.isDisplayed() 
						|| invalidState.isDisplayed() || invalidZip.isDisplayed()
						|| inValidDOB.isDisplayed())
				{
					System.out.println("Please Corect the input data and submit again");
				}
				}
				catch(NoSuchElementException e)
				{
					System.out.println("All mandatory fields filled");
				}
			}
}
