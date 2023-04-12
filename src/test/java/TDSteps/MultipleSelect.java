package TDSteps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class MultipleSelect
{
	WebDriver driver;
	WebElement country;
	Select sel;
	List<WebElement> countries;
	@Given("^user launches the chromeBrowser for to test Multipe select$")
	public void user_launches_the_chromeBrowser_for_to_test_Multipe_select() throws Throwable 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vasudev\\eclipse-workspace\\TDeals\\src\\test\\resources\\Drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
	}

	@Given("^user launches the URL as \"([^\"]*)\"$")
	public void user_launches_the_URL_as(String URL) throws Throwable
	{
		driver.get(URL);
		Thread.sleep(5000);
	}

	@Given("^user click on multiple select list box and select \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_click_on_multiple_select_list_box_and_select_and(String slectOption1, String slectOption2) throws Throwable 
	{
		country=driver.findElement(By.xpath("//select[@id='countriesMultiple']"));
		sel=new Select(country);
		countries=sel.getOptions();
		sel.selectByVisibleText(slectOption1);
		Thread.sleep(4000);
		sel.selectByVisibleText(slectOption2);
		Thread.sleep(4000);
		
	}

	@Given("^user prints all the elements of listbox$")
	public void user_prints_all_the_elements_of_listbox() throws Throwable 
	{
		for(WebElement con: countries)
		{
			System.out.print(" "+con.getText());
		}
	}

	@Given("^user deselects the selected options \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_deselects_the_selected_options_and(String option1, String option2) throws Throwable
	{
		sel.deselectByVisibleText(option1);
		Thread.sleep(4000);
		sel.deselectByVisibleText(option2);
	}

	@Given("^user closes the browser for muliptle select$")
	public void user_closes_the_browser_for_muliptle_select() throws Throwable 
	{
		Thread.sleep(4000);
		driver.close();
	}


}
