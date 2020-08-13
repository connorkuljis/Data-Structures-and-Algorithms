/* **************************************************************************
 * FILE: Sorts.java
 * AUTHOR: Connor Kuljis
 * USERNAME: 19459138
 * Software Technology 152
 * Class to hold various static sort methods.
 * **************************************************************************/

import java.util.*;

class Sorts
{
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
    }

    public static void bubbleSort(Person[] A)
    {
	int pass = 0;
	boolean sorted;
	do
	{
	    sorted = true;
	    for (int ii = 0; ii < (A.length - 1 - pass); ii++)
	    {
		if (A[ii].getID() > A[ii+1].getID())
		{
		    Person temp = A[ii];
		    A[ii] = A[ii+1];
		    A[ii+1] = temp;
		    sorted = false;
		}
	    }
	    pass++;
	}while(!sorted);
    }

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
    }

    public static void selectionSort(Person[] A)
    {
	for (int n = 0; n < A.length - 1; n++)
        {
            int minIdx = n;
            for (int j = n + 1; j < A.length; j++)
            {
                if (A[j].getID() < A[minIdx].getID())
                {
                    minIdx = j;
                }
            }
	    Person temp = A[minIdx];
	    A[minIdx] = A[n];
	    A[n] = temp;
        }
    }

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
    }

    public static void insertionSort(Person[] A)
    {
	for (int nn = 1; nn < A.length; nn ++)
	{
            int ii = nn;
            while (ii > 0 && (A[ii-1].getID() > A[ii].getID()))
            {
                Person temp = A[ii];
                A[ii] = A[ii - 1];
                A[ii - 1] = temp;
                ii--;
            }
        }
    }

    // mergeSort - front-end for kick-starting the recursive algorithm
    // to start the recursive algorithm
    public static void mergeSort(int[] A)
    {
	printArray(A);
	mergeSortRecurse( A, 0, A.length - 1 ); 

	printArray(A);
	System.out.println(""); 
    }

    // Merge Sort is known as a divide and conquer algorithm
    private static void mergeSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
	if (leftIdx < rightIdx) /* base case to terminate the recursion,
				   it ends when there is the indexes are the
				   same, signaling that the 'cell' size = 1
				   and there is no further merge to be done */
	{
	    int middle = ( leftIdx + rightIdx ) / 2; // finding the midpoint

	    mergeSortRecurse( A, leftIdx, middle );   // sort the low half
	    mergeSortRecurse( A, middle + 1, rightIdx );// sort the top half
	    merge( A, leftIdx, middle, rightIdx ); // merging the sorted halves       
	}
    }

    /* this merge is also known as a two way merge */
    private static void merge(int[] A, int leftIdx, int midIdx, int rightIdx)
    {
	/* declaring sizes of sub arrays */
	int n1 = (midIdx - leftIdx) + 1; // size of the left array
	int n2 = (rightIdx - midIdx); // size of the right array
	// n1 and n2 as if the array is odd length

	int L[] = new int[n1];
	int R[] = new int[n2];

	
	for (int i = 0; i < n1; i++) // iterating from start to half
	{
	    L[i] = A[leftIdx + i]; // assign values to left array

	}
	for (int j = 0; j < n2; j++) // iterating from half + 1 to end
	{
	    R[j] = A[midIdx + 1 + j]; // assign values to right array
	}

	/* reset indexes for loops */
	int i = 0; // left array 'pointer'
	int j = 0; // right array 'pointer'

	int k = leftIdx; 
	while (i < n1 && j < n2) // comparing the elements in left/right array
	{
	    if (L[i] <= R[j]) // 
	    {
		A[k] = L[i]; // this is the smallest value atm
		i++; // move left pointer if left element <= right element
	    }
	    else
	    {
		A[k] = R[j];
		j++;
	    }
	    k++;
	}
	/* Copy remaining elements of L[] if any */
        while (i < n1) 
	{ 
            A[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
	{ 
            A[k] = R[j]; 
            j++; 
            k++; 
        } 
    }

    // quickSort - front-end for kick-starting the recursive algorithm
    public static void quickSort(int[] A)
    {
	printArray(A);
	quickSortRecurse(A, 0, A.length-1);

	printArray(A);
	System.out.println(""); 
    }

    private static void quickSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
	if (leftIdx < rightIdx)
	{
	    int partitionIdx = doPartitioning(A, leftIdx, rightIdx, leftIdx-1);
	}
    }

    private static int doPartitioning(int[] A, int leftIdx, int rightIdx, 
	                              int pivotIdx)
    {
	return 0; // TEMP - Replace this when you implement QuickSort
    }//doPartitioning

    private static void printArray(int[] myArr)
    {
	for (int i = 0; i < myArr.length; i++)
	{
	    System.out.print(myArr[i] + " "); 
	}
	System.out.println(""); 
    }
}//end Sorts class
