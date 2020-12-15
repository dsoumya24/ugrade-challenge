package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class OfferPageDebtPayOffers extends TestBase{

	
	//locators for elements on Create account page

			@FindBy(css="span.iSPPGk")
			WebElement loanAmount;
		

			@FindBy(xpath="//div[@class=\"sc-fWWZrV kWTrQQ\"]/span")
			WebElement monthlyPayment;

			@FindBy(xpath="//div[@class=\"sc-hkePoP bROatD\"]/div/div[1]")
			WebElement term;

			@FindBy(xpath="//div[@class=\"sc-hkePoP bROatD\"]/div/div[2]")
			WebElement interestRate;

			
			@FindBy(xpath="//div[@class=\"sc-gzcbGf hjFDUQ\"]/div")
			WebElement apr;
			
			@FindBy(xpath="//header[@class=\"header header--collapsed\"]/div/label")
			WebElement menu;
			
			@FindBy(linkText="Sign Out")
			WebElement signOut;
			
			@FindBy(xpath="//h2[contains(text(),\"You qualify for a discount\")]")
			WebElement offersPageHeader;

			
			public void validateIfOffersPageLoaded()
			{
				new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(offersPageHeader));
			}
			public OfferPageDebtPayOffers() {
				
				PageFactory.initElements(driver,this);
			}
			
			//method to fetch loanAmount
			public String fetchLoanAmount()
			{
				String loanAmountValue=loanAmount.getText();
				return loanAmountValue;
			}
			
			//method to fetch loanAmount
			public String fetchMonthlyPayment()
			{
				String monthlyPaymentValue=monthlyPayment.getText();
				return monthlyPaymentValue;
			}
			//method to fetch InterestRate
			public String fetchInterestRate()
			{
				String interestRateValue=interestRate.getText().split(" ")[0];
				return interestRateValue;
			}
			//method to fetch term
			public String fetchTerm()
			{
				String termValue=term.getText().split(" ")[0];
				return termValue;
			}
			//method to fetch apr
			public String fetchApr()
			{
				String aprValue=apr.getText().split(" ")[0];
				return aprValue;
			}
			//mothd to signOut
			public void signout()
			{
				
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("arguments[0].click()", menu);
				jse.executeScript("arguments[0].click()", signOut);
				
			}
			
	
}
