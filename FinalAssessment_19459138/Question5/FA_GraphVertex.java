/**
 * DSA Final Assessment Question 5 - FA_GraphVertex.java                             4
 *
 * Name : Connor Kuljis	
 * ID   : 19459138
 *
 **/
public class FA_GraphVertex {

        private String label;
        private Object value;
        private FA_LinkedList links; //list of links of vertices
        private boolean visited;

        public FA_GraphVertex(String inLabel, Object inValue) {

            links = new FA_LinkedList();
            label = inLabel;
            value = inValue;
        }

        public void addEdge(Object vertex) 
        {
            links.insertLast(vertex);   
        }

	// added method
	public FA_LinkedList getLinks()
	{
	    return links;
	}

        public String getLabel() 
        {
            return this.label;
        }

        public Object getValue() 
        {
            return this.value; 
        }
		
        public String toString() 
        {
            return this.getLabel();
        }
    } 
