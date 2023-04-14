package CoreJavaPratice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import io.cucumber.java.sl.In;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import sun.security.util.Length;

public class Test
{
   public static void main(String[] args) 
   {
	   System.out.println("-- Program to find the largest among three numbers -- ");
	   System.out.println("-- Enter the size of the array --- ");
	   Scanner sc =new Scanner(System.in);
	   int size =sc.nextInt();
	   int arr[]= new int[size];
	   int a=0;
	   int b=0;
	   int c=0;
	   if(arr.length<=3)
	   {
		   System.out.println(" Please enter the three numbers ");
		   for(int i=0;i<arr.length;i++)
		   {
			   arr[i]=sc.nextInt();
			   a=arr[0];
			   b=arr[1];
			   c=arr[2];
		   }
		   System.out.println(" The value of a = "+a+" \n The value of b = "+b+" \n The vaule of c = " +c);
		   if(a>b&&a>c)
		   {
			   System.out.println(" The largest value = "+a);
		   }
		   else if(b>c&&b>a)
		   {
			   System.out.println(" The largest value = "+b);
		   }
		   else if(c>b&&c>a)
		   {
			   System.out.println(" The largest value = "+c);
		   }
	   }
	   else
	   {
		   System.out.println(" -- Please enter the number with in 3 ---- ");
	   }
   }
   
}
   

