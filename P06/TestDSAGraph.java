public class TestDSAGraph 
{
    public static void main(String[] args)
    {
        DSAMatrixGraph g1 = new DSAMatrixGraph(3);
        g1.addVertex('0');
        g1.addVertex('1');
        g1.addVertex('2');

        g1.addEdge(0,1);
        g1.addEdge(0,2);
        g1.addEdge(1,2);
        g1.displayAsMatrix();
    }
    
}
