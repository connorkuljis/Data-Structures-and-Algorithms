/**
 * DSA Final Assessment Question 4 - FA_StackTest.java                             4
 *
 * Name : Connor Kuljis	
 * ID   : 19459138
 *
 * tests 2,4 have been removed as inbuilt stack has no limit in the constructor, it is implemented as a list
 * 	a limit can be set by creating own helper function in class if neccessary
 * 	referenced for methods : https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html
 **/
import java.util.*;


public class FA_StackTest
{
    public static void main(String[] args) 
    {

        // Test Variables
        int stackSize = 50;
        int testsPassed = 0;
        int numTests = 0; 
        // FA_Stack testStack = null;
	Deque<Integer> testStack;
        Object stackElement;

        System.out.println("\n**** Question $: Testing Built-in Stacks ****\n");

	testStack = new ArrayDeque<Integer>();
        try
        {
            numTests++;
            System.out.print( "Test 1 - stack created             : " );

            // if ( testStack.getCount() != 0 )
             if ( testStack.size() != 0 )
            {
                throw new PracExamException( "Error: getCount should be 0" );
            }

            if ( !testStack.isEmpty() )
            {
                throw new PracExamException( "Error: isEmpty should be true" );
            }

	    /*
	     * there is no isFull function as it inherits as a abstract list eg (no maximum size of list)
            if ( testStack.isFull() )
            {
                throw new PracExamException( "Error: isFull should be false" );
            }
	    */

            testsPassed++;
            System.out.println( "Passed" );
        }
        catch(PracExamException e)
        {
            System.out.println( "Failed" + e.getMessage() );
        } 

	/* CANNOT SET MAX SIZE OF STACK - WITHOUT USE OF HELPER FUNCION
        try
        {
            numTests++;

            System.out.print( "Test 2 - stack created set size    : " );
            testStack = new FA_Stack(stackSize);

            if ( testStack.getCount() != 0 )
            {
                throw new PracExamException( "Error: getCount should be 0" );
            }

            if ( !testStack.isEmpty() )
            {
                throw new PracExamException( "Error: isEmpty should be true" );
            }

            if ( testStack.isFull() )
            {
                throw new PracExamException( "Error: isFull should be false" );
            }

            testsPassed++;
            System.out.println( "Passed" );
        }
        catch(PracExamException e)
        {
            System.out.println( "Failed" + e.getMessage() );
        } 
	*/

        try 
        {
            numTests++;

            System.out.print( "Test 3 - pushing values     (10,20,30)       : " );

            testStack.push( 10 );
            testStack.push( 20 );
            testStack.push( 30 );

            // if ( !testStack.top().equals(30) )
            if ( !testStack.peek().equals(30) )
            {
                throw new PracExamException( 
                        "top() returned incorrect element" );
            }
            testsPassed++;
            System.out.println( "Passed" );
		}
        catch ( PracExamException e ) {
            System.out.println( "Test " + numTests + " Failed: "+ e.getMessage() );
        }

	/* there is no limit on the built in stack
	 *
        try 
        {
	    testStack = new ArrayDeque<Integer>();
            numTests++;

            System.out.print( "Test 4 - pushing values to limit   : " );

            for ( int ii = 3; ii <= testStack.size(); ii++ )
            {
                testStack.push( ii );
            }

            testStack.push( 100 );
            System.out.println( "Test " + numTests + " Failed: push() didn't throw exception" );

        } 
        catch( PracExamException e )
        {
                testsPassed++;
                System.out.println( "Passed" );
        }
	*/

        try 
        {
            numTests++;
            System.out.print( "Test 5 - popping values            : " );

            System.out.print(testStack.pop()); // testing the pop method
            testsPassed++; // if we get to here the pop operation was successful
            System.out.println( "Passed" );
	}
        catch( Exception e ) // go here if pop() encounters exception
        {
             System.out.println( "Test " + numTests + " Failed: pop() didn't throw exception" );
        }
        
        


        System.out.println( "------ FA Stack Test Harness ------" );
        System.out.println( "Number of Tests:        " + numTests );
        System.out.println( "Number of Tests Passed: " + testsPassed );
        System.out.println( "              % Passed: " + 100*testsPassed/numTests + "%");
        System.out.println("\n**** Tests Complete ****\n");


    }

}
