package ApiBDD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReqResGetEmail
{
	Response response;
	String URL;
	String Endpoint;
	ArrayList<String> email_ids =new ArrayList<String>();
	HashMap<Object, Object> hm=new HashMap<Object, Object>();
	String actualEmail="";
	@Given("^User select website  Reqres as URL \"([^\"]*)\"$")
	public void user_select_website_Reqres_as_URL(String url) throws Throwable
	{
		URL=url;
	}

	@Given("^User selects the enpdoint for Reqres \"([^\"]*)\"$")
	public void user_selects_the_enpdoint_for_Reqres(String endpoint) throws Throwable 
	{
		Endpoint=URL+endpoint;
	}
	@Given("^User sends the Get Method for Reqres API$")
	public void user_sends_the_Get_Method_for_Reqres_API() throws Throwable 
	{
		response=RestAssured.get(Endpoint);
		System.out.println(" The extracted response is = "+response.asString());
	}

	@Given("^User Prints all the Email from response body$")
	public void user_Prints_all_the_Email_from_response_body() throws Throwable 
	{
		JsonPath jsonpathEvalutor =response.jsonPath();
		String accetpedEmail =jsonpathEvalutor.getString("data[6].email");
		System.out.println("----------------------------");
		System.out.println("Accetpted Email = "+accetpedEmail);
		
		//System.out.println(" Email = "+email);
		email_ids =jsonpathEvalutor.get("data.email");
		for(String emails:email_ids)
		{
			System.out.print("    "+emails);
		}
	
	}

	@Then("^User Validates the Email value \"([^\"]*)\"$")
	public void user_Validates_the_Email_value(String expectedEmail) throws Throwable
	{
		for(String e:email_ids)
		{
			if(e.equalsIgnoreCase(expectedEmail))
			{
				actualEmail=actualEmail+expectedEmail;
			}
		}
		System.out.println();
		System.out.println(" The actual Email = "+actualEmail);
		Assert.assertEquals(expectedEmail, actualEmail);
	}


}
