package org.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass  {
   public static WebDriver driver;
	public static WebDriver setDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\Seleniumstarts\\DDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		 return driver;
	}
	public static void launch(String s) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(s);
	}
	public static void maximize() {
		driver.manage().window().maximize();
	}
	public static void launch1(String url) {
		driver.get(url);
	}
	public static void title() {
		String title = driver.getTitle();
		System.out.println(title);	
	}
	public static void currentUrl() {
		String url = driver.getCurrentUrl();
		System.out.println(url);
	}
	public static void close() {
		driver.close();
	}
	public static void quit() {
		driver.quit();
	}
	public static WebElement inspect(String value) {
		WebElement element = driver.findElement(By.xpath(value));
		
     return element;
	}
	public static WebElement inspect1(String value) {
		WebElement element = driver.findElement(By.id(value));
		
     return element;
	}
	public static WebElement inspect2(String value) {
		WebElement element = driver.findElement(By.name(value));
		
     return element;
	}
	public static WebElement inspect3(String value) {
		WebElement element = driver.findElement(By.className(value));
		
     return element;
	}
	public static WebElement locators(String type, String value) {
		
		if (type=="id") {
			WebElement element = driver.findElement(By.id(value));
			return element;	
		}
		else if (type=="className") {
			WebElement element = driver.findElement(By.className(value));
			return element;
		}
		else if (type=="name") {
			WebElement element = driver.findElement(By.name(value));
			return element;
		}
		else {
			WebElement element = driver.findElement(By.xpath(value));
			return element;
		}
		
	}
	public static void sendK(WebElement refName , String value) {
		refName.sendKeys(value);
		
	}
	public static void sendKkeys(WebElement refName , String value) {
		refName.sendKeys(value,Keys.ENTER);
		
	}
	public static void buttonCl(WebElement refName) {
        refName.click();
	}
	public static void text(WebElement refname) {
      String text = refname.getText();
      System.out.println(text);
	}
	public static void attributeGet(WebElement refname) {
	String attribute = refname.getAttribute("value");
	System.out.println(attribute);
	}
	public static void actToDo(WebElement refname) {
		Actions act = new Actions(driver);
		act.moveToElement(refname).perform();
	}
	public static void dragnDrop(String value, String value2) {
		Actions act = new Actions(driver);
		WebElement vv = driver.findElement(By.xpath(value));
		WebElement vvv = driver.findElement(By.xpath(value2));
		act.dragAndDrop(vv, vvv).perform();
		}
	public static void dragnDrop2(WebElement refname,WebElement refname2) {
		Actions act = new Actions(driver);
		act.dragAndDrop(refname, refname2).perform();
		}
	public static void rightClick(WebElement refname) {
		Actions act = new Actions(driver);
		act.contextClick(refname).perform();
	}
	public static void actShift(WebElement refName,String value) {
		Actions act = new Actions(driver);
		act.keyDown("SHIFT").sendKeys(refName, value).keyUp("SHIFT");
	}
	public static void actKeyboard(WebElement refName,String value, String key) {
		Actions act = new Actions(driver);
		act.keyDown(key).sendKeys(refName, value).keyUp(key);
	}
	public static void doubleClick(WebElement refname) {
		Actions act = new Actions(driver);
		act.doubleClick(refname).perform();
	}
	public static void simpleAlert() {
		Alert al = driver.switchTo().alert();
		al.accept();
	}
	public static void confirmAlert() {
		Alert al = driver.switchTo().alert();
		al.dismiss();
	}
	public static void promptAlert(String value) {
     Alert al = driver.switchTo().alert();
     al.sendKeys(value);
     String text = al.getText();
     System.out.println(text);
     al.accept();
	}
	public static void navigateTo(String url) {
      driver.navigate().to(url);
	}
	public static void navigateBack() {
		driver.navigate().back();
	}
	public static void navigateRefresh() {
      driver.navigate().refresh();
	}
	public static void navigateForward() {
		driver.navigate().forward();
	}
	public static void robot(int value) throws AWTException {
		Robot r = new Robot();
		r.keyPress(value);
		r.keyRelease(value);
	}
	public static void robot1() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
	}
	public static void robot2() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_C);
	}
	public static void robot3() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public static void screenshot(String location) throws IOException {
		TakesScreenshot tks = (TakesScreenshot) driver;
		File file = tks.getScreenshotAs(OutputType.FILE);
		File d = new File(location);
		FileUtils.copyFile(file, d);
	}
	public static void screenshot1(WebElement refName, String location) throws IOException {
		TakesScreenshot tks = (TakesScreenshot) driver;
		File file = refName.getScreenshotAs(OutputType.FILE);
		File d = new File(location);
		FileUtils.copyFile(file, d);
	}
	public static void javaScript(WebElement refName, String value) {
		JavascriptExecutor jks = (JavascriptExecutor) driver;
		jks.executeScript(value, refName);
	}
	public static void javaScript0(WebElement refName) {
		JavascriptExecutor jks = (JavascriptExecutor) driver;
		Object executeScript = jks.executeScript("return arguments[0].getAttribute('value')", refName);
		System.out.println(executeScript);
	}
	public static void javaScript1(WebElement refName) {
		JavascriptExecutor jks = (JavascriptExecutor) driver;
		jks.executeScript("arguments[0].'click'", refName);
	}
	public static void javscriptDown(WebElement refName) {
		JavascriptExecutor jks = (JavascriptExecutor) driver;
		jks.executeScript("arguments[0].scrollInToView(true)", refName);
	}
	public static void javscriptUp(WebElement refName) {
		JavascriptExecutor jks = (JavascriptExecutor) driver;
		jks.executeScript("arguments[0].scrollInToView(false)", refName);
	}
	public static void select(WebElement refName , int value) {
		Select s = new Select(refName);
		s.selectByIndex(value);
	}
	public static void select1(WebElement refName , String value) {
		Select s = new Select(refName);
		s.selectByValue(value);
	}
	public static void selectM(WebElement refName, int value, String value1, String value2) {
		Select s = new Select(refName);
		s.selectByIndex(value);
		s.selectByValue(value1);
		s.selectByVisibleText(value2);
	}
	public static void selectCheck(WebElement refName) {
		Select s = new Select(refName);
		boolean multiple = s.isMultiple();
		System.out.println(multiple);
	}
	public static void selectFirst(WebElement refName, int value, String value1, String value2) {
		Select s = new Select(refName);
		s.selectByIndex(value);
		s.selectByValue(value1);
		s.selectByVisibleText(value2);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		System.out.println(firstSelectedOption);
	}
	public static void selectAll(WebElement refName, int value, String value1, String value2) {
		Select s = new Select(refName);
		s.selectByIndex(value);
		s.selectByValue(value1);
		s.selectByVisibleText(value2);
		List<WebElement> li = s.getAllSelectedOptions();
		for (int i = 0; i < li.size(); i++) {
			WebElement webElement = li.get(i);
			String text = webElement.getText();
			System.out.println(text);
		}
	}
	public static void selectOverAll(WebElement refName) {
		Select s = new Select(refName);
		
		List<WebElement> li = s.getOptions();
		for (int i = 0; i < li.size(); i++) {
			WebElement webElement = li.get(i);
			String text = webElement.getText();
			System.out.println(text);
		}
	}
	public static void windowHandle() {
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
	}
	public static void windowHandles() {
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
	}
	public static void windowSwitchto() {
		String parent = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String x : windowHandles) {
			if (!x.equals(parent)) {
				driver.switchTo().window(x);
			}
		}
	}
	public static void windowDefault() {
		driver.switchTo().defaultContent();
	}
	public static void windowSwitch(String value) {
		driver.switchTo().window(value);
	}
	public static void threadW(int value) throws InterruptedException {
		Thread.sleep(value);
	}
	public static void implicitWait(int value) {
		driver.manage().timeouts().implicitlyWait(value, TimeUnit.SECONDS);
	}
	public static void frames(WebElement refName) {
		driver.switchTo().frame(refName);
	}
	public static void frames1(int value) {
		driver.switchTo().frame(value);
	}
	public static void inspectS(String value) {
		List<WebElement> list = driver.findElements(By.tagName(value));
		int size = list.size();
		System.out.println(size);
	}
	public static void inspectSp(String value) {
		List<WebElement> list = driver.findElements(By.tagName(value));
		for (int i = 0; i < list.size(); i++) {
			WebElement element = list.get(i);
			String text = element.getText();
			System.out.println(text);
		}
	}
	
}



