package cucumbermap;

import java.util.Hashtable;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.HTMLReportGenerator;
import utility.SeleniumOperations;

public class Login 
{
	@Given ("^user open browser with \"(.*)\" exe$")
	public void bLaunch(String browser) throws Throwable
	{
		Object[] input = new Object[1];
		input[0]=browser;
		SeleniumOperations.BrowserLaunch(input);
		Thread.sleep(3000);
	}
	
	@Given ("^user enter url as$")
	public void OpenApplication() throws Throwable
	{
		SeleniumOperations.OpenApplication();
		Thread.sleep(3000);
	}
	@When("^User enter username as \"([^\"]*)\"$")
	public void user_enter_username_as(String userName) throws Throwable 
	{
		Object[] input3 = new Object[2];
		input3[0]="//*[@id='txtuId']";
		input3[1]=userName;
		Hashtable<String, Object> output3 =SeleniumOperations.SendTextOnUI(input3);
		HTMLReportGenerator.StepDetails(output3.get("STATUS").toString(), "^User enter username as \"([^\"]*)\"$", output3.get("MESSAGE").toString());
	}

	@When("^User enter Password as \"([^\"]*)\"$")
	public void user_enter_Password_as(String password) throws Throwable 
	{
		Object[] input4 = new Object[2];
		input4[0]="//*[@id='txtPword']";
		input4[1]=password;
		Hashtable<String, Object> output4 =SeleniumOperations.SendTextOnUI(input4);
		HTMLReportGenerator.StepDetails(output4.get("STATUS").toString(), "^User enter Password as \"([^\"]*)\"$", output4.get("MESSAGE").toString());
	}

	@When("^User click on login button$")
	public void user_click_on_login_button() throws Throwable 
	{
		Object[] input5 = new Object[1];
		input5[0]="//*[@id='login']";
		Hashtable<String, Object> output5 =SeleniumOperations.ClickOnElment(input5);
		HTMLReportGenerator.StepDetails(output5.get("STATUS").toString(), "^User click on login button$" , output5.get("MESSAGE").toString());
	}

	@When("^User click on Branches$")
	public void user_click_on_Branches() throws Throwable 
	{
		Object[] input6 = new Object[1];
		input6[0]="(//*[@width='132'])[1]";
		Hashtable<String, Object> output6 =SeleniumOperations.ClickOnElment(input6);
		HTMLReportGenerator.StepDetails(output6.get("STATUS").toString(), "^User click on Branches$" , output6.get("MESSAGE").toString());
	}

	@When("^User Select Country as \"([^\"]*)\"$")
	public void user_Select_Country_as(String country) throws Throwable 
	{
		Object[] input7 = new Object[2];
		input7[0]="//*[@name='lst_countryS']";
		input7[1]=country;
		Hashtable<String, Object> output7 =SeleniumOperations.SelectElement(input7);
		HTMLReportGenerator.StepDetails(output7.get("STATUS").toString(), "^User Select Country as \"([^\"]*)\"$" , output7.get("MESSAGE").toString());
	}

	@When("^User Select State as \"([^\"]*)\"$")
	public void user_Select_State_as(String State) throws Throwable 
	{
		Object[] input8 = new Object[2];
		input8[0]="//*[@name='lst_stateS']";
		input8[1]=State;
		Hashtable<String, Object> output8 =SeleniumOperations.SelectElement(input8);
		HTMLReportGenerator.StepDetails(output8.get("STATUS").toString(), "^User Select State as \"([^\"]*)\"$" , output8.get("MESSAGE").toString());
	}

	@When("^User Select city as \"([^\"]*)\"$")
	public void user_Select_city_as(String City) throws Throwable 
	{
		Object[] input9 = new Object[2];
		input9[0]="//*[@name='lst_cityS']";
		input9[1]=City;
		Hashtable<String, Object> output9 =SeleniumOperations.SelectElement(input9);
		HTMLReportGenerator.StepDetails(output9.get("STATUS").toString(), "^User Select city as \"([^\"]*)\"$" , output9.get("MESSAGE").toString());
	}

	@When("^User Clickon Search button$")
	public void user_Clickon_Search_button() throws Throwable 
	{
		Object[] input10 = new Object[1];
		input10[0]="//*[@id='btn_search']";
		Hashtable<String, Object> output10 =SeleniumOperations.ClickOnElment(input10);
		HTMLReportGenerator.StepDetails(output10.get("STATUS").toString(), "^User Clickon Search button$" , output10.get("MESSAGE").toString());
	}
	@Then ("^User find all branch in city$")
	public void User_find_all_branch_in_city() throws Throwable 
	{
		Object[] input11 = new Object[1];
		input11[0]="//*[@id='lab19']";
		Hashtable<String, Object> output11 =SeleniumOperations.Validation(input11);
		HTMLReportGenerator.StepDetails(output11.get("STATUS").toString(), "^User find all branch in city$" , output11.get("MESSAGE").toString());
	}
}