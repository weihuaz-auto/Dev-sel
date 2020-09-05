package servicenow.selenium.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import commonFunctions.ServiceCommon;

public class DashBoard extends ServiceCommon{
	public DashBoard(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public String enterOnSearch() {
		String title = driver.getTitle();
		return title;
		
	}

}
