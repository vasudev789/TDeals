package CoreJavaPratice;

import java.util.Scanner;

public class ArrayProgram {

	public static void main(String[] args)
	{
		System.out.println(" -- Program on array concept --");
	       System.out.println("-- Enter the size of the array -- ");
	       Scanner sc =new Scanner(System.in);
	       int size =sc.nextInt();
	       int a[] =new int[size];
	       System.out.println("-- Enter the elements of the array ");
	       for(int i=0;i<a.length;i++)
	       {
	    	   a[i]=sc.nextInt();
	       }
	       System.out.println("-- Printing the elements of the array -- ");
	       System.out.println();
	       for(int i=0;i<a.length;i++)
	       {
	    	   System.out.print(" "+a[i]);
	       }
	       System.out.println();
	       System.out.println("-- Printing the elements in the reverse order -- ");
	       System.out.println();
	       for(int i=a.length-1;i>=0;i--)
	       {
	    	   System.out.println(" "+a[i]);
	       }
	}

}
