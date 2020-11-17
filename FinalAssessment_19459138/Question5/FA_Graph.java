/**
 * DSA Final Assessment Question 5 - FA_Graph.java                             4
 *
 * Name : 
 * ID   :
 *
 **/
import java.util.*;

public class FA_Graph 
{
    private FA_LinkedList vertices;
    private int vertexCount;
    private int edgeCount;

    public FA_Graph() 
    {
        vertices = new FA_LinkedList();
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

    public void addEdge(String label1, String label2)
    {
        FA_GraphVertex v1, v2; 
        
        v1 = getVertex(label1); 
        v2 = getVertex(label2);   

        v1.addEdge(v2); 

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
		System.out.println("Adjacency List display");
		// put your code here
    }

}  
