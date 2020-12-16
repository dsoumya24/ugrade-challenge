package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class CredifyHomePage  extends TestBase{
	
	//locators for elements on credifyPage
			@FindBy(xpath="//input[@name=\"desiredAmount\"]")
			WebElement loanAmount;
			
			@FindBy(css="select.hqVcSC")
			WebElement loanPurpose;
			
			@FindBy(css="button.gtkhEk")
			WebElement checkRate;
			
			@FindBy(xpath="//div[contains(text(),\"This field is required\")]")
			WebElement requiredElement;
			
			public String url="https://www.credify.tech/phone/nonDMFunnel";	
	public CredifyHomePage() {
		PageFactory.initElements(driver, this);
	}

	
		
		//method to navigate to the CredifyPAge
		public void navigateToURL()
		{
			driver.get(url);
		}
		//method to enter loanAmount
		public void enterLoanAmount(String amount) throws Exception
		{
			try {
				
			
			loanAmount.sendKeys(amount);
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		//method to select loanPurpose
		public void selectLoanPurpose(String purposeValue)
		{
			Select purpose= new Select(loanPurpose);
			purpose.selectByVisibleText(purposeValue);
			
		}
		
		//method to click on Check Your Rate
		public void clickOnCheckRate()
		{
			checkRate.submit();
		}
		
		public void validateIfRequiredDataEntered()
		{
			try 
			{
				if(requiredElement.isDisplayed())
				{
					System.out.println("Enter data in all the mandatory required fields ");
				}
			}
			catch(NoSuchElementException e)
			{
				
			}
		}
		
}
