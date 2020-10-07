public class TestDSAGraph 
{
    public static void main(String[] args)
    {
	final String file1 = "prac6_1.al";
	final String file2 = "prac6_2.al";

        DSAGraph g1 = FileIO.readAL(file1);
        g1.displayAdjacencyList();
	
        DSAGraph g2 = FileIO.readAL(file2);
        g2.displayAdjacencyList();
    }
    
}
