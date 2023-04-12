package ApiBDD;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.jayway.restassured.response.Response;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.Header;

public class HeaderValidation 
{
	io.restassured.response.Response response;
	RestAssured restassured;
	String URL;
	String Endpoint;
	String serverExpected;
	HashMap<String, String> responseHeader =new HashMap<String, String>();
	@Given("^user select the URL as \"([^\"]*)\"$")
	public void user_select_the_URL_as(String url) throws Throwable 
	{
		URL=url;
	}

	@Given("^user select the endpoint \"([^\"]*)\"$")
	public void user_select_the_endpoint(String endpoint) throws Throwable 
	{
		Endpoint=URL+endpoint;
	}

	@Given("^user sends the Get Method for endpoint$")
	public void user_sends_the_Get_Method_for_endpoint() throws Throwable
	{
		response=RestAssured.get(Endpoint);
		System.out.println(response.asString());
	}

	@Given("^user recives the http response with resposone Header$")
	public void user_recives_the_http_response_with_resposone_Header() throws Throwable
	{
		System.out.println("-- Printing the response Header -- ");
		Iterator<Header> itr= response.getHeaders().iterator();
		while(itr.hasNext())
		{
			Header header =itr.next();
			responseHeader.put(header.getName(), header.getValue());
		}
		for(Map.Entry<String, String> en:responseHeader.entrySet())
		{
			System.out.println(en.getKey()+" : "+en.getValue());
		}
	}

	@Then("^user valiadtes the response header  value \"([^\"]*)\"$")
	public void user_valiadtes_the_response_header_value(String serverValue) throws Throwable
	{
		serverExpected=response.getHeader(serverValue);
		System.out.println(" The actual Value = "+serverValue);
		System.out.println(" The Expected Value = "+serverExpected);
	}

	@Then("^user validates the response header value \"([^\"]*)\"$")
	public void user_validates_the_response_header_value(String arg1) throws Throwable 
	{
		
	}



}
