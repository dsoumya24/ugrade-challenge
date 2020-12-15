package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase{
	
	

	//locators for elements on Login page

		@FindBy(name="username")
		WebElement userName;
		
		@FindBy(name="password")
		WebElement password;
	
		@FindBy(css="button.enDQXE")
		WebElement signIn;
		
		
		public LoginPage() {
			
			PageFactory.initElements(driver,this);
		}

		
		
		public void navigateToLoginPage()
		{
			driver.get("https://www.credify.tech/portal/login");
		}
		
		public void setEmailForLogin(String email)
		{
			userName.sendKeys(email);
		}

		public void setPasswordForLogin(String passwordValue)
		{
			password.sendKeys(passwordValue);
		}
		
		public void clickLogin()
		{
			signIn.click();
		}
}
