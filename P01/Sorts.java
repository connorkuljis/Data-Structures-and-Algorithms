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
    }//bubbleSort()

    // selection sort
    public static void selectionSort(int[] A)
    {
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
    }// selectionSort()

    // insertion sort
    public static void insertionSort(int[] A)
    {
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
    }// insertionSort()

    // mergeSort - front-end for kick-starting the recursive algorithm
    // to start the recursive algorithm
    public static void mergeSort(int[] A)
    {
	mergeSortRecurse( A, 0, A.length - 1 ); 
    }//mergeSort()

    private static void mergeSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
	if (leftIdx == rightIdx) // if range is 1, no use sorting
	{
	    return;
	}

	int middle = ( leftIdx + rightIdx ) / 2; // finding the midpoint

	mergeSortRecurse( A, leftIdx, middle );       // sort the low half
	mergeSortRecurse( A, middle + 1, rightIdx );  // sort the top half
	merge( A, leftIdx, middle + 1, rightIdx );    // merging the sorted halves       

    }//mergeSortRecurse()
    private static void merge(int[] A, int leftIdx, int midIdx, int rightIdx)
    {
	int j = 0;

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

	for (int i = 0; i < 10; i++)
	{
	    System.out.println(myArr[i] + " "); 
	}
	System.out.println(""); 
    }
}//end Sorts class
