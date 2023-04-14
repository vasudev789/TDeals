package API_Testing_Pratice;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JsonPathValidation 
{
	public static void main(String[] args)
	{
	  
       Response response =RestAssured.get("https://run.mocky.io/v3/b47acb82-8b9a-489d-8e79-a2f193b14f71");
       JsonPath jsonpath =new JsonPath(response.asString());
       int size =jsonpath.getInt("Location.size()");
       System.out.println(" -------------------------------------");
       System.out.println(" The size of location is = "+size);
       for(int i=0;i<size;i++)
       {
    	   String state =jsonpath.getString("Location["+i+"].State");
    	   String zip=   jsonpath.getString("Location["+i+"].zip");
    	   System.out.println(" The sates are = "+state);
    	   System.out.println(" The zipcodes are = "+zip);
       }
       System.out.println("-------------------------");
       System.out.println(" The satus code ="+response.getStatusCode());
	}
}
