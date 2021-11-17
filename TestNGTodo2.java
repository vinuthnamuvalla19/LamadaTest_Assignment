package com.lambdatest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
public class TestNGTodo2 {

    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = System.getenv("LT_USERNAME") == null ? "ecses3" : System.getenv("LT_USERNAME");
        String authkey = System.getenv("LT_ACCESS_KEY") == null ? "HqiExONfzHI0eF4S6VbmaPHgruyvl5pC4z6HGMCtJkgEH8j5dp" : System.getenv("LT_ACCESS_KEY");
        
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("browserName", "chrome");
        caps.setCapability("version", "95.0");
        caps.setCapability("build", "TestNG With Java");
        caps.setCapability("name", m.getName() + this.getClass().getName());
        caps.setCapability("plugin", "git-testng");

        String[] Tags = new String[] { "Feature", "Magicleap", "Severe" };
        caps.setCapability("tags", Tags);

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
    }

    @Test
    public void basicTest() throws Exception {
        String spanText;
        System.out.println("Loading Url");
	driver.get("https://www.lambdatest.com/automation-demos/");
	
	System.out.println("Entring username");
        driver.findElement(By.id("username")).sendKeys("lambda");

        System.out.println("Entering Password");
        driver.findElement(By.id("password")).sendKeys("lambda123");

        System.out.println("click on login");
        driver.findElement(By.xpath("//button[text() ='Login']")).click();

	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	driver.switchTo().window(tabs.get(0)); 
	Thread.sleep(2000);

	System.out.println("Entering Email");
	driver.findElement(By.cssSelector("#developer-name")).sendKeys("ecses3@gmail.com");

	System.out.println("click on populate");
	driver.findElement(By.id("populate")).click();
	driver.switchTo().alert().accept();

	System.out.println("radio click");
	driver.findElement(By.id("year")).click();

	System.out.println("checkBox");
	driver.findElement(By.id("discounts")).click();
	driver.findElement(By.id("others")).click();
	
	System.out.println("DropDown");
	WebElement payment = driver.findElement(By.id("preferred-payment"));
	Select roles = new Select(payment);
	roles.selectByVisibleText("Wallets");

	System.out.println("checkBox1");
	driver.findElement(By.id("tried-ecom")).click();
	
	WebElement Scale = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/section[2]/div/div/div[4]/div[2]/div/div/div[1]/div/div[12]"));
	Scale.click();
		int i = 0;
        while (i < 4)
        {
            Scale.sendKeys(Keys.RIGHT);
            //Thread.sleep(2000);
            ++i;
        } 
	Thread.sleep(2000);
	System.out.println("scale moved 9");
	
	WebElement comment = driver.findElement(By.id("comments"));
	comment.sendKeys("Cool");
		Thread.sleep(2000);
		
	((JavascriptExecutor)driver).executeScript("window.open()");
	ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(tabs1.get(1));
	driver.get("https://www.lambdatest.com/selenium-automation");
	Thread.sleep(2000);
	WebElement Image = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/section[8]/div/div/div/div[1]/div[1]/a/img"));
	
		Actions action = new Actions(driver);
		action.contextClick(Image).build().perform();
		//action.sendKeys(Keys.CONTROL, "v").build().perform();
		action.sendKeys(Keys.CONTROL, "s").build().perform();
		Thread.sleep(3000);
		Robot robot = new Robot(); 
//		robot.keyPress(KeyEvent.VK_TAB);
//		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_V);
		//robot.keyRelease(KeyEvent.VK_);
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_S);
		//robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER); 
		robot.keyRelease(KeyEvent.VK_ENTER); 

		Thread.sleep(2000);
		System.out.println("image downloded");
		Thread.sleep(2000);
		
		driver.close();
		
		driver.switchTo().window(tabs1.get(0)); 
	    Thread.sleep(2000);
	    WebElement Uplodeimage = driver.findElement(By.id("img"));
		Uplodeimage.click();
		Thread.sleep(5000);
		
		
	String path = System.getProperty("user.dir");
	StringSelection str = new StringSelection(path + "\\src\\input\\jenkins.svg");
	Uplodeimage.sendKeys(str);
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
	Robot rb = new Robot();
	     rb.keyPress(KeyEvent.VK_CONTROL);
	     rb.keyPress(KeyEvent.VK_V);
	    rb.keyRelease(KeyEvent.VK_CONTROL);
	    rb.keyRelease(KeyEvent.VK_V);
	System.out.println("path is given");
	    Thread.sleep(2000);
	    rb.keyPress(KeyEvent.VK_ENTER);
	    //rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
	System.out.println("image is uploded");

	driver.switchTo().alert().accept();

	System.out.println("click on submit");
	driver.findElement(By.id("submit-button")).click();
	Thread.sleep(3000);
        System.out.println("TestFinished");

    }

    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }

}
