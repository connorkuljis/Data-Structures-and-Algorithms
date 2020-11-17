// FA_RecursionHarness: Test harness created as per question 1a
// bit of DRY but it works
import java.util.*;

public class FA_RecursionHarness
{
    public static void main(String[] args)
    {
	int[] inputValues = {10,20,30,40,50,60,70};

	printHeader(inputValues);

	printIterativeFactorial(inputValues);

	printRecursiveFactorial(inputValues);

	printIterativeFibonacci(inputValues);

	printRecursiveFibonacci(inputValues);
    }

    private static void printHeader(int[] inputValues)
    {
	System.out.print("Algorithm\t"); 
	for(int i = 0; i < inputValues.length; i++)
	{
	    System.out.print("|\t" + inputValues[i] + "\t"); 
	}
	System.out.println(""); 
    }

    private static void printIterativeFactorial(int[] inputValues)
    {
	System.out.print("It. Fact\t"); 
	for(int i = 0; i < inputValues.length; i++)
	{
	    System.out.print("|\t" + Factorial.testIterative(inputValues[i]) + "\t"); 
	}
	System.out.println(""); 
    }


    private static void printRecursiveFactorial(int[] inputValues)
    {
	System.out.print("Rec. Fact\t"); 
	for(int i = 0; i < inputValues.length; i++)
	{
	    System.out.print("|\t" + Factorial.testRecursive(inputValues[i]) + "\t"); 
	}
	System.out.println(""); 
    }

    private static void printIterativeFibonacci(int[] inputValues)
    {
	System.out.print("It. Fib\t\t"); 
	for(int i = 0; i < inputValues.length; i++)
	{
	    System.out.print("|\t" + Fibonacci.testIterative(inputValues[i]) + "\t"); 
	}
	System.out.println(""); 
    }

    private static void printRecursiveFibonacci(int[] inputValues)
    {
	System.out.print("Rec. Fib\t"); 
	for(int i = 0; i < inputValues.length; i++)
	{
	    System.out.print("|\t" + Fibonacci.testRecursive(inputValues[i]) + "\t"); 
	}
	System.out.println(""); 
    }









}
