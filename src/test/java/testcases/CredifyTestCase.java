package testcases;


import java.security.SecureRandom;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.BasicInfoPage;
import pages.CreateAccountPage;
import pages.CredifyHomePage;
import pages.IncomePage;
import pages.LoginPage;
import pages.OfferPageDebtPayOffers;

public class CredifyTestCase extends TestBase{


	public CredifyTestCase() {
		super();
	}

	
	@BeforeMethod
	public void setUp() {
		initialization();
		
	}
	@Test
	public void verifyOfferOnLogin() throws Throwable{
		try
		{
		CredifyHomePage credifyHomePage=new CredifyHomePage();
		credifyHomePage.navigateToURL();
		credifyHomePage.enterLoanAmount("2000");
		credifyHomePage.selectLoanPurpose("CREDIT_CARD");
		credifyHomePage.clickOnCheckRate();
		
		BasicInfoPage basicPage = new BasicInfoPage();
		basicPage.enterFirstName(randomName());
		basicPage.enterLastName(randomName());
		basicPage.enterStreet("2997 Alves Ranch road");
		basicPage.enterCity("Pittsburg");
		basicPage.enterState("CA");
		basicPage.enterZipCode("99999");
		basicPage.enterDOB("09/01/1999");
		basicPage.clickContinue();
		basicPage.validateInputText();
		
		IncomePage incPage = new IncomePage();
		incPage.validateIfIncomeInfoPageIsLoaded();
		incPage.enterAnnualIncome("120050");
		incPage.enterAdditionalIncome("5500");
		incPage.clickContinueOnIncomePage();
		//incPage.validateIfDataEntered();
		
		CreateAccountPage createAccPage=new CreateAccountPage();
		Random rand = new Random(); 
	    int randomNum = rand.nextInt(60); 
	    String emailId="candidate"+randomNum+"@upgrade-challenge.com";
		createAccPage.enterEmailAddress(emailId);
		String password=generateRandomPassword();
		createAccPage.enterPassword(password);
		createAccPage.validateIfValidPassword();
		System.out.println("password "+password);
		createAccPage.checkTermsCheckBox();
		createAccPage.clickContinueOnCreateAccount();
		
		OfferPageDebtPayOffers offersPage = new OfferPageDebtPayOffers();
		offersPage.validateIfOffersPageLoaded();
		Map<String, String> valuesOnOfferRequest = new HashMap<String, String>();
		valuesOnOfferRequest.put("loanAMount", offersPage.fetchLoanAmount());
		valuesOnOfferRequest.put("monthlyPayment",offersPage.fetchMonthlyPayment());
		valuesOnOfferRequest.put("term",offersPage.fetchTerm());
		valuesOnOfferRequest.put("interestRate",offersPage.fetchInterestRate());
		valuesOnOfferRequest.put("apr",offersPage.fetchApr());
		offersPage.signout();
		
		LoginPage login=new LoginPage();
		login.navigateToLoginPage();
		login.setEmailForLogin(emailId);
		login.setPasswordForLogin(password);
		login.clickLogin();
		
		 
		OfferPageDebtPayOffers offersPageAfterLogin = new OfferPageDebtPayOffers();
		offersPageAfterLogin.validateIfOffersPageLoaded();
		Map<String, String> valuesOnLogin = new HashMap<String, String>();
		valuesOnLogin.put("loanAMount", offersPageAfterLogin.fetchLoanAmount());
		valuesOnLogin.put("monthlyPayment",offersPageAfterLogin.fetchMonthlyPayment());
		valuesOnLogin.put("term",offersPageAfterLogin.fetchTerm());
		valuesOnLogin.put("interestRate",offersPageAfterLogin.fetchInterestRate());
		valuesOnLogin.put("apr",offersPageAfterLogin.fetchApr());
		if(valuesOnOfferRequest.equals(valuesOnLogin))
		{
			System.out.println("Matching values");
		}

		offersPageAfterLogin.signout();
		driver.quit();
		}
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public String randomName() 
		{
	

			final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			final java.util.Random rand = new java.util.Random();
			final Set<String> identifiers = new HashSet<String>();
		    StringBuilder builder = new StringBuilder();
		    while(builder.toString().length() == 0) {
		        int length = rand.nextInt(5)+5;
		        for(int i = 0; i < length; i++) {
		            builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
		        }
		        if(identifiers.contains(builder.toString())) {
		            builder = new StringBuilder();
		        }
		    }
		    return builder.toString();
		}
		
	public String generateRandomPassword()
    {
        // ASCII range - alphanumeric (0-9, a-z, A-Z)
        final String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        final String number = "0123456789";
 
        final String upperCaseRandom=randomString(upperCase);
        final String lowerCaseRandom=randomString(lowerCase);
        final String numberRandom=randomString(number);
        
        return upperCaseRandom+lowerCaseRandom+numberRandom;
    }
	
	public String randomString(String textToRaondomise)
	{
		SecureRandom random = new SecureRandom();
        StringBuilder SB = new StringBuilder();
        for (int i = 4; i < 8; i++) 
        {
            int randomIndex = random.nextInt(textToRaondomise.length());
            SB.append(textToRaondomise.charAt(randomIndex));
        }
        return SB.toString();
	}
  
	
}
