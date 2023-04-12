package TDSteps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;

public class DragNDrop 
{
	WebDriver driver;
	Actions act;
	WebElement drag;
	WebElement drop;
	@Given("^User opens the chrome browser for jquery website$")
	public void user_opens_the_chrome_browser_for_jquery_website() throws Throwable 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vasudev\\eclipse-workspace\\TDeals\\src\\test\\resources\\Drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}

	@Given("^User opens the jquery url as \"([^\"]*)\"$")
	public void user_opens_the_jquery_url_as(String URL) throws Throwable 
	{
		driver.get(URL);
		Thread.sleep(5000);
		driver.switchTo().frame(0);
	}

	@Given("^user selects the drag option$")
	public void user_selects_the_drag_option() throws Throwable
	{
		
		drag=driver.findElement(By.xpath("//div[@id='draggable']"));
	}

	@Given("^user selects the drop option$")
	public void user_selects_the_drop_option() throws Throwable
	{
	
		drop= driver.findElement(By.xpath("//div[@id='droppable']"));
		
	}

	@Given("^user drops the selected drag$")
	public void user_drops_the_selected_drag() throws Throwable
	{
		
		act=new Actions(driver);
		act.dragAndDrop(drop, drag).build().perform();
		Thread.sleep(9000);
	}

	@Given("^user closes the browser for jquery$")
	public void user_closes_the_browser_for_jquery() throws Throwable 
	{
		driver.close();
	}


}
