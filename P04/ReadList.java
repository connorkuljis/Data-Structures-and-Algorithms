import java.util.*;
import java.io.*;

public class ReadList
{
    public static DSALinkedList readInts(String inFilename)
    {
	FileInputStream fileStrm = null;
	InputStreamReader rdr;
	BufferedReader bufRdr;
	String line;
	// int[] intArray = null;
	DSALinkedList list = new DSALinkedList();

	try {
	    fileStrm = new FileInputStream(inFilename);
	    rdr = new InputStreamReader(fileStrm);
	    bufRdr = new BufferedReader(rdr);

	    line = bufRdr.readLine();
	    while(line != null)
	    {
		processIntsIntoList(line, list);
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
	return list;
    }

    public static void processIntsIntoList(String csvRow, DSALinkedList list)
    {
	String[] strArr = csvRow.split(",");
	for (int i = 0; i < strArr.length; i++)
	{
	    try
	    {
		list.insertLast(Integer.parseInt(strArr[i]));
	    }
	    catch (NumberFormatException e)
	    {
		System.out.println("skipping."); 
	    }
	}
    }

    public static void writeFile(DSALinkedList list, String target) throws Exception
    {
	java.io.File file = new java.io.File(target);
	if (file.exists())
	{
	    throw new Exception("File already exists");
	}
	else
	{
	    java.io.PrintWriter output = new java.io.PrintWriter(file);

	    for (Object e : list)
	    {
		output.print(e + ",");
	    }
	    output.close();
	}

    }
}
