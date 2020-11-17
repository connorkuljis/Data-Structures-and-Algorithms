/**
 * DSA Final Assessment Question 3d - MaxHeapTest.java
 *
 * Name : Connor Kuljis
 * ID   : 1949138
 * 			
 * This is a copy of MaxHeapTest, please refer to that file for detailed assertions, statments.
 * This file just uses FA_MinHeap instead of FA_MaxHeap to cover part D
 *
 *
 **/

import java.util.*;
import java.io.*;
 
public class MinHeapTest
{
    public static void main(String args[])
    {
	// part A has been done (see comments) in MaxHeapTest
	// THIS TIME USING MIN HEAP
	partB(); // broken down into modules for readability, lots of testing going on
	partC();
    }

    // this section is about error handing, try catches have been used
    private static void partB()
    {

	System.out.println("\n***Question 3D - SAME TEST USING MIN Heaps ***\n");
	System.out.println("\n***Question 3 - Testing Heaps ***\n");
	System.out.println("For completeness, error stack traces are printed to show good use of custom exceptions\n"); 
	
	FA_MinHeap testHeap = new FA_MinHeap();
	
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
	FA_MinHeap minHeap = readHeapFile(filename); // this method will print the contents as they are added one by one
	// END INSERION

	// START REMOVAL
	System.out.println("\n***Question 3 c- Testing Removal of Queue ***\n");
	Object tempObject = null;
	for (int i=0; i<10; i++)
	{
		try
		{
		    tempObject = minHeap.remove();
		    System.out.println(tempObject + " has been removed.");
		    minHeap.printContents();
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
    public static FA_MinHeap readHeapFile(String inFilename)
    {
	FileInputStream fileStrm = null;
	InputStreamReader rdr;
	BufferedReader bufRdr;
	String line;

	int lineNum = 0;
	FA_MinHeap heap = new FA_MinHeap();

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

    public static void processLine(String row, FA_MinHeap heap)
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
