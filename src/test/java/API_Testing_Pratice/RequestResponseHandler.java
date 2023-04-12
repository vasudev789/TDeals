package API_Testing_Pratice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import jxl.Sheet;
import jxl.Workbook;

public class RequestResponseHandler 
{
    String payload="Payload1";
    static String excelFilePath="\\PISP File Payment Bizint\\FilePaymentConsentROIBOL\\FilePaymentConsentsROIBOL.xls";
    static String outputFilePath="\\PISP File Payment Bizint\\FilePaymentConsentROIBOL\\FilePaymentConsentsROIBOL.txt";
    static String inputFilePath="\\PISP File Payment Bizint\\FilePaymentConsentROIBOL\\FilePaymentConsentsROIBOL.txt";
	public static void main(String[] args) 
	{
		String reqpayload=returnInputPayloadwithList("Payload1", excelFilePath, inputFilePath, outputFilePath, "DATA");
		System.out.println(" The payload obtained is = \n"+reqpayload);
	}
    public static String returnInputPayloadwithList(String payload,String excelFilePath,String inputFilePath,String outputFilePath,String sheet)
    {
    	System.getProperty("user.dir");
    	System.out.println(" The user directory is = "+System.getProperty("user.dir"));
    	Workbook tcworkBook;
    	
    	String outputFileName="";
    	String constantPath="\\src\\test\\resources\\Payload";
    	String excelPath=constantPath+excelFilePath;
    	System.out.println("Excel filepath = "+excelFilePath);
    	if((sheet=="DATA")||(sheet=="LIST"))
    	{
    		outputFileName=constantPath+inputFilePath;
    	}
    	else if(sheet=="RESPONSE")
    	{
    		outputFileName=constantPath+outputFilePath;
    	}
    	else
    	{
    		System.out.println(" ERROR: Sheet name provided is "+sheet+" should be DATA OR RESPONSE");
    	}
    	String sheet_Path=System.getProperty("user.dir")+excelPath;
    	String outfilepath=System.getProperty("user.dir")+outputFileName;
    	System.out.println("Sheet path = "+sheet_Path);
    	System.out.println("outfile path = "+outfilepath);
    	
    	String key_Name="";
    	String requestPayload="";
    	try
    	{
    		File file1 =new File(sheet_Path);
    		tcworkBook =Workbook.getWorkbook(file1);
    		Sheet tcSheet =tcworkBook.getSheet(sheet);
    		System.out.println(tcSheet.getRows());
    		int key_nameReturns=0;
    		/* Reading the excel to get data*/
    		for(int row=1;row<tcSheet.getRows();row++)
    		{
    			key_Name=tcSheet.getCell(0, row).getContents();
    			if(payload.equalsIgnoreCase(key_Name))
    			{
    				key_nameReturns++;
    				String lines="";
    				String line;
    				/* Reading the JSON template from specified path */
    				try
    				{
    					File file = new File(outfilepath);
    					BufferedReader reader =new BufferedReader(new FileReader(file.toString()));
    					while((line=reader.readLine())!=null)
    					{
    						lines=lines+line;
    					}
    					reader.close();
    				}
    				catch (Exception e) 
    				{
    					
					}
    				lines=lines.trim().replaceAll("\\s", "");
    				// Inserting data in JSON Payload
    				for(int col=1;col<tcSheet.getColumns();col++)
    				{
    					String colHeader= tcSheet.getCell(col, 0).getContents();
    					String colHeaderVal="$-{"+colHeader+"}";
    					String colValue=tcSheet.getCell(col, row).getContents();
    					if(colValue.equalsIgnoreCase("NA"))
    					{
    						String testfield="\""+colHeader+"\""+":\""+colHeader+"\"";
    						if(lines.contains(testfield+","))
    						{
    							testfield=testfield+",";
    						}
    						else if(lines.contains(","+testfield))
    						{
    							testfield=testfield+",";
    							
    						}
    						lines= lines.replace(testfield,"");
    					}
    					else
    					{
    						lines= lines.replace(colHeaderVal, colValue);
    					}
    				}
    				if(key_nameReturns>1)
    					requestPayload=requestPayload+","+lines;
    					else
    						requestPayload=lines;
    				
    			}
    		}
    	}
    	catch (Exception e)
    	{
    		
		}
    	return requestPayload;
    }
}
