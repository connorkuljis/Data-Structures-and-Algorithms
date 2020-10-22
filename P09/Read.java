import java.util.*;
import java.io.*;

class Read
{
    public static int[] readInts(String inFilename)
    {
	FileInputStream fileStrm = null;
	InputStreamReader rdr;
	BufferedReader bufRdr;
	int lineNum;
	String line;
	int[] intArray = null;

	try {
	    // Reading the file first to get accurate size
	    intArray = new int[getNumRows(inFilename)]; 

	    fileStrm = new FileInputStream(inFilename);
	    rdr = new InputStreamReader(fileStrm);
	    bufRdr = new BufferedReader(rdr);

	    lineNum = 0;
	    line = bufRdr.readLine();
	    while(line != null)
	    {
		lineNum++;
		intArray[lineNum - 1] = processInts(line);
		line = bufRdr.readLine();
	    }
	    fileStrm.close();
	}
	catch (IOException e)
	{
	    if (fileStrm != null)
	    {
		try
		{
		    fileStrm.close();
		}
		catch (IOException ex2) {}
	    }
	    System.out.println("Error in file processing: " + e.getMessage()); 
	}
	 return intArray;
    }
    

    public static Person[] readNames(String inFilename)
    {
	FileInputStream fileStrm = null;
	InputStreamReader rdr;
	BufferedReader bufRdr;
	int lineNum;
	String line;
	Person[] personArray = null;

	try {
	    // Reading the file first to get accurate size
	    personArray = new Person[getNumRows(inFilename)]; 

	    fileStrm = new FileInputStream(inFilename);
	    rdr = new InputStreamReader(fileStrm);
	    bufRdr = new BufferedReader(rdr);

	    lineNum = 0;
	    line = bufRdr.readLine();
	    while(line != null)
	    {
		lineNum++;
		personArray[lineNum - 1] = processLine(line);
		line = bufRdr.readLine();
	    }
	    fileStrm.close();
	}
	catch (IOException e)
	{
	    if (fileStrm != null)
	    {
		try
		{
		    fileStrm.close();
		}
		catch (IOException ex2) {}
	    }
	    System.out.println("Error in file processing: " + e.getMessage()); 
	}
	 return personArray;
    }
     
    private static Person processLine(String csvRow)
    {
	String thisToken = null;
	
	String[] tokens = csvRow.split(",");

	int ID = Integer.parseInt((tokens[0]));
	String name = tokens[1];

	Person temp = new Person(ID, name);
	
	return temp;
    }

    private static int processInts(String csvRow)
    {
	String thisToken = null;
	
	String[] tokens = csvRow.split(",");

	int value = Integer.parseInt((tokens[0]));

	return value;
    }

    private static int getNumRows(String fileName) throws IOException 
    {
        int lineNum = 0;
        String line = "";
        FileInputStream fileStream = new FileInputStream(fileName);
        InputStreamReader reader = new InputStreamReader(fileStream);
        BufferedReader bufReader = new BufferedReader(reader);
        line = bufReader.readLine();
        while(line != null)
        {
            lineNum++;
            line = bufReader.readLine();
        }
        fileStream.close();
        return lineNum;
    }

    public static void writeFile(Person[] A, String target) throws Exception
    {
	java.io.File file = new java.io.File(target);
	if (file.exists())
	{
	    System.out.println("File already exists"); 
	}
	else
	{
	    java.io.PrintWriter output = new java.io.PrintWriter(file);

	    for (int i = 0; i < A.length; i++)
	    {
		output.println(A[i]);
	    }
	    output.close();
	}
    }
}
