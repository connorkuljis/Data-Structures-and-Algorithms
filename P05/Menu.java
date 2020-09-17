import java.util.*;
import java.io.*;

public class Menu
{
    public static void main(String[] args)
    {
	readCSV();

	// 1. read a csv file
	// 2. read a serialized file
	// 3. display the tree
	// 4. write a csv file (options fo in,pre,post-order traversal)
	// 5/ write a serialized file
    }

    public static void readCSV()
    {
	String filename;
	BinarySearchTree tree;

	filename = "RandomNames7000.csv";
	tree = FileIO.readCSV(filename);
	tree.describeBalance();
    }

    writeCSV(BinarySearchTree tree)
    {

    }

    private void writeFile(BinarySearchTree objToSave, String filename)
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
	    throw new IllegalArgumentException("Unable to save object to file");
	}
    }

    private BinarySearchTree loadFile(String filename) throws IllegalArgumentException
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

