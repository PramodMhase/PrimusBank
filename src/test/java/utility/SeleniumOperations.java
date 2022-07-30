package utility;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumbermap.ConfigReader;

public class SeleniumOperations
{
	public static WebDriver driver=null;
	public static ConfigReader config;
	public static Hashtable<String, Object> outputparameters= new Hashtable<String, Object>();
		public static Hashtable<String, Object> BrowserLaunch(Object[]Inputparameters) throws InterruptedException 
		{
			try 
			{
				String strBrowserName=(String)Inputparameters[0];
				if(strBrowserName.equalsIgnoreCase("Chrome"))
				{
				config =new ConfigReader();
				System.setProperty("webdriver.chrome.driver", config.getDriverPathChrome());
				driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait(), TimeUnit.SECONDS);
				}
				
				else if (strBrowserName.equalsIgnoreCase("FF"))
				{
					System.setProperty("webdriver.gecko.driver", config.getDriverPathFF());
					driver=new FirefoxDriver();
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait(), TimeUnit.SECONDS);
				}
				outputparameters.put("STATUS", "PASS");
				outputparameters.put("MESSAGE", "Action:BrowserLaunch, Input:"+Inputparameters[0].toString());
			}
			catch(Exception e)
			{
				outputparameters.put("STATUS", "FAIL");
				outputparameters.put("MESSAGE", "Action:BrowserLaunch, Input:"+Inputparameters[0].toString());

			}
			return outputparameters;
		}
		public static Hashtable<String, Object> OpenApplication() throws InterruptedException
		{
			try
			{
				driver.get(config.getApplicationUrl());
				driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait(), TimeUnit.SECONDS);
				outputparameters.put("STATUS", "PASS");
				outputparameters.put("MESSAGE", "Action:OpenApplication, Input:"+config.getApplicationUrl().toString());
			}
			catch(Exception e)
			{
				outputparameters.put("STATUS", "FAIL");
				outputparameters.put("MESSAGE", "Action:OpenApplication, Input:"+config.getApplicationUrl().toString());
			}
			return outputparameters;
		}
		public static Hashtable<String, Object> SendTextOnUI(Object[]Inputparameters)
		{
			try
			{
				String path=(String)Inputparameters[0];
				String value=(String)Inputparameters[1];
				driver.findElement(By.xpath(path)).sendKeys(value);
				driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait(), TimeUnit.SECONDS);
				outputparameters.put("STATUS", "PASS");
				outputparameters.put("MESSAGE", "Action:SendTextOnUI, Input:"+Inputparameters[1].toString());

			}
			catch(Exception e)
			{
				outputparameters.put("STATUS", "FAIL");
				outputparameters.put("MESSAGE", "Action:SendTextOnUI, Input:"+Inputparameters[1].toString());
			}
			return outputparameters;
		}		
		public static Hashtable<String, Object> ClickOnElment(Object[]Inputparameters) throws InterruptedException
		{
			try
			{
				String path=(String)Inputparameters[0];
				driver.findElement(By.xpath(path)).click();
				driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait(), TimeUnit.SECONDS);
				outputparameters.put("STATUS", "PASS");
				outputparameters.put("MESSAGE", "Action:ClickOnElment, Input:"+Inputparameters[0].toString());

			}
			catch(Exception e)
			{
				outputparameters.put("STATUS", "FAIL");
				outputparameters.put("MESSAGE", "Action:ClickOnElment, Input:"+Inputparameters[0].toString());
			}
			return outputparameters;
		}
		public static Hashtable<String, Object> SelectElement(Object[]Inputparameters) throws InterruptedException
		{
			try
			{
				String path=(String)Inputparameters[0];
				String value=(String)Inputparameters[1];
				Select sel =new Select(driver.findElement(By.xpath(path)));
				sel.selectByValue(value);
				driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait(), TimeUnit.SECONDS);
				outputparameters.put("STATUS", "PASS");
				outputparameters.put("MESSAGE", "Action:SelectElement, Input:"+Inputparameters[1].toString());
			}
			catch(Exception e)
			{
				outputparameters.put("STATUS", "FAIL");
				outputparameters.put("MESSAGE", "Action:SelectElement, Input:"+Inputparameters[1].toString());
			}
			return outputparameters;
		}		
		public static Hashtable<String, Object> Validation(Object[]Inputparameters) throws InterruptedException
		{
			try
			{
				String path=(String)Inputparameters[0];
				String actualValue=driver.findElement(By.xpath(path)).getText();
				if(actualValue.equalsIgnoreCase("Branch Details"))
				{
					System.out.println("Test Case Pass");
				}
				else
				{
					System.out.println("Test Case Fail");	
				}
				driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait(), TimeUnit.SECONDS);
				outputparameters.put("STATUS", "PASS");
				outputparameters.put("MESSAGE", "Action:Validation, Input:"+Inputparameters[0].toString());
			}
			catch(Exception e)
			{
				outputparameters.put("STATUS", "FAIL");
				outputparameters.put("MESSAGE", "Action:Validation, Input:"+Inputparameters[1].toString());
			}
			return outputparameters;
		}
	public static void main(String[] args) throws InterruptedException
	{
		//BrowserLaunch
		Object[] input = new Object[1];
		input[0]="webdriver.chrome.driver";
		SeleniumOperations.BrowserLaunch(input);
		Thread.sleep(3000);
		
		//OpenApplication
		SeleniumOperations.OpenApplication();
		Thread.sleep(3000);

		//EnterUsername
		Object[] input3 = new Object[2];
		input3[0]="//*[@id='txtuId']";
		input3[1]="Admin";
		SeleniumOperations.SendTextOnUI(input3);
		Thread.sleep(3000);		
		
		//EnterPassword
		Object[] input4 = new Object[2];
		input4[0]="//*[@id='txtPword']";
		input4[1]="Admin";
		SeleniumOperations.SendTextOnUI(input4);
		Thread.sleep(3000);		

		//ClickOnLogin
		Object[] input5 = new Object[1];
		input5[0]="//*[@id='login']";
		SeleniumOperations.ClickOnElment(input5);
		Thread.sleep(3000);
				
		//ClickOnBranches
		Object[] input6 = new Object[1];
		input6[0]="(//*[@width='132'])[1]";
		SeleniumOperations.ClickOnElment(input6);
		Thread.sleep(3000);

		//Select Country
		Object[] input7 = new Object[2];
		input7[0]="//*[@name='lst_countryS']";
		input7[1]="INDIA";
		SeleniumOperations.SelectElement(input7);
		Thread.sleep(3000);		
		
		//Select State
		Object[] input8 = new Object[2];
		input8[0]="//*[@name='lst_stateS']";
		input8[1]="Andhra Pradesh";
		SeleniumOperations.SelectElement(input8);
		Thread.sleep(3000);		
		
		//Select City
		Object[] input9 = new Object[2];
		input9[0]="//*[@name='lst_cityS']";
		input9[1]="Hyderabad";
		SeleniumOperations.SelectElement(input9);
		Thread.sleep(3000);		
		
		//ClickOn Search
		Object[] input10 = new Object[1];
		input10[0]="//*[@id='btn_search']";
		SeleniumOperations.ClickOnElment(input10);
		Thread.sleep(3000);
		
		//Validation 
		Object[] input11 = new Object[1];
		input11[0]="//*[@id='lab19']";
		SeleniumOperations.ClickOnElment(input11);
		Thread.sleep(3000);
	}
}