package testcases;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CredifyHomePage;

public class CredifyTestCase extends TestBase{


	public CredifyTestCase() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		
	}
	@Test
	public void verifyHomePageTitleTest() throws Throwable{
		try
		{
		CredifyHomePage credifyHomePage=new CredifyHomePage();
		credifyHomePage.navigateToURL();
		credifyHomePage.enterLoanAmount("3000");
		credifyHomePage.selectLoanPurpose("CREDIT_CARD");
		credifyHomePage.clickOnCheckRate();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
