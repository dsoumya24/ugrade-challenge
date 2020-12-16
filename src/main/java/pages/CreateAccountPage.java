package pages;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class CreateAccountPage  extends TestBase{
	//locators for elements on Create account page
		@FindBy(name="username")
		WebElement emailAddress;
		
		@FindBy(name="password")
		WebElement password;

		@FindBy(xpath="//label[@class=\"sc-biJoGX dJTLma\"]/div")
		WebElement termsCheckBox;
		
		@FindBy(css="button.kPkGiO")
		WebElement createAccountContinue;
		
		@FindBy(css="span.ejHTIs")
		WebElement validPasswordCheck;
		
		

		public CreateAccountPage() {
			//this.driver=driver;
			PageFactory.initElements(driver,this);
		}
		
		//method to enter email ID
		public void enterEmailAddress(String emailID)
		{
			emailAddress.sendKeys(emailID);
		}
		
		//method to enter password
		public void enterPassword(String passwordValue)
		{
			password.sendKeys(passwordValue);
		}
		
		//method to check the terms checkbox
		public void checkTermsCheckBox()
		{
			WebElement clickableTerms =new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(termsCheckBox));
			if(!clickableTerms.isSelected())
				clickableTerms.click();
		}
		
		//method to click Contiue on Create account page
		
		public void clickContinueOnCreateAccount()
		{
			createAccountContinue.click();
		}
		
		//method to validate if valid password check mark appears after entering password
		public void validateIfValidPassword()
		{
			try
			{
			if(!validPasswordCheck.isDisplayed())
			{
				System.out.println("Please enter a valid password");
			}
			else
			{
				System.out.println("valid password check mark displayed");
			}
			}
			catch(NoSuchElementException e)
			{
				
			}
				
		}
		

}
