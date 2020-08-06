/* FILE: Sorts.java
 * AUTHOR: Connor Kuljis
 * USERNAME: 19459138
 */

/** 
** Software Technology 152
** Class to hold various static sort methods.
*/

import java.util.*;

class Sorts
{
    // bubble sort
    public static void bubbleSort(int[] A)
    {
	printArray(A, "ORIGINAL");

	int pass = 0;
	boolean sorted;

	do
	{
	    sorted = true;
	    for (int ii = 0; ii < (A.length - 1 - pass); ii++)
	    {
		if (A[ii] > A[ii+1])
		{
		    int temp = A[ii];
		    A[ii] = A[ii+1];
		    A[ii+1] = temp;
		    sorted = false;
		}
	    }
	    pass++;
	}while(!sorted);

	printArray(A, "SORTED");
	System.out.println(""); 
    }//bubbleSort()

    // selection sort
    public static void selectionSort(int[] A)
    {
	printArray(A, "ORIGINAL");

	for (int n = 0; n < A.length - 1; n++)
        {
            int minIdx = n;
            for (int j = n + 1; j < A.length; j++)
            {
                if (A[j] < A[minIdx])
                {
                    minIdx = j;
                }
            }
	    int temp = A[minIdx];
	    A[minIdx] = A[n];
	    A[n] = temp;
        }

	printArray(A, "SORTED");
	System.out.println(""); 

    }// selectionSort()

    // insertion sort
    public static void insertionSort(int[] A)
    {
	printArray(A, "ORIGINAL");

	for (int nn = 1; nn < A.length; nn ++)
	{
            int ii = nn;
            while (ii > 0 && (A[ii-1] > A[ii]))
            {
                int temp = A[ii];
                A[ii] = A[ii - 1];
                A[ii - 1] = temp;
                ii--;
            }
        }
	printArray(A, "SORTED");
	System.out.println(""); 
    }// insertionSort()

    // mergeSort - front-end for kick-starting the recursive algorithm
    public static void mergeSort(int[] A)
    {
    }//mergeSort()
    private static void mergeSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
    }//mergeSortRecurse()
    private static void merge(int[] A, int leftIdx, int midIdx, int rightIdx)
    {
    }//merge()


    // quickSort - front-end for kick-starting the recursive algorithm
    public static void quickSort(int[] A)
    {
    }//quickSort()
    private static void quickSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
    }//quickSortRecurse()
    private static int doPartitioning(int[] A, int leftIdx, int rightIdx, int pivotIdx)
    {
		return 0;	// TEMP - Replace this when you implement QuickSort
    }//doPartitioning

    private static void printArray(int[] myArr, String type)
    {
	System.out.println(type + " VALUES: "); 

	for (int i = 0; i < myArr.length; i++)
	{
	    System.out.print(myArr[i] + " "); 
	}
	System.out.println(""); 
    }


}//end Sorts calss
