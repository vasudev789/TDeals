package ApiBDD;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PutReqRes 
{
	String URL;
	String Endpoint;
	Response response;
	String Payload="{\"name\":\"GeorgeoBasarie\"}";
	
	@Given("^User selects the URL for put \"([^\"]*)\"$")
	public void user_selects_the_URL_for_put(String url) throws Throwable 
	{
		URL=url;
	}

	@Given("^User selects the EndPoint for put \"([^\"]*)\"$")
	public void user_selects_the_EndPoint_for_put(String endpoint) throws Throwable
	{
		Endpoint=URL+endpoint;
		System.out.println(" The endpoint = "+Endpoint);
	}

	@Given("^user Hits the Endpoint that is PUT Method with request body$")
	public void user_Hits_the_Endpoint_that_is_PUT_Method_with_request_body() throws Throwable 
	{
		response=(Response) RestAssured.given().header("Content-Type","application/json").body(Payload).when().put(Endpoint);
	}

	@Then("^user validates the status code as \"([^\"]*)\" and name feild as \"([^\"]*)\"$")
	public void user_validates_the_status_code_as_and_name_feild_as(String statucode, String expectedname) throws Throwable
	{
		int statusCode =Integer.parseInt(statucode);
		JsonPath jsonExtractor = response.jsonPath();
		String actualname =jsonExtractor.getString("name");
		System.out.println(" The Expected name is = "+expectedname+ " \n The actual Name = "+actualname);
		Assert.assertEquals(expectedname, actualname);
		Assert.assertEquals(statusCode, response.getStatusCode());
	}


}
