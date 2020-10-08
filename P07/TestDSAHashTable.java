import java.util.*;

public class TestDSAHashTable
{
    public static void main(String[] args)
    {
	final String CLEAR = "\033[H\033[2J";

	int startSize = 10;

	System.out.println(CLEAR); 
	System.out.println("### DSAHashTable Test Harness"); 
	System.out.println("default size: " + startSize); 
	System.out.println(""); 

	DSAHashTable table = new DSAHashTable(startSize);

	System.out.println("### Testing put() method"); 
	table.put("Apples", 10);
	table.put("Pears", 20);
	table.put("Bananas", 2);
	table.put("Grapes", 0.5);
	table.put("Oranges", 1);
	table.put("Assorted", 1);
	displayHashTableInfo(table);

	System.out.println("Removing key 'Apples'"); 
	table.remove("Apples");
	displayHashTableInfo(table);

	System.out.println("Removal of invalid key value"); 
	table.remove("Shoes");
	displayHashTableInfo(table);

    }

    private static void displayHashTableInfo(DSAHashTable table)
    {
	table.display();
	System.out.println("\tLF: " + table.getLoadFactor()); 
	System.out.println("\tCAPACITY: " + table.getCapacity()); 
	System.out.println(""); 

    }
}
