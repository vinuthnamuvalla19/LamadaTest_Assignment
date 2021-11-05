package com.lambdatest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGTodo2 {

    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = System.getenv("LT_USERNAME") == null ? "vinuthnamuvalla19" : System.getenv("LT_USERNAME");
        String authkey = System.getenv("LT_ACCESS_KEY") == null ? "hLEg9nhX5i9TFjgJrZrvSJsfxQvl3oacCauUrNIOEKzERVgyFZ" : System.getenv("LT_ACCESS_KEY");
        
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
    public void basicTest() throws InterruptedException {
         String spanText;
        System.out.println("Loading Url");

        driver.get("https://www.lambdatest.com/automation-demos/");
	
	System.out.println("Entring username");
        driver.findElement(By.id("username")).sendKeys("lambda");

        System.out.println("Entering Password");
        driver.findElement(By.id("password")).sendKeys("lambda123");

        System.out.println("click on login");
        driver.findElement(By.xpath("//button[text() ='Login']")).click();

	System.out.println("Entering Email");
	driver.findElement(By.id("developer-name")).sendKeys("vinuthnamuvalla19@gmail.com");

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
	roles.selectByVisibleText("Credit or Debit card");

	System.out.println("checkBox1");
	driver.findElement(By.id("tried-ecom")).click();
	
	driver.findElement(By.id("comments")).sendKeys("All Cool");
	
	((JavascriptExecutor)driver).executeScript("window.open()");
    	ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
    	driver.switchTo().window(tabs1.get(1));
    
	driver.get("https://www.lambdatest.com/selenium-automation");
	Thread.sleep(2000);
	Actions action1 =new Actions(driver);
	WebElement Image = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/section[8]/div/div/div/div[1]/div[1]/a/img"));
	action1.contextClick(Image).build().perform();
	Thread.sleep(2000);
	action1.sendKeys(Keys.CONTROL, "s").build().perform();
	System.out.println("image downloded");
	Thread.sleep(2000);
	//driver.close();
	driver.switchTo().window(tabs1.get(0));

	Thread.sleep(2000);
	
	//driver.findElement(By.id("img")).click();
	
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
