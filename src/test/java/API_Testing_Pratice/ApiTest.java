package API_Testing_Pratice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;

import com.jayway.restassured.path.json.JsonPath;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class ApiTest 
{
	HashMap<String, String> hm =new HashMap<String, String>();
	public static void main(String[] args) 
	{
		ApiTest  tr=new ApiTest();
		tr.Tescase1();
	}
	public void Tescase1()
	{
		Response response= RestAssured.get("https://reqres.in/api/users?page=2");
		response.getStatusCode();
		System.out.println(response.asString());
		System.out.println("Status code is = "+response.getStatusCode());
		System.out.println(" Fetching single values from response body ");
		io.restassured.path.json.JsonPath jsonpathEvalutor= response.jsonPath();
		HashMap<Object, Object> hm2=(HashMap<Object, Object>) jsonpathEvalutor.getMap("support");
		for(Entry<Object, Object> en:hm2.entrySet())
		{
			System.out.println(en.getKey()+" : "+en.getKey());
		}
		System.out.println(" -- Printing response Headers -- ");
		Iterator<Header> itr= response.getHeaders().iterator();
		while(itr.hasNext())
		{
			Header h =itr.next();
			hm.put(h.getName(), h.getValue());
		}
		for(Entry<String, String> en:hm.entrySet())
		{
			System.out.println(en.getKey()+ " : "+en.getValue());
		}
	}
}
