/**
 * DSA Final Assessment Question 1 - FA_BinarySearchTree.java
 *
 * Name : Connor Kuljis		
 * ID   : 19459138
 *
 **/

public class FA_BinarySearchTree {   
	// Inner class FA_TreeNode
	private class FA_TreeNode {
		public int value;
		public FA_TreeNode left;
		public FA_TreeNode right;
		
		public FA_TreeNode(int inVal)
		{
			value = inVal;
			left = null;
			right = null;
		}
	}
	// Class FA_BinarySearchTree
	private FA_TreeNode root;
	
	public FA_BinarySearchTree()
	{
		root = null;
	}
	
	public void insert(int val)
	{
		if (isEmpty())
		{
			root = new FA_TreeNode(val);
		}
		else
		{
			root = insertRec(val, root);
		}
	}

	public Boolean isEmpty()
	{
		return root == null;
	}

	private FA_TreeNode insertRec(int inVal, FA_TreeNode cur)
	{
		if (cur == null)
		{
			cur = new FA_TreeNode(inVal);
		}
		else
		{
			if (inVal < cur.value)
			{
				cur.left = insertRec(inVal, cur.left);
			}
			else	
			{
				cur.right = insertRec(inVal, cur.right);
			}
		}
		return cur;
	}

	public void printEvenValuesRecur()
	{
	    FA_TreeNode start = root;
	    printEvenValues(start);

	}
	public void printEvenValues(FA_TreeNode node)
	{
	    if (node == null)
	    {
		return;
	    }

	    printEvenValues(node.left);
	    if ((value % 2) != 0) // is odd
	    {
		System.out.println(node.value + ","); 
	    }
	    printEvenValues(node.left);
	}

	public void printEvenLevels()
	{


	}

	
  
}