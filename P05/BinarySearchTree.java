/* ***************************************************************************
 * NAME: TreeNode.java
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT: Data Structures and Algorithms (COMP1002)
 * PURPOSE:
 * COMMENT: https://stackoverflow.com/questions/742844/how-to-determine-if-binary-tree-is-balanced
 * DATE: 2020-09-17
 * **************************************************************************/
import java.io.*;

public class BinarySearchTree implements Serializable
{
    public class TreeNode implements Serializable
    {
	private String m_key;
	private Object m_value;
	private TreeNode m_leftChild;
	private TreeNode m_rightChild;

	public TreeNode(String inKey, Object inVal)
	{
	    if (inKey == null)
	    {
		throw new IllegalArgumentException("Key cannot be null");
	    }
	    m_key = inKey;
	    m_value = inVal;
	    m_rightChild = null;
	    m_leftChild = null;
	}

	public String getKey() { return m_key; }

	public Object getValue() { return m_value; }

	public TreeNode getLeft() { return m_leftChild; }

	public void setLeft(TreeNode newLeft) { m_leftChild = newLeft; }

	public TreeNode getRight() { return m_rightChild; }

	public void setRight(TreeNode newRight) { m_rightChild = newRight; }
    }

    private TreeNode m_root;

    public BinarySearchTree()
    {
	m_root = null; // start with an empty tree
    }

    public Object find(String key)
    {
	return findRec(key, m_root);
    }

    private Object findRec(String key, TreeNode curNode)
    {
	Object value = null;

	if (curNode == null)
	{
	    System.out.println("Key " + key + " not found"); 
	}
	else if (key.equals(curNode.getKey())) // base case
	{
	    value = curNode.getValue();
	}
	else if (key.compareTo(curNode.getKey()) < 0)
	{
	    value = findRec(key, curNode.getLeft()); // go left recursive
	}
	else
	{
	    value = findRec(key, curNode.getRight()); // go right recursive
	}
	return value;
    }

    public void insert(String key, Object value)
    {
	insertRec(key, value, m_root);
    }

    public TreeNode insertRec(String key, Object value, TreeNode curNode)
    {
	TreeNode updateNode = curNode;
	if (m_root == null) // base case 1
	{
	    TreeNode newNode = new TreeNode(key, value);
	    m_root = newNode;
	}
	else if (curNode == null) // base case 2
	{
	    TreeNode newNode = new TreeNode(key, value);
	    updateNode = newNode; // this messed me up :)
	}
	else if (key.equals(curNode.getKey()))
	{
	    throw new IllegalArgumentException("Key " + key + ", already exists within the tree");
	}
	else if (key.compareTo(curNode.getKey()) < 0) // string is smaller so go left recursive
	{
	    curNode.setLeft(insertRec(key, value, curNode.getLeft()));
	}
	else // string is not smaller so go right recursive
	{
	    curNode.setRight(insertRec(key, value, curNode.getRight()));
	}
	return updateNode;
    }

    public void delete(String key)
    {
	deleteRec(key, m_root);
    }

    // (recursively) find the node to delete and pass it to a method that will remove it from the tree
    public TreeNode deleteRec(String key, TreeNode curNode)
    {
	TreeNode updateNode = curNode;

	if (curNode == null)
	{
	    throw new IllegalArgumentException("Cannot delete node, not in tree.");
	}
	else if (key.equals(curNode.getKey()))
	{
	    updateNode = deleteNode(key, curNode);
	}
	else if (key.compareTo(curNode.getKey()) < 0) // string is smaller so go left recursive
	{
	    curNode.setLeft(deleteRec(key, curNode.getLeft()));
	}
	else // string is not smaller so go right recursive
	{
	    curNode.setRight(deleteRec(key, curNode.getRight()));
	}
	return updateNode;
    }

    public TreeNode deleteNode(String key, TreeNode delNode)
    {
	TreeNode updateNode = null;

	if (delNode.getLeft() == null && delNode.getRight() == null)
	{
	    updateNode = null;                    // no children
	}
	else if (delNode.getLeft() != null && delNode.getRight() == null)
	{
	    updateNode = delNode.getLeft();       // one child (left)
	}
	else if (delNode.getLeft() == null && delNode.getRight() != null)
	{
	    updateNode = delNode.getRight();       // one child (right)
	}
	else
	{
	    updateNode = promoteSuccessor(delNode.getRight());
	    if (updateNode != delNode.getRight())
	    {
		updateNode.setRight(delNode.getRight());
	    }
	    updateNode.setLeft(delNode.getLeft());
	}
	return updateNode;
    }

    public TreeNode promoteSuccessor(TreeNode curNode)
    {
	TreeNode successor = curNode;
	if (curNode.getLeft() == null)
	{
	    successor = curNode;
	}
	else if (curNode.getLeft() != null)
	{
	    successor = promoteSuccessor(curNode.getLeft());
	    if (successor == curNode.getLeft())
	    {
		curNode.setLeft(successor.getRight());
	    }
	}
	return successor;
    }

    public DSAQueue inOrder()
    {
	DSAQueue theQueue = new DSAQueue();
	inOrderRec(theQueue, m_root);
	return theQueue;
    }

    public DSAQueue preOrder()
    {
	DSAQueue theQueue = new DSAQueue();
	preOrderRec(theQueue, m_root);
	return theQueue;
    }

    public DSAQueue postOrder()
    {
	DSAQueue theQueue = new DSAQueue();
	postOrderRec(theQueue, m_root);
	return theQueue;
    }

    public void inOrderRec(DSAQueue theQueue, TreeNode node)
    {
	if (node == null)
	{
	    return;
	}

	inOrderRec(theQueue, node.getLeft());
	theQueue.insert(node.getKey());
	inOrderRec(theQueue, node.getRight());
    }

    public void preOrderRec(DSAQueue theQueue, TreeNode node)
    {
	if (node == null)
	{
	    return;
	}

	theQueue.insert(node.getKey());
	preOrderRec(theQueue, node.getLeft());
	preOrderRec(theQueue, node.getRight());

    }

    public void postOrderRec(DSAQueue theQueue, TreeNode node)
    {
	if (node == null)
	{
	    return;
	}

	postOrderRec(theQueue, node.getLeft());
	postOrderRec(theQueue, node.getRight());
	theQueue.insert(node.getKey());
    }

    public String min()
    {
	return minRec(m_root);
    }

    public String max()
    {
	return maxRec(m_root);
    }

    /* keep looking to the left node */
    public String minRec(TreeNode curNode)
    {
	String minKey;
	if (curNode.getLeft() != null) // base case
	{
	    minKey = minRec(curNode.getLeft());
	}
	else
	{
	    minKey = curNode.getKey();
	}
	return minKey;
    }

    /* keep looking to the right node as long as there is some node there */
    public String maxRec(TreeNode curNode)
    {
	String maxKey;
	if (curNode.getRight() != null) // not the base case
	{
	    maxKey = maxRec(curNode.getRight());
	}
	else // this is the base case eg: the next node is null
	{
	    maxKey = curNode.getKey();  
	}
	return maxKey;
    }

    public void describeBalance()
    {
	int lh, rh, th;
	double lw, rw;

	th = height();
	lh = heightRec(m_root.getLeft());
	rh = heightRec(m_root.getRight());

	lw = (double)(lh) / (double)(th) * 100;
	rw = (double)(rh) / (double)(th) * 100;

	System.out.println("L=" + lw + "% | R=" + rw + "%"); 
    }

    public int height()
    {
	return heightRec(m_root);
    }

    public int heightRec(TreeNode curNode)
    {
	int htSoFar, iLeftHt, iRightHt;

	if (curNode == null)
	{
	    htSoFar = -1; // Base case – no more along this branch
	}
	else
	{
	    iLeftHt = heightRec(curNode.getLeft()); // Calc left height from here 
	    iRightHt = heightRec(curNode.getRight()); 

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
