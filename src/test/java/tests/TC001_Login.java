package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commonFunctions.ServiceCommon;
import servicenow.selenium.pages.LoginPage;

public class TC001_Login extends ServiceCommon{

	@BeforeClass
	public void setData() {
		excelname = "TC001";		
	}

	@Test(dataProvider = "login")
	public void login(String un, String pass) {
		new LoginPage(driver)
		.enterUserName(un)
		.enterPassword(pass)
		.clickLogin();
	}

}
