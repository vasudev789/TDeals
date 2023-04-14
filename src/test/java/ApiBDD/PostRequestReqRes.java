package ApiBDD;



import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PostRequestReqRes 
{
	String URL;
	String Endpoint;
	Response response;
	String Payload="{\r\n" + 
			"    \"name\": \"Rosco\",\r\n" + 
			"    \"job\": \"Teacher\"\r\n" + 
			"}";
	
	@Given("^user uses the reqres website \"([^\"]*)\"$")
	public void user_uses_the_reqres_website(String url) throws Throwable 
	{
		URL=url;
	}

	@Given("^user decides the endpoint to hit \"([^\"]*)\"$")
	public void user_decides_the_endpoint_to_hit(String endpoint) throws Throwable
	{
		Endpoint=URL+endpoint;
		System.out.println(" Endpoint = "+Endpoint);
	}

	@Given("^User stores the payload in string_format$")
	public void user_stores_the_payload_in_string_format() throws Throwable
	{
		System.out.println("-- Payload is = --\n"+Payload);
	}

	@Given("^User hits Post_Method with payload$")
	public void user_hits_Post_Method_with_payload() throws Throwable 
	{
		
		//response=(Response) RestAssured.given().log().all().header("Content-Type","application/json").body(Payload).when().post(Endpoint);
		response=(Response) RestAssured.given().header("Content-Type","application/json").body(Payload).when().post(Endpoint);
		System.out.println("------------------ ");
		System.out.println(" -- The response Payload is = "+response.asString());
	}

	@Then("^the status code should be as \"([^\"]*)\"$")
	public void the_status_code_should_be_as(String statuscode) throws Throwable 
	{
		int actualstatuscode =Integer.parseInt(statuscode);
		System.out.println(" The Actual status code is = "+actualstatuscode);
		int expectedStatusCode =response.getStatusCode();
		System.out.println(" The Expected status code = "+expectedStatusCode);
		Assert.assertEquals(actualstatuscode, expectedStatusCode);

	}


}
