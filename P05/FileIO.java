import java.util.*;
import java.io.*;

public class FileIO
{
    public static BinarySearchTree readCSV(String inFilename)
    {
	BinarySearchTree tree = new BinarySearchTree();

	FileInputStream fileStrm = null;
	InputStreamReader rdr;
	BufferedReader bufRdr;
	String line;

	try {
	    fileStrm = new FileInputStream(inFilename);
	    rdr = new InputStreamReader(fileStrm);
	    bufRdr = new BufferedReader(rdr);

	    line = bufRdr.readLine();
	    while(line != null)
	    {
		processLine(line, tree);
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
	return tree;
    }

    public static void processLine(String csvRow, BinarySearchTree tree)
    {
	String[] strArr = csvRow.split(",");
	for (int i = 0; i < strArr.length; i++)
	{
	    try
	    {
		String id = strArr[0];
		String name = strArr[1];
		tree.insert(id, name);
	    }
	    catch (NumberFormatException e)
	    {
		System.out.println("skipping."); 
	    }
	    catch (IllegalArgumentException e)
	    {

	    }
	}
    }

    public static void writeCSV(DSAQueue queue, String target) throws Exception
    {
	java.io.File file = new java.io.File(target);
	if (file.exists())
	{
	    throw new Exception("File already exists");
	}
	else
	{
	    java.io.PrintWriter output = new java.io.PrintWriter(file);

	    for (Object e : queue)
	    {
		output.print(e + ",");
		output.println("");
	    }
	    output.close();
	}
    }
}
