package TDSteps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;

public class SelectClass 
{
	WebDriver driver;
	WebElement days;
	WebElement months;
	WebElement year;
	Select sel;
	List<WebElement> alldays;
	List<WebElement> allmonth;
	List<WebElement> allyear;
	@Given("^user opens the chrome broswer for face book$")
	public void user_opens_the_chrome_broswer_for_face_book() throws Throwable
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vasudev\\eclipse-workspace\\TDeals\\src\\test\\resources\\Drivers\\chromedriver.exe");
		System.setProperty("webddriver.chrome.silentOutput", "true");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(5000);
		
	}

	@Given("^user launches the face book website \"([^\"]*)\"$")
	public void user_launches_the_face_book_website(String URL) throws Throwable
	{
		driver.get(URL);
	}

	@Given("^user select the day of his choice \"([^\"]*)\"$")
	public void user_select_the_day_of_his_choice(String daychoice) throws Throwable
	{
		days=driver.findElement(By.xpath("//select[@id='day']"));
		sel =new Select(days);
		alldays=sel.getOptions();
		sel.selectByVisibleText(daychoice);
		Thread.sleep(3000);
		System.out.println();
		System.out.println("-- Printing all the days -- ");
		for(WebElement e:alldays)
		{
			System.out.print("  "+e.getText());
		}
		
	}

	@Given("^user selects the Month of his choice \"([^\"]*)\"$")
	public void user_selects_the_Month_of_his_choice(String monthChoice) throws Throwable
	{
		months=driver.findElement(By.xpath("//select[@id='month']"));
		sel =new Select(months);
		allmonth=sel.getOptions();
		sel.selectByVisibleText(monthChoice);
		Thread.sleep(3000);
		System.out.println();
		System.out.println("-- Printing all the avaliable months --");
		for(WebElement e:allmonth)
		{
			System.out.print(" "+e.getText());
		}
	}

	@Given("^user selects the year of his choice \"([^\"]*)\"$")
	public void user_selects_the_year_of_his_choice(String yearchoice) throws Throwable 
	{
		Thread.sleep(3000);
		year=driver.findElement(By.xpath("//select[@id='year']"));
		sel =new Select(year);
		allyear=sel.getOptions();
		sel.selectByVisibleText(yearchoice);
		Thread.sleep(4000);
		System.out.println();
		for(WebElement e:allyear)
		{
			System.out.print(" "+e.getText());
		}
		
	}

	@Given("^user closes the chrome browser for face book$")
	public void user_closes_the_chrome_browser_for_face_book() throws Throwable
	{
		Thread.sleep(4000);
		driver.close();
	}


}
