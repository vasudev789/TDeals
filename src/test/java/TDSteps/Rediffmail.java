package TDSteps;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Utilities.ExcelUtilities;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Rediffmail 
{
	WebDriver driver;
	String URL;
	
	//https://the-internet.herokuapp.com/login
	String ErrorMessage="";
	
	@Given("^user opens chrome browser for redifmail as \"([^\"]*)\"$")
	public void user_opens_chrome_browser_for_redifmail_as(String url) throws Throwable 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vasudev\\eclipse-workspace\\TDeals\\src\\test\\resources\\Drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		URL=url;
		driver.get(URL);
		Thread.sleep(6000);
	}
	@Given("^User Enters Invalid username for rediffmail$")
	public void user_Enters_Invalid_username_for_rediffmail() throws Throwable
	{
		// Extracting data from excel sheet here using ExcelUtilities from utilities package
		HashMap<String, String> hm= ExcelUtilities.getMapData();
		WebElement username =driver.findElement(By.xpath("//input[@id='login1']"));
		for(Entry<String, String> en:hm.entrySet())
		{
			username.sendKeys(en.getKey());
			Thread.sleep(2000);
		}
	}

	@Given("^User Enters Invalid password for rediffmail$")
	public void user_Enters_Invalid_password_for_rediffmail() throws Throwable
	{
		WebElement password =driver.findElement(By.xpath("//input[@id='password']"));
		HashMap<String, String> hm= ExcelUtilities.getMapData();
		for(Entry<String, String> en:hm.entrySet())
		{
			password.sendKeys(en.getValue());
			Thread.sleep(2000);
		}
	}

	@Given("^User click on singin button for rediffmail$")
	public void user_click_on_singin_button_for_rediffmail() throws Throwable 
	{
		driver.findElement(By.xpath("//input[@name='proceed']")).click();
		Thread.sleep(3000);
	}

	@Then("^user should get Error message as \"([^\"]*)\"$")
	public void user_should_get_Error_message_as(String Errmsg) throws Throwable
	{
		WebElement Emsg= driver.findElement(By.xpath("//div[@id='div_login_error']"));
		ErrorMessage=Emsg.getText();
		Assert.assertEquals(ErrorMessage, Errmsg);
				
	}
	@Given("^User Enters Invalid username and password and validates the ErrorMessage as \"([^\"]*)\"$")
	public void user_Enters_Invalid_username_and_password_and_validates_the_ErrorMessage_as(String Emsg) throws Throwable 
	{
		HashMap<String, String> hm= ExcelUtilities.getMapData();
		
		for(Entry<String, String> en:hm.entrySet())
		{
			WebElement username =driver.findElement(By.xpath("//input[@id='username']"));
			WebElement password =driver.findElement(By.xpath("//input[@id='password']"));
			Thread.sleep(2000);
			username.sendKeys(en.getKey());
			Thread.sleep(2000);
			password.sendKeys(en.getValue());
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@class='radius']")).click();
			Thread.sleep(2000);
			WebElement EmsgD= driver.findElement(By.xpath("//div[@id='flash-messages']"));
			ErrorMessage=EmsgD.getText();
			//Assert.assertEquals(ErrorMessage, Emsg);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='username']")).clear();
			Thread.sleep(1000);
		}
	}
	
	@Given("^User closes the browser after validating$")
	public void user_closes_the_browser_after_validating() throws Throwable 
	{
		Thread.sleep(2000);
		driver.close();
	}



}
