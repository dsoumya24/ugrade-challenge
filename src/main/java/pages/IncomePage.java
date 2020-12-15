package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class IncomePage  extends TestBase{
	

	//locators for elements on Income page
	@FindBy(css="h1.hciJwR")
	WebElement incomeHeader;
	
	@FindBy(name="borrowerIncome")
	WebElement annualIncome;
	

	@FindBy(name="borrowerAdditionalIncome")
	WebElement aadditionalIncome;

	@FindBy(css="button.kPkGiO")
	WebElement incomeContinue;
	
	@FindBy(xpath="//div[@class=\"sc-csTaMs faZVee\"]/div[1]/div[contains(text(),\"This field is required\")]")
	WebElement requiredField;
	
	
	
	public IncomePage() {
		
		PageFactory.initElements(driver,this);
	}
	//method to validate if Income page appears
	public void validateIfIncomeInfoPageIsLoaded()
	{
		if(incomeHeader.isDisplayed())
			System.out.println("Income Page loaded");
		else
			System.out.println("Income Page is not loaded");
				
	}
	
	//method to enter annual income
	public void enterAnnualIncome(String annualIncomeValue)
	{
		annualIncome.sendKeys(annualIncomeValue);
	}
	
	//method to enter additional income
	public void enterAdditionalIncome(String additionalIncomeValue)
	{
		aadditionalIncome.sendKeys(additionalIncomeValue);
	}
	
	//method to click continue
	public void clickContinueOnIncomePage()
	{
		incomeContinue.submit();
	}

	public void validateIfDataEntered()
	{
		if(requiredField.isDisplayed())
		{
			System.out.println("Enter data in income screen");
		}
	}
	
}
