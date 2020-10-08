import java.util.*;
import java.io.*;

public class FileIO
{
    public static void main(String[] args)
    {
	DSAHashTable table = null;
	boolean close = false;

	do
	{
	    System.out.println("1. Read Students from 'RandomNames7000.csv'"); 
	    System.out.println("2. Display Hash Table"); 
	    System.out.println("3. Save the Object"); 
	    System.out.println("4. Load the Object"); 
	    System.out.println("0. Exit"); 

	    Scanner sc = new Scanner(System.in);
	    int choice = sc.nextInt();

	    switch(choice)
	    {
		case 1:
		    table = readCSV("RandomNames7000.csv");
		    System.out.println("CSV LOADED..."); 
		    break;
		case 2:
		    table.display();
		    System.out.println("LF: " + table.getLoadFactor()); 
		    System.out.println("CAPACITY: " + table.getCapacity()); 
		    System.out.println("DISPLAY..."); 
		    break;
		case 3:
		    save(table, "thisIsTheSaveObject");
		    System.out.println("SAVED..."); 
		    break;
		case 4:
		    table = load("thisIsTheSaveObject");
		    System.out.println("OBJECT LOADED..."); 
		    break;
		case 0:
		    System.out.println("Goodbye..."); 
		    close = true;
		    break;
	    }
	} while (!close);
    }

    public static DSAHashTable readCSV(String inFilename)
    {
	DSAHashTable table = new DSAHashTable(7000);


	FileInputStream fileStrm = null;
	InputStreamReader rdr;
	BufferedReader bufRdr;
	String line;

	try {
	    fileStrm = new FileInputStream(inFilename);
	    rdr = new InputStreamReader(fileStrm);
	    bufRdr = new BufferedReader(rdr);

	    line = bufRdr.readLine();
	    while(line != null)
	    {
		processLine(line, table);
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
	return table;
    }

    public static void processLine(String row, DSAHashTable table)
    {
	try
	{
	    String[] strArr = row.split(",");
	    String inKey = strArr[1];
	    int inValue = Integer.parseInt(strArr[0]);
	    table.put(inKey, inValue);
	}
	catch (IllegalArgumentException e)
	{
	    System.out.println("Error trying to process line"); 
	}
    }

    private static void save(DSAHashTable objToSave, String filename)
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

    private static DSAHashTable load(String filename) throws IllegalArgumentException
    {
	FileInputStream fileStrm;
	ObjectInputStream objStrm;
	DSAHashTable inObj = null;

	try
	{
	    fileStrm = new FileInputStream(filename);
	    objStrm = new ObjectInputStream(fileStrm);
	    inObj = (DSAHashTable)objStrm.readObject();

	    objStrm.close();
	}
	catch (ClassNotFoundException e)
	{
	    System.out.println("Class DSAHashTable not found " + e.getMessage());
	}
	catch (Exception e) 
	{
	    throw new IllegalArgumentException("Unable to load object from file");
	}
	return inObj;
    }
}
