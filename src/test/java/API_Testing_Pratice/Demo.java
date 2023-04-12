package API_Testing_Pratice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.Scanner;
class Emp
{
	int eid;
	String ename;
	Emp(int eid,String ename)
	{
		this.eid=eid;
		this.ename=ename;
	}
}
class Student
{
	int sid;
	String sname;
	Student(int sid,String sname)
	{
		this.sid=sid;
		this.sname=sname;
	}
}
public class Demo 
{
	public static void main(String[] args)
	{
       System.out.println(" -- Program to convert arrays to Arraylist -- ");
       String names[] = {"Alex","Brenden","Chris","Domnic","Eric"};
       ArrayList<String> al =new ArrayList<String>(Arrays.asList(names));
       System.out.println(" -- Printing array list now -- ");
       for(String s:al)
       {
    	   System.out.println(" "+s);
       }
       System.out.println(" -- Now Conversion of Arraylist to Array ");
       String newNames[]= new String[al.size()];
       al.toArray(newNames);
       for(int i=0;i<newNames.length;i++)
       {
    	   System.out.println(" "+newNames[i]);
       }
       System.out.println(" -- Conversion of normal collections to arrays ");
       ArrayList al2 =new ArrayList();
       al2.add(10);
       al2.add(" vasudev ");
       al2.add(" hallur ");
       al2.add(91000);
       Object[] o =new Object[al.size()];
       al2.toArray(o);
       for(Object i:o)
       {
    	   System.out.println(" "+i);
       }
       
	}

}
