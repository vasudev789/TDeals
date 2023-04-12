package API_Testing_Pratice;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.jayway.restassured.internal.assertion.GetAtPathFragmentEscaper;
import com.jayway.restassured.path.json.JsonPath;
public class ApiPratice 
{
	static HashMap<String, String> _requestHeader =new HashMap<String, String>();
	static String _responseString;
	public static void main(String[] args) 
	{
		TestcaseGetReq();
	}
	public static void TestcaseGetReq()
	{
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		response.getStatusCode();
		_responseString= response.asString();
		System.out.println(" Response String = "+response.asString());
		System.out.println(" Response body = "+response.getBody());
		System.out.println(" Response Header = "+response.getHeader("content-type"));
		System.out.println(" Response Time = "+response.getTime());
		System.out.println("-------------------------------------");
		Iterator<Header> itr =response.getHeaders().iterator();
		while(itr.hasNext())
		{
			Header header =itr.next();
			_requestHeader.put(header.getName(), header.getValue());
		}
		System.out.println("---------- Printing response Header -----------");
		for(Map.Entry<String, String> hm : _requestHeader.entrySet())
		{
			System.out.println(hm.getKey()+" : "+hm.getValue());
		}
		System.out.println("-------- Printing single value or field from Response Body -------");
		String s="page";
		JsonPath jsonpath =new JsonPath(_responseString);
		Integer extract =jsonpath.getInt(s);
		System.out.println("-----------Printing all emails-------------");
		System.out.println(" Extract value = "+extract );
		ArrayList<String> allemail =jsonpath.get("data.email");
		for(String m:allemail)
		{
			System.out.println(m);
		}
	}
    
}
