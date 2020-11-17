/**
 * DSA Final Assessment Question 1 - FA_TreeTest.java
 *
 * Name : Connor Kuljis	
 * ID   : 19459138
 *
 * Assertion: leaf nodes have a height of "0" and height works from bottom to top.
 * may contain code referenced/adapted from P05/BinarySearchTree.java
 **/
public class FA_TreeTest
{
    public static void main(String args[])
    {
	System.out.println("\n**** Question 1: Testing Trees ****\n");
	
	int[] input = {00,11,22,33,44,88,99,100,44,55,66,77};

	// int[] other = {10,5,40,6,4,16,45};

	FA_BinarySearchTree tree = new FA_BinarySearchTree();
	System.out.print("input=["); 
	for(int i = 0; i < input.length; i++)
	{
	    System.out.print(input[i] + ",");
	    tree.insert(input[i]);
	}
	System.out.print("]"); 
	System.out.println(""); 

	// Question 1 b
	tree.printEvenValuesRecur();
	System.out.println(""); 

	// Question 1 c
	tree.printEvenLevelsRecur();
	System.out.println(""); 

	System.out.println("isEmpty=" + tree.isEmpty()); 


		
	System.out.println("\n**** Tests Complete ****\n");

    }
	
}
