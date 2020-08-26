import java.util.*;

public class QueueTestHarness
{
    public static void main(String[] args)
    {
	/*
	DSACircularQueue test1 = new DSACircularQueue(3);

	test1.insert("Mary");
	test1.insert("Apples");
	test1.insert("Document");
	test1.insert("Bad");
	test1.insert("Yep");


	System.out.println("SIZE: " + test1.size()); 
	System.out.println("IS EMPTY?: " + test1.isEmpty()); 
	System.out.println("IS FULL?: " + test1.isFull()); 

	System.out.println("REMOVE: " + test1.remove()); 
	System.out.println("REMOVE: " + test1.remove()); 
	System.out.println("SIZE: " + test1.size()); 
	System.out.println("PEEK: " + test1.peek()); 
	*/

	DSAQueue test1 = new DSACircularQueue(5);

	test1.insert("Mary");
	test1.insert("Apples");
	test1.insert("Document");
	System.out.println("SIZE: " + test1.size()); 

	System.out.println("REMOVE: " + test1.remove()); 
	System.out.println("REMOVE: " + test1.remove()); 
	System.out.println("REMOVE: " + test1.remove()); 
	System.out.println("REMOVE: " + test1.remove()); 

	System.out.println("EMPTY?: " + test1.isEmpty()); 
	System.out.println("SIZE: " + test1.size()); 
	System.out.println("PEEK: " + test1.peek()); 




    }
}
