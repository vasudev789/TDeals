package TDSteps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class AlertsPopUp
{
	static WebDriver driver;
	Alert alt;
	String msg;
	@Given("^user opens the chrome browser for rediff$")
	public void user_opens_the_chrome_browser_for_rediff() throws Throwable
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vasudev\\eclipse-workspace\\TDeals\\src\\test\\resources\\Drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}

	

	@Given("^user only enters the user name \"([^\"]*)\"$")
	public void user_only_enters_the_user_name(String username) throws Throwable
	{
		driver.findElement(By.xpath("//input[@id='login1']")).sendKeys(username);
		Thread.sleep(3000);
	}

	@Given("^user clicks on signing button$")
	public void user_clicks_on_signing_button() throws Throwable 
	{
		driver.findElement(By.xpath("//input[@name='proceed']")).click();
	}

	@Then("^user receives an popup messase as \"([^\"]*)\"$")
	public void user_receives_an_popup_messase_as(String errmsg) throws Throwable
	{
		alt=driver.switchTo().alert();
		msg=alt.getText();
		Assert.assertEquals(msg, errmsg);
		
	}

	@Then("^user accepts the popus message$")
	public void user_accepts_the_popus_message() throws Throwable
	{
		alt.accept();
		Thread.sleep(4000);
	}

	@Then("^closes the browser$")
	public void closes_the_browser() throws Throwable
	{
		driver.close();
	}
	@Given("^Use launchess the url as \"([^\"]*)\"$")
	public void use_launchess_the_url_as(String url) throws Throwable
	{
		driver.get(url);
		Thread.sleep(4000);
	}
	
	@Given("^user only enters the password \"([^\"]*)\"$")
	public void user_only_enters_the_password(String password) throws Throwable 
	{
		driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys(password);
	}
	
	@Given("^user directly clicks on signing button$")
	public void user_directly_clicks_on_signing_button() throws Throwable 
	{
		driver.findElement(By.xpath("//input[@name='proceed']")).click();
	}



}
