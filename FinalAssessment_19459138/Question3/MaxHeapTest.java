/**
 * DSA Final Assessment Question 3 - MaxHeapTest.java
 *
 * Name : Connor Kuljis
 * ID   : 1949138
 *
 * ASSUMPTION: 	Question 3.a states "Modify FA_MaxHeap.java/py  to  store  the  priority  and  value".
 * 		It seems this functionality is already implemented, so I've just added more evident testing to show.
 *
 * For the error handling i've wrapped the remove() body in a try catch, that when caught raises a PracExamException.
 * 	An example case may be trying to remove a heap entry when the heap is already empty, this could crash with an null pointer
 * 	exception. This is solved with this try catch implementation.
 *
 * For the add() method I've set an initial statment to check the number of items agains the max_size.
 * If the count is at the limit, or for some reason is above the limit, a PracExamException is thrown.
 * I have not resized the array as the spec does not state whether this is needed, but it is an option.
 * 			
 **/

import java.util.*;
import java.io.*;
 
public class MaxHeapTest
{
    public static void main(String args[])
    {
	// part A has been done (see comments)
	partB(); // broken down into modules for readability, lots of testing going on
	partC();
    }

    // this section is about error handing, try catches have been used
    private static void partB()
    {
	System.out.println("\n***Question 3 - Testing Heaps ***\n");
	System.out.println("For completeness, error stack traces are printed to show good use of custom exceptions\n"); 
	
	FA_MaxHeap testHeap = new FA_MaxHeap();
	
	// testing add()
	for (int i=0; i<15; i++) // max size of heap is 10 so we should handle out of bounds
	{
		int priority = i;  // renamed for readability
		int val = i + 100; // renamed this for readability
		try
		{
		    testHeap.add(priority, val);
		    System.out.println("Added heap entry [priority: " + priority + ", value: "+ val + "]");
		}
		catch (Exception e) // exception e should be a PracExamException
		{
		    e.printStackTrace(); // will just print the trace to show use of custom exception
		}
	}
	//end
	
	// tesing remove()
	int temp;
	for (int i=0; i<15; i++) // once again removing more than the max size, after 10 iters should be empty
	{
		try
		{
		    temp = (Integer)testHeap.remove();
		    System.out.println(temp + " has been removed.");
		}
		catch (Exception e)
		{
		    e.printStackTrace();
		}
	}
    }

    private static void partC()
    {
		System.out.println("\n***Question 3 c- Testing Priority Queue ***\n");

		String message = ("This segment is Question 3 part (c)\n" + 
			"Involves reading from a file and checking contents of priority\n"
			+ "queue at each stage, (insert/remove)\n");

		System.out.println("Message"); 

		// INSERTION PART HERE 
		System.out.println("\n***Question 3 c- Testing Insertion of Queue ***\n");
		String filename = "FA_HeapData.txt";
		FA_MaxHeap maxHeap = readHeapFile(filename); // this method will print the contents as they are added one by one
		// END INSERION

		// START REMOVAL
		System.out.println("\n***Question 3 c- Testing Removal of Queue ***\n");
		Object tempObject = null;
		for (int i=0; i<10; i++)
		{
			try
			{
			    tempObject = maxHeap.remove();
			    System.out.println(tempObject + " has been removed.");
			    maxHeap.printContents();
			}
			catch (Exception e)
			{
			    e.printStackTrace();
			}
		}
		//END REMOVAL

		System.out.println("\n**** Tests Complete ****\n");

    }

    // this function reads the file, and simply passes each line to another method which handles each line
    // returns a max heap
    public static FA_MaxHeap readHeapFile(String inFilename)
    {
	FileInputStream fileStrm = null;
	InputStreamReader rdr;
	BufferedReader bufRdr;
	String line;

	int lineNum = 0;
	FA_MaxHeap heap = new FA_MaxHeap();

	try {
	    fileStrm = new FileInputStream(inFilename);
	    rdr = new InputStreamReader(fileStrm);
	    bufRdr = new BufferedReader(rdr);

	    line = bufRdr.readLine();
	    while(line != null)
	    {
		processLine(line, heap);
		lineNum++;
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
	return heap;
    }

    public static void processLine(String row, FA_MaxHeap heap)
    {
	try
	{
	    // begin splitting the row, in the format <priority>space<value>
	    String[] strArr = row.split(" ");
	    int priority  = Integer.parseInt(strArr[0]);
	    String value  = strArr[1];

	    heap.add(priority, value);
	    heap.heapify(); // heapify to convert to bst 
	    heap.printContents(); // display function
	}
	catch (Exception e) // should be PracExamException type
	{
	    e.printStackTrace(); // simplicity to show type
	}
    }

}
