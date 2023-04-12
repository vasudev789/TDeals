package ApiBDD;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReqResFeildValidationPost 
{
	String URL;
	String Endpoint;
	Response response;
	String Payload="{\"name\":\"LeoNardo Da Vanci\",\"job\":\"Inventor\"}";
	@Given("^User select the website or URL as reqres \"([^\"]*)\"$")
	public void user_select_the_website_or_URL_as_reqres(String url) throws Throwable 
	{
		URL=url;
	}

	@Given("^User select the endpoint for reqres \"([^\"]*)\"$")
	public void user_select_the_endpoint_for_reqres(String endpoint) throws Throwable 
	{
		Endpoint=URL+endpoint;
		System.out.println("Endpoint = "+Endpoint);
	}

	@Given("^User Post the reqres with Payload$")
	public void user_Post_the_reqres_with_Payload() throws Throwable 
	{
		response=(Response) RestAssured.given().header("Content-Type","application/json").body(Payload).when().post(Endpoint);
		System.out.println(" The response payload is = \n "+response.asString());
	}

	@Then("^the payload should contain job field as \"([^\"]*)\"$")
	public void the_payload_should_contain_job_field_as(String expectedValue) throws Throwable 
	{
		JsonPath jsonpathEvalutor =response.jsonPath();
		String actualvalue= jsonpathEvalutor.getString("job");
		System.out.println(" The actual value is = "+actualvalue+" The expected value is = "+expectedValue);
		Assert.assertEquals(actualvalue, expectedValue);
	}



}
