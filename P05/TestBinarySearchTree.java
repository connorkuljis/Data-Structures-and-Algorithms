import java.util.*;

public class TestBinarySearchTree
{
    public static void main(String[] args)
    {
	BinarySearchTree tree = new BinarySearchTree();

	tree.insert("E", 1);
	tree.insert("B", 1);
	tree.insert("G", 1);
	tree.insert("A", 1);
	tree.insert("D", 1);
	tree.insert("F", 1);
	tree.insert("H", 1);
	tree.insert("C", 1);

	System.out.println(tree.min()); 
	System.out.println(tree.max()); 

	System.out.println(tree.height()); 

	tree.describeBalance();

	DSAQueue inOrderQueue = tree.inOrder();
	while (!inOrderQueue.isEmpty())
	{
	    System.out.print(inOrderQueue.remove() + " ");

	}





    }
}
