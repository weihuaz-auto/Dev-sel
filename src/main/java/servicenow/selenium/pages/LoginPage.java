package servicenow.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonFunctions.ServiceCommon;

public class LoginPage extends ServiceCommon{

	public LoginPage(RemoteWebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(id="user_name")
	private WebElement eleUsername;
	//	private List<WebElement> eleUsername;

	@CacheLookup
	@FindBy(id="user_password") private WebElement elePassword;

	@CacheLookup
	@FindBy(id="sysverb_login") private WebElement eleLoginBtn;


	public LoginPage enterUserName(String username){
		driver.switchTo().frame(0);
		clearAndType(eleUsername, username);
		return this;
	}

	public LoginPage enterPassword(String password){
		clearAndType(elePassword, password);
		return this;

	}

	public DashBoard clickLogin() {
		click(eleLoginBtn);
		return new DashBoard(driver);
	}

	public void login() {
		// TODO
	}

}
