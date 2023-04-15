package CoreJavaPratice;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class GitTest3
{

	public static void main(String[] args) 
	{
       System.out.println("-- Program on medplus discount calculaitons --- ");
       System.out.println("-- Enter the number of items -- ");
       Scanner sc =new Scanner(System.in);
       int n =sc.nextInt();
       double sum = 0;
       int i=1;
       while(n>=i)
       {
    	   System.out.println("-- Enter the price of "+i+" Product " );
    	   int prodPrice =sc.nextInt();
    	   sum=sum+prodPrice;
    	   i++;
       }
       System.out.println(" The total cost of medicine without discount is = "+sum);
       if(sum>=1000)
       {
    	   double dis1;
    	   dis1=(sum*20)/100;
    	   double finalprice =sum-dis1;
    	   System.out.println(" The medicine after discount is = "+finalprice);
       }
       
	}

}
