package API_Testing_Pratice;

import java.util.ArrayList;
import static io.restassured.RestAssured.given;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;

import Pojo.MockTest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.bytebuddy.jar.asm.TypeReference;

public class JsonArrayResponse
{
	public static void main(String[] args) 
	{
	   MockTest mock[]= RestAssured.get("https://run.mocky.io/v3/ac71d84a-ee94-4a42-a68a-ba57de0e1d82").as(MockTest[].class);
	   int i =mock.length;
	   System.out.println(i);
	   System.out.println("-------------------------------");
	  
	   for(MockTest itr:mock)
	   {
		   System.out.println(" value of name = "+itr.getName());
		   System.out.println(" id Gear name = "+itr.getIdGear());
		   System.out.println(" year is = "+itr.getYear());
		   System.out.println(" Price is = "+itr.getPrice());
		   System.out.println("----------------------------");
	   }
	}
}
