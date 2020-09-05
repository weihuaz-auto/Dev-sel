package learnJSExecutor;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor {
	
	// gettile
	// document.title
	// window.open(url)
	ChromeDriver driver;
	@BeforeMethod
	public void before() {
		driver = new ChromeDriver();
	}
	@Test(enabled = false)
	public void scroll() throws IOException, InterruptedException {

		driver.get("https://www.naukri.com/");
		// scroll
		WebElement reviews = driver.findElementByLinkText("Company Reviews");
		System.out.println(reviews.getText());
		int y = reviews.getLocation().getY();
		driver.executeScript("scroll(0, "+y+")");
		Thread.sleep(2000);
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("snap.png");
		FileHandler.copy(screenshotAs, dest);
	}

	// set value
	public void setvalue() {
		driver.get("https://devlabs-860f0.web.app/edit");
		driver.executeScript("document.getElementById(\"fullName\").value = \"koushik\"");	
	}

	// read value
	
	public void getText() {
		driver.get("https://devlabs-860f0.web.app/edit");
		Object text = driver.executeScript("return document.getElementsByTagName(\"h1\")[0].textContent");
		System.out.println(text);
	}

	// highlight
	
	public void highlight() throws InterruptedException {
		driver.get("https://devlabs-860f0.web.app/edit");
		WebElement h1 = driver.findElementByXPath("//h1[.='Mostly with Inputs']");
		for (int i = 0; i < 10; i++) {
			driver.executeScript("arguments[0].setAttribute('style', 'background: pink;"
					+ "border: 2px solid blue;');", h1);
			Thread.sleep(250);
			driver.executeScript("arguments[0].setAttribute('style', 'background: white;"
					+ "border: 2px dotted red;');", h1);
			
		}
//		driver.executeScript("document.getElementsByTagName(\"h1\")[0].style = \"background : red\"");
	}

	// zoom
	@Test	
	public void zoom() {
		driver.get("https://devlabs-860f0.web.app/edit");
		String zoomMe = "document.body.style.zoom='170%'";
		driver.executeScript(zoomMe);
		
		
	}

	@AfterMethod
	public void after() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}

}
