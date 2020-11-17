/**
 * DSA Final Assessment Question 1 - FA_BinarySearchTree.java
 *
 * Name : Connor Kuljis		
 * ID   : 19459138
 * 
 * Contains methods adapted from P05/BinarySearchTree.java
 * - used the traversal method, and height calculation
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
	    System.out.println("Printing odd values: "); 
	    printEvenValues(root);
	    System.out.println("Finished printing odd values"); 

	}
	public void printEvenValues(FA_TreeNode node)
	{
	    if (node == null)
	    {
		return;
	    }

	    printEvenValues(node.left);
	    if ((node.value % 2) != 0) // is odd
	    {
		System.out.println(node.value); 
	    }
	    printEvenValues(node.right);
	}

	public void printEvenLevelsRecur()
	{
	    System.out.println("Printing even levels: "); 
	    System.out.println("Note: leaf nodes have a height of (0) eg: bottom-up"); 
	    printEvenLevels(root);
	    System.out.println("Finished printing even levels"); 
	}

	public void printEvenLevels(FA_TreeNode node)
	{
	    if (node == null)
	    {
		return;
	    }

	    printEvenLevels(node.left);
	    int height = heightRec(node);
	    if ((height % 2) == 0) // is even
	    {
		System.out.println(node.value + ", height=" + height); 
	    }
	    printEvenLevels(node.right);
	}

    public int height()
    {
	return heightRec(root);
    }

    public int heightRec(FA_TreeNode curNode)
    {
	int htSoFar, iLeftHt, iRightHt;

	if (curNode == null)
	{
	    htSoFar = -1; // Base case – no more along this branch
	}
	else
	{
	    iLeftHt = heightRec(curNode.left); // Calc left height from here 
	    iRightHt = heightRec(curNode.right); 

	    // Get highest of left vs right branches
	    if (iLeftHt > iRightHt)
	    {
		htSoFar = iLeftHt + 1;
	    }
	    else
	    {
		htSoFar = iRightHt + 1;
	    }
	}
	return htSoFar;
    }

	
  
}
