package SeleniumDirectRun;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test 
{
	public static void main(String[] args) throws InterruptedException
	{
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\vasudev\\eclipse-workspace\\TDeals\\src\\test\\resources\\Drivers\\chromedriver.exe");
       System.setProperty("webdriver.chrome.silentOutput", "true");
       WebDriver driver =new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       driver.get("https://ksrtc.in/oprs-web/");
       Thread.sleep(5000);
       String firstpage=driver.getWindowHandle();
       driver.findElement(By.xpath("//p[text()='CRM']")).click();
       Thread.sleep(8000);
       Set<String> windows=driver.getWindowHandles();
       String currentwindow;
       System.out.println(" The number of windows present on screen are = "+windows.size());
       Iterator<String> itr=windows.iterator();
       while(itr.hasNext())
       {
    	   currentwindow=itr.next();
    	   if(!currentwindow.equals(firstpage))
    	   {
    		   driver.switchTo().window(currentwindow);
    		   Thread.sleep(5000);
    		   driver.findElement(By.xpath("//input[@id='support-search-input']")).sendKeys("vasudev");
    		   Thread.sleep(2000);
    		   driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
    		   
    	   }
       }
       Thread.sleep(7000);
       driver.switchTo().window(firstpage);
       Thread.sleep(9000);
       driver.close();
       Thread.sleep(5000);
       driver.quit();
	}

}
