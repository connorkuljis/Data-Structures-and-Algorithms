import java.util.*;

public class TestDSAHashTable
{
    public static void main(String[] args)
    {
	final String CLEAR = "\033[H\033[2J";

	System.out.println(CLEAR); 
	System.out.println("### DSAHashTable Test Harness"); 

	int size = 22;
	DSAHashTable table = new DSAHashTable(size);

	System.out.println("### Testing put() method"); 
	table.put("Apples", 10);
	System.out.println("put() ok."); 
	table.put("Pears", 20);
	System.out.println("put() ok."); 
	table.put("Oranges", 5);
	System.out.println("put() ok."); 
	table.put("Bananas", 2);
	System.out.println("put() ok."); 
	table.put("Grapes", 0.5);
	System.out.println("put() ok."); 

     
	System.out.println("Display: ~~~~~~~~"); 
	table.display();
	System.out.println("LF: " + table.getLoadFactor()); 

	System.out.println("### Testing remove() method"); 
	System.out.println("Removing key 'Oranges'"); 
	table.remove("Oranges");
	table.display();

	System.out.println("### Testing removal of invalid key value"); 
	table.remove("Shoes");

	table.display();

	System.out.println("LF: " + table.getLoadFactor()); 

    }
}
