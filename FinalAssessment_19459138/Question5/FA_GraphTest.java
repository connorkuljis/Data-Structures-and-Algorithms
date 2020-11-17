/**
 * DSA Final Assessment Question 5 - GraphTest.java
 *
 * Name : 
 * ID   :
 *
 **/
import java.util.*;
import java.io.*;

public class FA_GraphTest
{
    public static void main(String args[])
    {
	System.out.println("\n**** Question 5: Testing Graphs ****\n");

	
	/*
	g.addVertex("one", 1);
	g.addVertex("two", 2);
	g.addVertex("three", 3);
	g.addVertex("four", 4);
	
	g.addEdge("one", "two", 1);
	g.addEdge("one", "three", 3);
	g.addEdge("one", "four", 4);
	g.addEdge("four", "two", 5);
	g.addEdge("four", "three", 7);
	*/

	// put your code here

	String filename = "FA_GraphData.txt";
	FA_Graph g = readGraph(filename);
	
	g.displayAsList();
	g.displayAsMatrix();
	g.displayWeightMatrix();
	
	System.out.println("\n**** Tests Complete ****\n");

    }

    // reference code taken from P06/FileIO.java
   public static FA_Graph readGraph(String inFilename)
    {
	FA_Graph theGraph = new FA_Graph();

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

    // reference code taken from P06/FileIO.java
    public static void processLine(String row, FA_Graph theGraph)
    {
	String[] strArr = row.split(" ");
	try
	{
	    String v1 = strArr[0];
	    String v2 = strArr[1];
	    int weight = Integer.parseInt(strArr[2]);

	    if  (!theGraph.hasVertex(v1)) // if the graph does not have a vertex
	    {
		theGraph.addVertex(v1, null);
	    }
	    if  (!theGraph.hasVertex(v2))
	    {
		theGraph.addVertex(v2, null);
	    }

	    theGraph.addEdge(v1,v2,weight); // finally add the Edge

	}
	catch (IllegalArgumentException e)
	{
	    System.out.println("Error trying to process line"); 

	}
    } 
	
}
