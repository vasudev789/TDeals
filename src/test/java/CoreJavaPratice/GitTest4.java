package CoreJavaPratice;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class GitTest4
{
	public static void main(String[] args) 
	{
        System.out.println("-- Program to add two array list in Linked HashMap -- ");
        ArrayList<String> firstName =new ArrayList<>();
        ArrayList<String> lastName =new ArrayList<>();
        LinkedHashMap<String, String> lhm =new LinkedHashMap<>();
        firstName.add("Alex");
        firstName.add("Brenden");
        firstName.add("Chris");
        firstName.add("Domnic");
        
        lastName.add("Paul");
        lastName.add("Frazer");
        lastName.add("Wilson");
        lastName.add("Lobo");
        
        for(int i=0;i<firstName.size();i++)
        {
        	lhm.put(firstName.get(i), lastName.get(i));
        }
        System.out.println("-- Printing the key and value added from two array list --");
        for(Map.Entry<String, String> en:lhm.entrySet())
        {
        	System.out.println(" "+en.getKey()+" = "+en.getValue());
        }
	}
}
