/**
 * DSA Final Assessment Question 5 - FA_Graph.java                             4
 *
 * Name : Connor Kuljis
 * ID   : 19459138
 *
 **/
import java.util.*;

public class FA_Graph 
{
    private FA_LinkedList vertices;
    private FA_LinkedList edges;
    private int vertexCount;
    private int edgeCount;

    public FA_Graph() 
    {
        vertices = new FA_LinkedList();
        edges = new FA_LinkedList();
        vertexCount = 0;
        edgeCount = 0;
    }

    public void addVertex(String label, Object value) 
    {
        FA_GraphVertex vertex = new FA_GraphVertex(label, value); 
        if (!(hasVertex(label))) 
        {
            vertices.insertLast(vertex);
            vertexCount++;
        }
    }

    public void addEdge(String label1, String label2, int weight)
    {
        FA_GraphVertex v1, v2; 
        
        v1 = getVertex(label1); 
        v2 = getVertex(label2);   

	String label = "(" + label1 + "," + label2 + ")";
	FA_GraphEdge edge = new FA_GraphEdge(v1, v2, label, weight);

	edges.insertLast(edge);
	v1.addEdge(edge); // try this maybe

        edgeCount++;
    }

    public boolean hasVertex(String label) 
    {
        boolean has = false;
        for (Object v : vertices) 
        {
		   FA_GraphVertex vg = (FA_GraphVertex) v;
           if (vg.getLabel().equals(label))
			   has = true;
        }
        return has;
    }

    public FA_GraphVertex getVertex(String label) 
    {
        FA_GraphVertex theVertex = null;
        for (Object v : vertices) 
        {
		   FA_GraphVertex vg = (FA_GraphVertex) v;
           if (vg.getLabel().equals(label))
			   theVertex = vg;
        }
		return theVertex;    
    }

    public void displayAsList() 
    {
	System.out.println("\n*** DISPLAY AS LIST ***\n");
	for (Object v : vertices)
	{
	    FA_GraphVertex vertex = (FA_GraphVertex) v;

	    FA_LinkedList links = vertex.getLinks();

	    if(!links.isEmpty())
	    {
		System.out.print(vertex.getLabel() + " | " ); 
		for (Object g : links)
		{
		    FA_GraphEdge edge = (FA_GraphEdge) g;
		    System.out.print(edge + " "); 
		}
		System.out.println(""); 
	    }
	}
    }

    public void displayAsMatrix()
    {
	System.out.println("\n***DISPLAY AS MATRIX***\n"); 
	// print column headings 
	System.out.print("\t"); 
	for (Object v : vertices)
	{
	    FA_GraphVertex vertex = (FA_GraphVertex) v;
	    System.out.print(vertex.getLabel() + "\t"); 
	}
	System.out.println(""); 
	// end heading
	
	// print adjusted size ruler
	for(int i = 0; i < vertices.getSize(); i++)
	{
	    System.out.print("========"); 
	}
	System.out.println(""); 
	// end ruler

	for (Object v : vertices) // for every vertex (eg row)
	{
	    FA_GraphVertex vertex = (FA_GraphVertex) v;
	    System.out.print(vertex.getLabel() + "\t|"); // print the label
	    for(Object e : vertex.getLinks()) // for every edge in the list
	    {
		FA_GraphEdge edge = (FA_GraphEdge) e; 
		for (Object vx : vertices)  // for every vertex in the edge
		{
		    FA_GraphVertex cmpvertex = (FA_GraphVertex) vx;
		    // if the vertex in the edge matches the current vertex
		    if (((edge.getTo().getLabel()).equals(cmpvertex.getLabel()))) 
		    {
			System.out.print("1\t");  // print a match
		    }
		    else
		    {
			System.out.print("0\t");  // just print a zero
		    }
		}
	    }
	    System.out.println(""); 
	}
    }  

    public void displayWeightMatrix() // same structure as display as matrix method
    {
	System.out.println("\n***DISPLAY WEIGHT MATRIX***\n"); 
	System.out.print("\t"); 
	for (Object v : vertices)
	{
	    FA_GraphVertex vertex = (FA_GraphVertex) v;
	    System.out.print(vertex.getLabel() + "\t"); 
	}
	System.out.println(""); 
	for(int i = 0; i < vertices.getSize(); i++)
	{
	    System.out.print("========"); 
	}
	System.out.println(""); 

	for (Object v : vertices)
	{
	    FA_GraphVertex vertex = (FA_GraphVertex) v;
	    System.out.print(vertex.getLabel() + "\t|"); 
	    for(Object e : vertex.getLinks())
	    {
		FA_GraphEdge edge = (FA_GraphEdge) e;
		for (Object vx : vertices)
		{
		    FA_GraphVertex cmpvertex = (FA_GraphVertex) vx;
		    if (((edge.getTo().getLabel()).equals(cmpvertex.getLabel())))
		    {
			System.out.print(edge.getValue() + "\t");  // only difference, just print the weight here instead
		    }
		    else
		    {
			System.out.print("0\t"); 
		    }
		}
	    }
	    System.out.println(""); 
	}
    }  
}
