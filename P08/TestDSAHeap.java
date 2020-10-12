import java.util.*;

public class TestDSAHeap
{
    public static void main(String[] args)
    {
	simpleTest();




    }

    public static void simpleTest()
    {
	DSAHeap h1 = new DSAHeap(10);
	h1.add(4, null);
	h1.add(10, null);
	h1.add(3, null);
	h1.add(5, null);
	h1.add(1, null);

	h1.display();
    }
}
