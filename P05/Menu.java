/* ***************************************************************************
 * NAME: Menu.java
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT: Data Structures and Algorithms (COMP1002)
 * PURPOSE: menu for using a BST
 * COMMENT: requires fileIO
 * DATE: 2020-09-18
 * **************************************************************************/
import java.util.*;
import java.io.*;

public class Menu
{
    public static void main(String[] args)
    {
	int choice;
	boolean close = false;
	BinarySearchTree tree = new BinarySearchTree();
	String prompt = "1. read a CSV file\n2. read a serialized file\n3. display the tree\n4. write a csv file (submenu)\n5. write a serialized file\n0.Exit";

	System.out.println("*** BST MENU ***"); 
	System.out.println(prompt); 

	Scanner sc = new Scanner(System.in);


	do 
	{
	    System.out.println(prompt); 
	    choice = sc.nextInt();
	    switch (choice)
	    {
		case 1:
		    tree = readCSV();
		    break;
		case 2:
		    System.out.println("Loading test file"); 
		    loadFile("test");
		    break;
		case 3:
		    // todo
		    DSAQueue queue = tree.inOrder();
		    queue.display();
		    break;
		case 4:
		    writeCSV(tree);
		    break;
		case 5:
		    save(tree, "test");
		    break;
		case 0:
		    System.out.println("Goodbye!"); 
		    close = true;
		    break;
		default:
		    System.out.println("Invalid input"); 
		    break;
	    } 
	}while(!close);

    }

    public static BinarySearchTree readCSV()
    {
	String filename;
	BinarySearchTree tree;

	filename = "RandomNames7000.csv";
	tree = FileIO.readCSV(filename);

	return tree;
    }

    private static void writeCSV(BinarySearchTree tree)
    {
	int choice;
	String filename;
	Scanner sc = new Scanner(System.in);

	System.out.println("Select a choice.\n1. Save in order\n2. Save pre order\n3. Save post order"); 
	choice = sc.nextInt();

	System.out.println("Enter filename (please save as .csv)"); 
	filename = sc.next();

	switch (choice)
	{
	    case 1: 
		DSAQueue inOrderQueue = tree.inOrder();
		attemptWriteCSV(inOrderQueue, filename);
		break;
	    case 2: 
		DSAQueue preOrderQueue = tree.preOrder();
		attemptWriteCSV(preOrderQueue, filename);
		break;
	    case 3: 
		DSAQueue postOrderQueue = tree.postOrder();
		attemptWriteCSV(postOrderQueue, filename);
		break;
	    default:
		System.out.println("invalid option"); 
		break;
	}
    }

    private static void attemptWriteCSV(DSAQueue queue, String filename)
    {
	try
	{
	    FileIO.writeCSV(queue, filename);
	}
	catch (Exception e)
	{
	    System.out.println(e.getMessage()); 
	}
    }

    public static void save(BinarySearchTree objToSave, String filename)
    {
	FileOutputStream fileStrm;
	ObjectOutputStream objStrm;

	try
	{
	    fileStrm = new FileOutputStream(filename);
	    objStrm = new ObjectOutputStream(fileStrm);
	    objStrm.writeObject(objToSave);

	    objStrm.close();
	}
	catch (Exception e)
	{
	    e.printStackTrace();
	    throw new IllegalArgumentException("Unable to save object to file");
	}
    }

    public static BinarySearchTree loadFile(String filename) throws IllegalArgumentException
    {
	FileInputStream fileStrm;
	ObjectInputStream objStrm;
	BinarySearchTree inObj = new BinarySearchTree();

	try
	{
	    fileStrm = new FileInputStream(filename);
	    objStrm = new ObjectInputStream(fileStrm);
	    inObj = (BinarySearchTree)objStrm.readObject();

	    objStrm.close();
	}
	catch (ClassNotFoundException e)
	{
	    System.out.println("Class BinarySearchTree not found"); 
	}
	catch (Exception e)
	{
	    throw new IllegalArgumentException("Unable to load object from file");
	}
	return inObj;
    }

}

