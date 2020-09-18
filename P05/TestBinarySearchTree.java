/* ***************************************************************************
 * NAME: TestBinarySearchTree.java
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT: Data Structures and Algorithms (COMP1002)
 * PURPOSE: Test Harness for BST
 * COMMENT:
 * DATE: 2020-09-18
 * **************************************************************************/
import java.util.*;

public class TestBinarySearchTree
{
    public static void main(String[] args)
    {
	System.out.println("###################################################"); 
	System.out.println("*** BINARY SEARCH TREE TEST HARNESS ***"); 
	System.out.println("###################################################"); 
	BinarySearchTree tree = new BinarySearchTree();

	tree.insert("E", 10);
	tree.insert("B", 12);
	tree.insert("G", 13);
	tree.insert("A", 201);
	tree.insert("D", 5);
	tree.insert("F", 67);
	tree.insert("H", 1);
	tree.insert("C", 100);

	System.out.println("MIN: " + tree.min()); 
	System.out.println("MAX: " + tree.max()); 
	System.out.println("Height: " + tree.height()); 
	System.out.println("Value for 'E' found: " + tree.find("E")); 
	System.out.println(tree.find("X")); 

	System.out.println("\t\tBalance"); 
	tree.describeBalance();

	DSAQueue inOrderQueue = tree.inOrder();
	DSAQueue preOrderQueue = tree.preOrder();
	DSAQueue postOrderQueue = tree.postOrder();

	
	System.out.print("(In Order Traversal)   : "); 
	inOrderQueue.display();

	System.out.print("(Pre Order Traversal)  : "); 
	preOrderQueue.display();

	System.out.print("(Post Order Traversal) : "); 
	postOrderQueue.display();


	System.out.println("--- TESTING SERIALIZATION ---"); 
	System.out.println("... saving copy"); 
	Menu.save(tree, "test");

	System.out.println("... loading copy"); 
	BinarySearchTree copy = Menu.loadFile("test");
    System.out.println("Delete 'A'");
    copy.delete("A");

	inOrderQueue = copy.inOrder();
	System.out.print("(In Order Traversal)   : "); 
	inOrderQueue.display();
	System.out.println("COPY MIN: " + copy.min()); 
	System.out.println("COPY MAX: " + copy.max()); 
	System.out.println("COPY Height: " + copy.height()); 

    }
}
