package servicenow.selenium.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import commonFunctions.ServiceCommon;

public class ProfilePage extends ServiceCommon {
	ProfilePage(RemoteWebDriver driver){
		this.driver = driver;
	}

	public void printTitle() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(driver.getTitle());
	}

}
