package TDSteps;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.common.io.Files;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class UrbanLadderActionClass 
{
	WebDriver driver;
	List<WebElement> menus;
	Actions act;
	TakesScreenshot ts;
	ArrayList<String> al =new ArrayList<>();
	@Given("^user opens the chrome browser for urban ldder as \"([^\"]*)\"$")
	public void user_opens_the_chrome_browser_for_urban_ldder_as(String URL) throws Throwable
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vasudev\\eclipse-workspace\\TDeals\\src\\test\\resources\\Drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
	}

	@Given("^User Navigate to all the menus present in the urban ladder$")
	public void user_Navigate_to_all_the_menus_present_in_the_urban_ladder() throws Throwable
	{
		menus=driver.findElements(By.xpath("//span[@class='topnav_itemname']"));
		act=new Actions(driver);
		
		for(WebElement e:menus)
		{
			act.moveToElement(e).build().perform();
			Thread.sleep(1200);
			System.out.print("  "+e.getText());
			TakeScreenPrint(driver, e.getText());
			Thread.sleep(1200);
			al.add(e.getText());
		}
	}

	@Given("^User user prints the menu list present int he urban ladder$")
	public void user_user_prints_the_menu_list_present_int_he_urban_ladder() throws Throwable
	{
		for(String s:al)
		{
			System.out.print(" "+al);
		}
	}

	

	@Then("^user closes the browser for urban ladder$")
	public void user_closes_the_browser_for_urban_ladder() throws Throwable 
	{
		Thread.sleep(6000);
		driver.close();
	}
	public static void TakeScreenPrint(WebDriver driver,String filename) throws IOException
	{
		TakesScreenshot ts =(TakesScreenshot)driver;
		File scr =ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\vasudev\\eclipse-workspace\\TDeals\\src\\test\\resources\\ScreenShot"+filename+".png");
		Files.copy(scr, dest);
	}


}
