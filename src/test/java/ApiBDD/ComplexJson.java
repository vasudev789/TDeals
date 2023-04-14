package ApiBDD;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ComplexJson
{
	public static void main(String[] args) 
	{
       Response response =RestAssured.get("https://www.googleapis.com/books/v1/volumes?q=turing");
       System.out.println("-----------Printing Json Response --------------------\n"+response.asString());
	}
}
