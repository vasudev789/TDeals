package API_Testing_Pratice;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class TestApi 
{

	public static void main(String[] args) 
	{
		TestApi tr=new TestApi();
		tr.Tescase1();
		System.out.println(" Hi");
	}
	public void Tescase1()
	{
		//Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		Response response= RestAssured.get("https://reqres.in/api/users?page=2");
		response.getStatusCode();
		System.out.println(response.asString());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
	}
}
