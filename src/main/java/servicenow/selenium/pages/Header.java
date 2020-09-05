package servicenow.selenium.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import commonFunctions.ServiceCommon;

public class Header extends ServiceCommon{
	
	
	public Header(RemoteWebDriver driver){
		this.driver = driver;
	}

//	@FindBy(id="user_info_dropdown")
	public Header clickUserAccount(){
		driver.findElementById("user_info_dropdown").click();
		return this;
	}
	public ProfilePage clickProfile(){
		driver.findElementByLinkText("Profile").click();
		return new ProfilePage(driver);	
	}

}
