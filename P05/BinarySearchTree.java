/* ***************************************************************************
 * NAME: TreeNode.java
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT: Data Structures and Algorithms (COMP1002)
 * PURPOSE:
 * COMMENT:
 * DATE: 2020-09-11
 * **************************************************************************/

public class BinarySearchTree
{
    public class TreeNode
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
	    throw new IllegalArgumentException("Key " + key + ", not found");
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
	else if (key.compareTo(curNode.getKey()) < 0)
	{
	    curNode.setLeft(insertRec(key, value, curNode.getLeft()));
	}
	else
	{
	    curNode.setRight(insertRec(key, value, curNode.getRight()));
	}
	return updateNode;
    }

    public void delete(String key)
    {
	//todo
    }

    public void printInOrder()
    {
	inOrderRec(m_root);
	System.out.println(""); 
    }

    public void printPreOrder()
    {
	preOrderRec(m_root);
	System.out.println(""); 
    }

    public void printPostOrder()
    {
	postOrderRec(m_root);
	System.out.println(""); 
    }

    public void inOrderRec(TreeNode node)
    {
	if (node == null)
	{
	    return;
	}

	inOrderRec(node.getLeft());
	System.out.print(node.getKey() + " "); 
	inOrderRec(node.getRight());
    }

    public void preOrderRec(TreeNode node)
    {
	if (node == null)
	{
	    return;
	}

	System.out.print(node.getKey() + " "); 
	inOrderRec(node.getLeft());
	inOrderRec(node.getRight());

    }

    public void postOrderRec(TreeNode node)
    {
	if (node == null)
	{
	    return;
	}

	inOrderRec(node.getLeft());
	inOrderRec(node.getRight());
	System.out.print(node.getKey() + " "); 

    }
    public int height()
    {
	return 0;

    }



}
