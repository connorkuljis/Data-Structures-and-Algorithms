import java.util.*;

public class SelfHarness
{
    public static void main(String[] args)
    {
	String filename = "RandomNames7000.csv";
	int[] persons = Read.readInts(filename);

	for (int i=0; i < persons.length; i++)
	{
	    System.out.println(persons[i]); 
	}

	System.out.println("Size of array: " + persons.length); 

    }
}
