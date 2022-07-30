package trial;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Tempt 
{
	public static ChromeDriver driver;
	public static void BrowserLaunch(String strBrowser, String strExe) throws InterruptedException 
	{
				//BrowserLaunch
				System.setProperty("webdriver.chrome.driver", "F:\\Automation Support\\Browsers\\chromedriver.exe");
				ChromeDriver driver =new ChromeDriver();
				driver.manage().window().maximize();
				Thread.sleep(3000);
				
				//OpenApplication
				driver.get("http://primusbank.qedgetech.com/");
				
				//Enter UserName
				driver.findElement(By.xpath("//*[@id='txtuId']")).sendKeys("Admin");
				
				//EnterPassword
				driver.findElement(By.xpath("//*[@id='txtPword']")).sendKeys("Admin");
				Thread.sleep(3000);
				
				//Click on login Button
				driver.findElement(By.xpath("//*[@id='login']")).click();
				Thread.sleep(3000);
				
				//Click on Branches
				driver.findElement(By.xpath("(//*[@width='132'])[1]")).click();
				
				//Select Country
				Select selCountry =new Select(driver.findElement(By.xpath("//*[@name='lst_countryS']")));
				selCountry.selectByValue("INDIA");
				Thread.sleep(3000);
				
				//Select State
				Select selState =new Select(driver.findElement(By.xpath("//*[@name='lst_stateS']")));
				selState.selectByValue("Andhra Pradesh");
				Thread.sleep(3000);
				
				//Select City
				Select selCity =new Select(driver.findElement(By.xpath("//*[@name='lst_cityS']")));
				selCity.selectByValue("Hyderabad");
				Thread.sleep(3000);
				
				//Click on search
				driver.findElement(By.xpath("//*[@id='btn_search']")).click();	
	}
	public static void main(String[] args)
	{
		
		
	}
}