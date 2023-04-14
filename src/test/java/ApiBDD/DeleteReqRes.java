package ApiBDD;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteReqRes 
{
	String URL;
	String EndPoint;
	Response response;
	@Given("^Users selects the URL as \"([^\"]*)\"$")
	public void users_selects_the_URL_as(String url) throws Throwable
	{
		URL=url;
	}
	@Given("^Users selects the Endpoint as \"([^\"]*)\"$")
	public void users_selects_the_Endpoint_as(String endpoint) throws Throwable 
	{
		EndPoint=URL+endpoint;
	}
	@Given("^User hits the Delete Endpoint$")
	public void user_hits_the_Delete_Endpoint() throws Throwable 
	{
		response=RestAssured.delete(EndPoint);
	}
	@Then("^User validates the \"([^\"]*)\"$")
	public void user_validates_the(String ExpectedHttpcode) throws Throwable
	{
		int expectedCode= Integer.parseInt(ExpectedHttpcode);
		int actualCode=response.getStatusCode();
		System.out.println(" The ExpectedCode = "+expectedCode+"\n  The Actual Code = "+actualCode);
		Assert.assertEquals(expectedCode, actualCode);
	}


}
