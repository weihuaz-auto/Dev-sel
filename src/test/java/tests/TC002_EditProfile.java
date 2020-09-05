package tests;

import org.testng.annotations.Test;

import commonFunctions.ServiceCommon;
import servicenow.selenium.pages.Header;
import servicenow.selenium.pages.LoginPage;

public class TC002_EditProfile extends ServiceCommon{



	@Test
	public void login() {

		new LoginPage(driver)
		.enterUserName("admin")
		.enterPassword("Pass123$")
		.clickLogin();
		
		new Header(driver)
		.clickUserAccount()
		.clickProfile()
		.printTitle();


		/*
		 * LoginPage lp = new LoginPage(); lp.enterUserName("admin");
		 * lp.enterPassword("Pass123$"); lp.clickLogin();
		 */
	}

}
