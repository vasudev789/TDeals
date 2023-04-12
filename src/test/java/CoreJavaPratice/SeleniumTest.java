package CoreJavaPratice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.naming.directory.DirContext;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class SeleniumTest
{
	public static void main(String[] args) throws InterruptedException, IOException, AWTException 
	{
       System.out.println("-- Program to understand the concept of action class -- ");
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\vasudev\\eclipse-workspace\\TDeals\\src\\test\\resources\\Drivers\\chromedriver.exe");
       System.setProperty("webdriver.chrome.silentOutput", "true");
       WebDriver driver =new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       driver.get("https://jqueryui.com/droppable/");
       Thread.sleep(6000);
       Actions act =new Actions(driver);
       driver.switchTo().frame(0);
       WebElement drag =driver.findElement(By.xpath("//div[@id='draggable']"));
       WebElement drop =driver.findElement(By.xpath("//div[@id='droppable']"));
       //act.dragAndDrop(drag, drop).build().perform();
       act.clickAndHold(drag).moveToElement(drop).release(drag).build().perform();
       Thread.sleep(6000);
       driver.close();
	}
	
}
