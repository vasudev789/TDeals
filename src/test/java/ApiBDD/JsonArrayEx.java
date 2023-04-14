package ApiBDD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JsonArrayEx 
{
	String URL;
	String Endpoint;
	List<Object> allEmp;
	Response response;
	String expectedName;
	ArrayList<Object> jsonArray;
	@Given("^Customer logs in to the website with URL as \"([^\"]*)\"$")
	public void customer_logs_in_to_the_website_with_URL_as(String url) throws Throwable 
	{
		URL=url;
		System.out.println(" The url is  = "+URL);
	}

	@Given("^Customer sends the Get Method with \"([^\"]*)\"$")
	public void customer_sends_the_Get_Method_with(String endpint) throws Throwable 
	{
		Endpoint=URL+endpint;
		System.out.println(" The Endpoint = "+Endpoint);
		response=RestAssured.get(Endpoint);
		allEmp=response.as(List.class);
	}

	@Then("^The http response code will be as \"([^\"]*)\"$")
	public void the_http_response_code_will_be_as(String statucode) throws Throwable 
	{
		int actualStatuCode =Integer.parseInt(statucode);
		int expectedStatusCode =response.getStatusCode();
		System.out.println(" Actual status code = "+actualStatuCode+" Expected status code = "+expectedStatusCode);
		Assert.assertEquals(expectedStatusCode, actualStatuCode);
	}

	@Then("^validate the name in response body as \"([^\"]*)\"$")
	public void validate_the_name_in_response_body_as(String name) throws Throwable 
	{
		System.out.println(" The size of JSON Array is = "+allEmp.size());
		jsonArray=new ArrayList<Object>(allEmp);
		System.out.println("--- Printing Json Array --- ");
		for(Object o:jsonArray)
		{
			System.out.println(" "+o);
		}
		System.out.println("--------- Getting Particular Index ------ ");
		System.out.println(jsonArray.get(0));
		if(jsonArray.contains(name))
		{
			System.out.println(" The value is present ");
		}
		System.out.println("---- Extracting single value from json array ----- ");
		
		ArrayList<Object> values =new ArrayList<Object>();
		for(int i=0;i<allEmp.size();i++)
		{
			Map<String, Object> hm =(HashMap<String, Object>)allEmp.get(i);
			for(Entry<String, Object> en:hm.entrySet())
			{
				values.add(en.getValue());
			}
		}
		System.out.println("--- Printing the arraylist objects --- ");
		for(Object s:values)
		{
			System.out.println(" "+s);
		}
		System.out.println("--- Adding single value to string ---");
		String s="";
		boolean b=false;
		if(values.contains(name))
		{
			System.out.println("--- True--- ");
			b=true;
		}
		else
		{
			b=false;
		}
		Assert.assertTrue(b);
	}


}
