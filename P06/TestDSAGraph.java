public class TestDSAGraph 
{
    public static void main(String[] args)
    {
	final String file1 = "prac6_1.al";
	final String file2 = "prac6_2.al";

        DSAGraph g1 = FileIO.readAL(file1);
	System.out.println("BFS"); 
	g1.breadthFirstSearch();

	
    }
    
}
