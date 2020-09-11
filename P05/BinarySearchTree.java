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
		throw IllegalArgumentException("Key cannot be null");
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
	// returns an object
	return findRec(key, m_root);
    }

    private Object findRec(String key, TreeNode curNode)
    {
	Object value = null;

	if (curNode == null)
	{
	    throw new Exception("Key " + key + ", not found");
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
	    value = findrec(key, curNode.getRight()); // go right recursive
	}
	return value;
    }

    public void insert(String key, Object value)
    {
	return insertRec(key, value,  )
    }

    public void insertRec(String key, Object value, TreeNode curNode)

    public void delete(String key)
    {
	//todo
    }

    public void display()
    {

    }

    public int height()
    {

    }



}
