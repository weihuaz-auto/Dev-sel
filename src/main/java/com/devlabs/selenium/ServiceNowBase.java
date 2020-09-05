package com.devlabs.selenium;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class ServiceNowBase implements Browser, Element{


	protected RemoteWebDriver driver;

	@Override
	public void click(WebElement ele) {
		try {
			ele.click();
			System.out.println("The element is clicked successfully");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element is not cliked");
		}catch (WebDriverException e) {
			System.err.println("Element not clicked "+e.getMessage());
		}finally {
			takeSnap();
		}

	}

	@Override
	public void append(WebElement ele, String data) {
		// TODO Auto-generated method stub
		String originString="";
		String newString="";
		try {
		originString=ele.getText();
		newString=originString+data;
		ele.sendKeys(newString);
		System.out.println("String is appended");
		}catch (NoSuchElementException e) {
			System.err.println("The string " +data + " is not appended"+e.getMessage());
		}catch (Exception e) {
			System.err.println("The string " +data + " is not appended"+e.getMessage());
		}finally {
			takeSnap();
		}

	}

	@Override
	public void clear(WebElement ele) {
		// TODO Auto-generated method stub
		try {
			ele.clear();
		}catch (NoSuchElementException e) {
			System.err.println("The web element is not cleared "+e.getMessage());
		}catch (Exception e) {
			System.err.println("The web element is not cleared "+e.getMessage());
		}finally {
			takeSnap();
		}
		

	}

	@Override
	public void clearAndType(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			System.out.println("The value " +data + " is typed");
		} catch (NoSuchElementException e) {
			System.err.println("The value " +data + " is not typed"+e.getMessage());
		}catch (Exception e) {
			System.err.println("The value " +data + " is not typed"+e.getMessage());
		}finally {
			takeSnap();
		}
	}

	static int i=0;

	void takeSnap(){
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("snap"+i+".png");
		i++;
		try {
			FileHandler.copy(screenshotAs, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String getElementText(WebElement ele) {
		// TODO Auto-generated method stub
		String eleText="";
		try {
			eleText=ele.getText();
			System.out.println("The text of the element is: "+eleText);
		} catch (NoSuchElementException e) {
			System.err.println("The value " +eleText + " is not got"+e.getMessage());
		}catch (Exception e) {
			System.err.println("The value " +eleText + " is not got"+e.getMessage());
		}finally {
			takeSnap();
		}
		return eleText;
	}

	@Override
	public String getBackgroundColor(WebElement ele) {
		// TODO Auto-generated method stub
		String bgColor=ele.getCssValue("color");
		
		
		return bgColor;
	}

	@Override
	public String getTypedText(WebElement ele) {
		// TODO Auto-generated method stub
		String typedText="";
		try {
		ele.sendKeys("test");
		typedText=ele.getText();
		System.out.println("The typed text is: "+typedText);
		}
		catch (NoSuchElementException e) {
			System.err.println("The value " +typedText + " is not typed"+e.getMessage());
		}catch (Exception e) {
			System.err.println("The value " +typedText + " is not typed"+e.getMessage());
		}finally {
			// takeSnap();
			return typedText;
		}
		//return typedText;
	}

	@Override
	public void selectDropDownUsingText(WebElement ele, String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			Select sel = new Select(ele);
			sel.selectByIndex(index);
			System.out.println("Drop Down is selected");
		} catch (NoSuchElementException e) {
			System.err.println("Not able to select the dropdown using index");
		}catch (WebDriverException e) {
			throw new WebDriverException();
		}finally {
			takeSnap();
		}
	}

	@Override
	public void selectDropDownUsingValue(WebElement ele, String value) {


	}

	@Override
	public boolean verifyExactText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		if (ele.equals(expectedText)) {
			return true;
		}
		else {
		return false;
		}
	}

	@Override
	public boolean verifyPartialText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		if (ele.getText().contains(expectedText)) {
			return true;
		}
		else {
		return false;
		}
	}

	@Override
	public boolean verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub
		if (ele.getAttribute(attribute).equals(value)) {
			return true;
		}
		else {
		return false;
		}
	}

	@Override
	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub
		if (ele.getAttribute(attribute).contains(value)) {
			System.out.println("the attribute contains "+value);
		}
		else {
			System.out.println("The attribute doesn't contain "+value);
		}
		

	}

	@Override
	public boolean verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub
		if (ele.isDisplayed()) {
			return true;
		}
		else {
		return false;
		}
	}

	@Override
	public boolean verifyDisappeared(WebElement ele) {
		// TODO Auto-generated method stub
		if (ele.getText().isEmpty()) {
		return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public boolean verifyEnabled(WebElement ele) {
		// TODO Auto-generated method stub
		if (ele.isEnabled()) {
			return true;
		}
		else {
			return false;
		}
		//return false;
	}

	@Override
	public void verifySelected(WebElement ele) {
		// TODO Auto-generated method stub
		if (ele.isSelected()) {
			System.out.println("The element is selected");
		}
		else {
			System.out.println("The element is not selected");
		}

	}

	@Override
	public void startApp(String url) {
		try {
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.err.println("Browser could not launched");
		}

	}

	@Override
	public void startApp(String browser, String url) {
		// TODO Auto-generated method stub
		//String bName=browser+"Driver();";
		//driver= new bName;
		
		

	}

	@Override
	public WebElement findElementBy(String locatorType, String value) {
		// TODO Auto-generated method stub
		String newString="findElementBy"+locatorType;
		//WebElement ele=driver.newString(value);
		
		return null;
	}

	@Override
	public WebElement findElementBy(String value) {
		// TODO Auto-generated method stub
		WebElement ele=driver.findElementByName(value);
		
		return ele;
	}

	@Override
	public List<WebElement> findElementBys(String type, String value) {
		// TODO Auto-generated method stub
		//driver.findElements
		//List<WebElement> ele=new <WebElement>;
		return null;
	}

	@Override
	public void switchToAlert() {
		// TODO Auto-generated method stub
		driver.switchTo().alert();
	}

	@Override
	public void acceptAlert() {
		// TODO Auto-generated method stub
		driver.switchTo().alert().accept();
	}

	@Override
	public void dismissAlert() {
		// TODO Auto-generated method stub
		driver.switchTo().alert().dismiss();

	}

	@Override
	public String getAlertText() {
		// TODO Auto-generated method stub
		String alertText=driver.switchTo().alert().getText();
		return alertText;
	}

	@Override
	public void typeAlert(String data) {
		// TODO Auto-generated method stub
		driver.switchTo().alert().sendKeys(data);

	}

	@Override
	public void switchToWindow(int index) {
		// TODO Auto-generated method stub
		//driver.switchTo().

	}

	@Override
	public void switchToWindow(String title) {
		// TODO Auto-generated method stub
		driver.switchTo().window(title);

	}

	@Override
	public void switchToFrame(int index) {
		// TODO Auto-generated method stub
		driver.switchTo().frame(index);

	}

	@Override
	public void switchToFrame(WebElement ele) {
		// TODO Auto-generated method stub
		driver.switchTo().frame(ele);

	}

	@Override
	public void switchToFrame(String idOrName) {
		// TODO Auto-generated method stub
		driver.switchTo().frame(idOrName);

	}

	@Override
	public void defaultContent() {
		// TODO Auto-generated method stub
		driver.switchTo().defaultContent();

	}

	@Override
	public boolean verifyUrl(String url) {
		// TODO Auto-generated method stub
		if (driver.getCurrentUrl().equals(url)) {
			return true;
		}
		else {
		return false;
		}
	}

	@Override
	public boolean verifyTitle(String title) {
		// TODO Auto-generated method stub
		if (driver.getTitle().equals(title)) {
			return true;
		}
		else {
		return false;
		}
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		driver.close();
	}

	@Override
	public void quit() {
		driver.quit();

	}

}
