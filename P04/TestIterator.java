import java.util.*;

public class TestIterator
{
    public static void main(String[] args)
    {
	DSALinkedList testList = new DSALinkedList();
	testList.insertFirst("asdf");
	testList.insertFirst(123);
	testList.insertFirst(23.0);
	testList.insertFirst('a');
	 
	for (Object e : testList)
	{
	    System.out.println(e); 
	}

    }
}
