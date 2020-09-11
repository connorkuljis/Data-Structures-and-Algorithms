/* ***************************************************************************
 * NAME: MyLinkedListTestHarness.java
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT: Data Structures and Algorithms (COMP1002)
 * PURPOSE: Serialization of Linked List
 *          - Serialization in computing serialization or serialisation is the 
 *          process of translating a data structure or object state into a 
 *          format that can be stored or transmitted and reconstructed later.
 * COMMENT:
 * DATE: 2020-
 * **************************************************************************/

import java.util.*;

public class MyLinkedListTestHarness
{
    public static void main(String[] args)
    {
	boolean close = false;
	DSALinkedList list = new DSALinkedList();

	System.out.println("=== LINKED LIST TEST HARNESS W/ FILE I/O ==="); 
	Scanner sc = new Scanner(System.in);

	do 
	{
	    int choice = 0;
	    boolean valid = false;
	    do
	    {
		System.out.println("Select a choice"); 
		System.out.println("1) read a serialized file");
		System.out.println("2) display the list");
		System.out.println("3) write a serialized file"); 
		System.out.println("0) to exit"); 

		try
		{
		    String input = sc.next();
		    choice = Integer.parseInt(input);
		    valid = true;

		}
		catch (Exception e)
		{
		    System.out.println("error."); 
		} 

	    } while(!valid);

	    switch(choice)
	    {
		case 1:
		    // read a serialized file
		    list = readFile();
		    break;

		case 2:
		    // display the list
		    display(list);
		    break;

		case 3:
		    // write a serialized file
		    writeFile(list);
		    break;

		case 0:
		    System.out.println("Goodbye!"); 
		    close = true;
		    break;

		default:
		    System.out.println("Not a valid input. Try again"); 
		    break;
	    }
	} while (!close);
    }

    public static DSALinkedList readFile()
    {
	String filename;
	DSALinkedList list;

	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the filename"); 
	filename = sc.next();

	list = FileIO.readInts(filename);

	return list;
    }

    public static void display(DSALinkedList list)
    {
	for (Object e : list)
	{
	    System.out.print(e + ","); 
	}
	System.out.println(""); 
    }

    public static void writeFile(DSALinkedList list)
    {
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter filename: "); 
	String target = sc.next();

	try
	{
	    FileIO.writeFile(list, target);
	}
	catch (Exception e)
	{
	    System.out.println("e.getMessage()"); 
	}
    }


}
