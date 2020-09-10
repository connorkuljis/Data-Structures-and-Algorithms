import java.util.*;

public class TestIterator
{
    public static void main(String[] args)
    {
	DSALinkedList testList = new DSALinkedList();
	testList.insertLast("asdf");
	testList.insertLast(123);
	testList.insertLast(23.0);
	testList.insertLast('a');

	for (Object e : testList)
	{
	    System.out.println(e); 
	    // cannot test hasNext() or next() as they are private
	}
    }
}
