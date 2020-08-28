/* ***************************************************************************
 * NAME: CallStack.java
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT: Data Structures and Algorithms
 * PURPOSE: simple java program to simulate a call stack
 * COMMENT: https://en.wikipedia.org/wiki/Call_stack
 * DATE: 2020-08-28
 * **************************************************************************/
import java.util.*;

public class CallStack
{
    // I have used a global variable here for the sake of simulating RAM in a computer
    public static DSAStack stack = new DSAStack();

    public static void main(String[] args)
    {
	int nCalls = 5;

	System.out.println("# Call Stack Example\n"); 

	System.out.println("\t### Simulating a Recursive Method Call"); 
	functionRecur(nCalls);

	System.out.println("\n\t### Simulating a Nested Method Call"); 
	functionNested(nCalls);
    }
    
    public static void functionRecur(int n)
    {
	int i = n*2;
	String methodName = "functionRecur(" + Integer.toString(n) + "), i=" + i; // String of name and arguments

	if (n == 0) // base case
	{
	    return;
	}

	insertStack(methodName); // simulate adding 'block' to stack frame
	functionRecur(n-1);
	popStack(methodName); // simulate removing 'block' to stack frame
    }

    public static void functionNested(int n)
    {
	String name = "functionRecur(" + Integer.toString(n) + ")";
	insertStack(name);

	// nesting method calls in a for loop
	for (int i = 1; i <= n; i++)
	{
	    String methodName = "functionRecur(" + Integer.toString(i) + ")";
	    insertStack(methodName);
	    popStack(methodName); // method is removed from the stack immediately after
	}
	popStack(name);

    }

    public static void insertStack(String methodName)
    {
	stack.push(methodName);
	stack.display();
    }

    public static void popStack(String methodName)
    {
	stack.pop();
	stack.display();
    }
}
