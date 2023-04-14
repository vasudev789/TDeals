package API_Testing_Pratice;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JsonArrayTest 
{
	public static void main(String[] args)
	{
       Response response =RestAssured.get("https://run.mocky.io/v3/c19e1a85-2579-4245-a153-cf15df0cc8de");
       List<String> jsonResponse= response.jsonPath().getList("username");
       System.out.println(jsonResponse);
	}

}
