/* ***************************************************************************
 * NAME: TestDSAHeap
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT: Data Structures and Algorithms (COMP1002)
 * PURPOSE: Testing harness for DSAHeap
 *
 * COMMENT: 
 * simpleTest()
 * lectureEx()
 * fileIOTest()
 *
 * DATE: 2020-10-13
 * **************************************************************************/
import java.util.*;

public class TestDSAHeap
{
    public static void main(String[] args)
    {
	boolean close = false;
	do
	{
	    System.out.println("1. Add and remove from heap"); 
	    System.out.println("2. Sort array from lecture slides"); 
	    System.out.println("3. Load a large file from 'RandomNames7000.csv'"); 
	    System.out.println("0. Exit"); 

	    Scanner sc = new Scanner(System.in);
	    int choice = sc.nextInt();

	    switch(choice)
	    {
		case 1:
		    simpleTest();
		    break;
		case 2:
		    lectureEx();
		    break;
		case 3:
		    fileIOTest();
		    break;
		case 0:
		    System.out.println("Goodbye..."); 
		    close = true;
		    break;
	    }
	} while (!close);
    }

    public static void simpleTest()
    {
	DSAHeap h1 = new DSAHeap(1);
	h1.add(5, null);
	h1.add(4, null);
	h1.add(1, null);
	h1.add(11, null);
	h1.add(10, null);
	h1.add(3, null);
	h1.add(2, null);
	h1.add(16, null);
	h1.add(12, null);

	System.out.println("HEAP ARRAY"); 
	h1.display();

	for (int i = 0; i < 9; i++)
	{
	    System.out.println("REMOVE: " + h1.remove().getPriority()); 
	}

	System.out.println("HEAP ARRAY"); 
	h1.display();
    }

    public static void lectureEx()
    {
	DSAHeap h1 = new DSAHeap(1);
	DSAHeapEntry[] heapArr = new DSAHeapEntry[9];
	heapArr[0] = new DSAHeapEntry(4, null);
	heapArr[1] = new DSAHeapEntry(4, null);
	heapArr[2] = new DSAHeapEntry(1, null);
	heapArr[3] = new DSAHeapEntry(11, null);
	heapArr[4] = new DSAHeapEntry(10, null);
	heapArr[5] = new DSAHeapEntry(3, null);
	heapArr[6] = new DSAHeapEntry(2, null);
	heapArr[7] = new DSAHeapEntry(16, null);
	heapArr[8] = new DSAHeapEntry(12, null);

	h1.heapSort(heapArr);
	h1.display();
    }

    private static void fileIOTest()
    {
	String filename = "RandomNames7000.csv";
	DSAHeap h1 = new DSAHeap(1);
	DSAHeapEntry[] heapArr = FileIO.createArray(filename);
	
	h1.heapSort(heapArr);
	h1.display();
    }
}
