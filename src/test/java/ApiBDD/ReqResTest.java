package ApiBDD;

import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;

import com.jayway.restassured.RestAssured;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReqResTest 
{
	Response response;
	String url="";
	String pathPra="";
	String EndPoint;
	String actualResponseData;
	@Given("^PSU login to website \"([^\"]*)\"$")
	public void psu_login_to_website(String URL) throws Throwable 
	{
		url=URL;
		System.out.println(" URl = "+URL);
	}

	@Given("^PSU sends the GET Method request with end point \"([^\"]*)\"$")
	public void psu_sends_the_GET_Method_request_with_end_point(String Pathparam) throws Throwable 
	{
		pathPra=Pathparam;
		EndPoint=url+pathPra;
		System.out.println(" The End point = "+EndPoint);
		response=io.restassured.RestAssured.get(EndPoint);
	}

	@Then("^the Http Method should be \"([^\"]*)\" ok$")
	public void the_Http_Method_should_be_ok(String acceptedSatusCode) throws Throwable 
	{
		Integer acceptedhttpCode = Integer.parseInt(acceptedSatusCode);
		Integer actualSatusCode= response.getStatusCode();
		System.out.println(" Actual Status code = "+actualSatusCode);
		System.out.println(" Accetped Integer code is = "+acceptedhttpCode);
		Assert.assertEquals(acceptedhttpCode, actualSatusCode);
	}

	@Then("^validte the URL response data as for \"([^\"]*)\"$")
	public void validte_the_URL_response_data_as_for(String ExpectedData) throws Throwable
	{
		System.out.println(" Expected data = "+ExpectedData);
		JsonPath jsonExtractor = response.jsonPath();
		Map<Object, Object> getmap =jsonExtractor.getMap("support");
		String actualdata =jsonExtractor.getString("support.text");
		System.out.println(" Actual Response Data = "+actualdata);
		for(Entry<Object, Object> en:getmap.entrySet())
		{
			//System.out.println(en.getKey()+" : "+en.getValue());
		}
		Assert.assertEquals(ExpectedData, actualdata);
	}


}
