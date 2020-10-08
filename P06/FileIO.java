import java.util.*;
import java.io.*;

public class FileIO
{
    public static void main(String[] args)
    {
	// define the names
	final String file1 = "prac6_1.al";
	final String file2 = "prac6_2.al";

	// read the graph from the filenames
	DSAGraph graph1 = readAL(file1);
	DSAGraph graph2 = readAL(file2);

	System.out.println(file1); 
	// display the first graph
	graph1.displayAdjacencyList();
	System.out.print("DFS : "); 
	displaySearch(graph1.depthFirstSearch());
	System.out.print("BFS : "); 
	displaySearch(graph1.breadthFirstSearch());
	// end 1

	System.out.println(""); 

	System.out.println(file2); 
	// display the second graph
	graph2.displayAdjacencyList();
	System.out.print("DFS : "); 
	displaySearch(graph2.depthFirstSearch());
	System.out.print("BFS : "); 
	displaySearch(graph2.breadthFirstSearch());
	// end 2
    }

    public static void displaySearch(DSAQueue traversalQueue)
    {
	for (Object e : traversalQueue) // each object is a vertex with a label
	{
	    System.out.print(((DSAGraphVertex)(e)).getLabel() + " "); 
	}
	System.out.println(""); 

    }

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
