package CoreJavaPratice;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import Utilities.ExcelUtilities;

public class ReadingExcelHashmap 
{
	public static void main(String[] args) throws IOException 
	{
       System.out.println("--- Reading Excel sheet and storing it in hashmap --- ");
       HashMap<String, String> hm =ExcelUtilities.getMapData();
       for(Entry<String, String> en:hm.entrySet())
       {
    	   System.out.println(en.getKey()+" = "+en.getValue());
       }
       //https://mail.rediff.com/cgi-bin/login.cgi

	}
}
