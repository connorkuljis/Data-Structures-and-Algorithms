import java.util.*;
import java.io.*;

public class FileIO
{
    public static int getNumLines(String inFilename)
    {
	FileInputStream fileStrm = null;
	InputStreamReader rdr;
	BufferedReader bufRdr;
	String line;
	int numLines = 0;

	try {
	    fileStrm = new FileInputStream(inFilename);
	    rdr = new InputStreamReader(fileStrm);
	    bufRdr = new BufferedReader(rdr);

	    line = bufRdr.readLine();
	    while(line != null)
	    {
		numLines++;
		line = bufRdr.readLine(); // moves to the next line
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
	return numLines;
    }

    public static DSAHeapEntry[] createArray(String inFilename)
    {
	FileInputStream fileStrm = null;
	InputStreamReader rdr;
	BufferedReader bufRdr;
	String line;

	int lineNum = 0;
	int size = getNumLines(inFilename);
	DSAHeapEntry[] heapArr = new DSAHeapEntry[size];

	try {
	    fileStrm = new FileInputStream(inFilename);
	    rdr = new InputStreamReader(fileStrm);
	    bufRdr = new BufferedReader(rdr);

	    line = bufRdr.readLine();
	    while(line != null)
	    {
		processLine(line, heapArr, lineNum);
		lineNum++;
		line = bufRdr.readLine(); // moves to the next line
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
	return heapArr;
    }

    public static void processLine(String row, DSAHeapEntry[] heapArr, int lineNum)
    {
	try
	{
	    String[] strArr = row.split(",");
	    String name  = strArr[1];
	    int priority  = Integer.parseInt(strArr[0]);
	    heapArr[lineNum] = new DSAHeapEntry(priority, name);
	}
	catch (IllegalArgumentException e)
	{
	    System.out.println("Error trying to process line"); 
	}
    }
}
