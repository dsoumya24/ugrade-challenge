package testcases;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.BasicInfoPage;
import pages.CreateAccountPage;
import pages.CredifyHomePage;
import pages.IncomePage;
import pages.LoginPage;
import pages.OfferPageDebtPayOffers;

public class VerifyOfferOnLogin extends TestBase{


	public VerifyOfferOnLogin() {
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
			String line = "";  
			String splitBy = ",";  
			String[] pii = null ;
				 
			BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+ "/TestData/TestData.csv"));  
			while ((line = br.readLine()) != null)   //returns a Boolean value  
				{  
					pii= line.split(splitBy);    // use comma as separator  
					CredifyHomePage credifyHomePage=new CredifyHomePage();
					credifyHomePage.navigateToURL();
					credifyHomePage.enterLoanAmount(pii[0]);
					credifyHomePage.selectLoanPurpose(pii[1]);
					credifyHomePage.clickOnCheckRate();
					credifyHomePage.validateIfRequiredDataEntered();
					
					BasicInfoPage basicPage = new BasicInfoPage();
					basicPage.enterFirstName(randomName());
					basicPage.enterLastName(randomName());
					basicPage.enterStreet(pii[2]);
					basicPage.enterCity(pii[3]);
					basicPage.enterState(pii[4]);
					basicPage.enterZipCode(pii[5]);
					basicPage.enterDOB(randomDateBetweenDates());
					basicPage.clickContinue();
					basicPage.validateInputText();
					
					IncomePage incPage = new IncomePage();
					incPage.validateIfIncomeInfoPageIsLoaded();
					incPage.enterAnnualIncome(String.valueOf(generateRandomNumInRange(200000,120001)));
					incPage.enterAdditionalIncome(String.valueOf(generateRandomNumInRange(10000,5001)));
					incPage.clickContinueOnIncomePage();
					incPage.validateIfDataEntered();
					
					CreateAccountPage createAccPage=new CreateAccountPage();
					Random rand = new Random(); 
				    int randomNum = rand.nextInt(60); 
				    String emailId="candidate"+randomNum+"@upgrade-challenge.com";
					createAccPage.enterEmailAddress(emailId);
					String password=generateRandomPassword();
					createAccPage.enterPassword(password);
					System.out.println("password "+password);
					createAccPage.validateIfValidPassword();
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
					
			}
		}
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

	public String randomName() 
		{

			final String textTorandomise = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";		
			final String randomName=randomString(textTorandomise,12);
		    return randomName;
		}
	public String randomDateBetweenDates()
	{
		Random random = new Random();
		int minDay = (int) LocalDate.of(1930, 1, 1).toEpochDay();
		int maxDay = (int) LocalDate.of(2000, 1, 1).toEpochDay();
		long randomDay = minDay + random.nextInt(maxDay - minDay);
		LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
		final String dateToReturn=DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH).format(randomBirthDate);
		return dateToReturn;
	}
	public String generateRandomPassword()
    {
        // ASCII range - alphanumeric (0-9, a-z, A-Z)
        final String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        final String number = "0123456789";
        final String upperCaseRandom=randomString(upperCase,7);
        final String lowerCaseRandom=randomString(lowerCase,7);
        final String numberRandom=randomString(number,6);
        return upperCaseRandom+lowerCaseRandom+numberRandom;
    }
	public String randomString(String textToRaondomise,int lenOfRandomText)
	{
		SecureRandom random = new SecureRandom();
        StringBuilder SB = new StringBuilder();
        for (int i = 4; i < lenOfRandomText; i++) 
        {
            int randomIndex = random.nextInt(textToRaondomise.length());
            SB.append(textToRaondomise.charAt(randomIndex));
        }
        return SB.toString();
	}
	public int generateRandomNumInRange(int fromInt,int toInt)
	{	
		    return (int) ((Math.random() * (toInt - fromInt)) + fromInt);		
	}
	
}
