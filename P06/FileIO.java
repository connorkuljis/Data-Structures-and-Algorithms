import java.util.*;
import java.io.*;

public class FileIO
{
    public static DSAGraph readAL(String inFilename)
    {
	DSAGraph theGraph = new DSAGraph();

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
		processLine(line, theGraph);
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
	return theGraph;
    }

    public static void processLine(String row, DSAGraph theGraph)
    {
	String[] strArr = row.split(" ");
	try
	{
	    String v1 = strArr[0];
	    String v2 = strArr[1];
	    if (theGraph.isEmpty())
	    {
		theGraph.addVertex(v1, null);
		theGraph.addVertex(v2, null);
	    }
	    if  (!theGraph.hasVertex(v1)) // if the graph does not have a vertex
	    {
		theGraph.addVertex(v1, null);
	    }
	    if  (!theGraph.hasVertex(v2))
	    {
		theGraph.addVertex(v2, null);
	    }

	    theGraph.addEdge(v1,v2); // finally add the Edge

	}
	catch (IllegalArgumentException e)
	{
	    System.out.println("Error trying to process line"); 

	}
    }

    // public static void writeCSV(DSAQueue queue, String target) throws Exception
    // {
    //     java.io.File file = new java.io.File(target);
    //     if (file.exists())
    //     {
    //         throw new Exception("File already exists");
    //     }
    //     else
    //     {
    //         java.io.PrintWriter output = new java.io.PrintWriter(file);

    //         for (Object e : queue)
    //         {
    //     	output.print(e + ",");
    //     	output.println("");
    //         }
    //         output.close();
    //     }
    // }
}
