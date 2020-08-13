/* ***************************************************************************
 * FILE: Question5.java
 * NAME: Connor Kuljis
 * ID: 19459138
 * UNIT: Data Structures and Algorithms
 * COMMENTS: rough driver code to test sorting with objects.
 * DATE: 2020-08-14          
 * **************************************************************************/

public class Question5
{
    public static void main(String[] args)
    {
	String filename = "RandomNames7000.csv";
	Person[] names = Read.readNames(filename); /* create an array of 
						      person objects */
	printArray(names); // lets check first 10 people

	// TODO: possibly make a menu for this, for now - just uncomment 

	// Sorts.bubbleSort(names);
	// Sorts.selectionSort(names);
	// Sorts.insertionSort(names);
	
	printArray(names); // check if the first 10 people are sorted
    }

    private static void printArray(Person[] myArr)
    {
	for (int i = 0; i < 10; i++)
	{
	    System.out.println(myArr[i]); 
	}
	System.out.println(""); 
    }


}
