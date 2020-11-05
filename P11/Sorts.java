/* **************************************************************************
 * FILE: Sorts.java
 * AUTHOR: Connor Kuljis
 * USERNAME: 19459138
 * Software Technology 152
 * Class to hold various static sort methods.
 * **************************************************************************/

import java.util.*;

class Sorts {
	public static void bubbleSort(int[] A) {
		int pass = 0;
		boolean sorted;
		do {
			sorted = true;
			for (int ii = 0; ii < (A.length - 1 - pass); ii++) {
				if (A[ii] > A[ii + 1]) {
					int temp = A[ii];
					A[ii] = A[ii + 1];
					A[ii + 1] = temp;
					sorted = false;
				}
			}
			pass++;
		} while (!sorted);
	}

	public static void bubbleSort(Person[] A) {
		int pass = 0;
		boolean sorted;
		do {
			sorted = true;
			for (int ii = 0; ii < (A.length - 1 - pass); ii++) {
				if (A[ii].getID() > A[ii + 1].getID()) {
					Person temp = A[ii];
					A[ii] = A[ii + 1];
					A[ii + 1] = temp;
					sorted = false;
				}
			}
			pass++;
		} while (!sorted);
	}

	public static void selectionSort(int[] A) {
		for (int n = 0; n < A.length - 1; n++) {
			int minIdx = n;
			for (int j = n + 1; j < A.length; j++) {
				if (A[j] < A[minIdx]) {
					minIdx = j;
				}
			}
			int temp = A[minIdx];
			A[minIdx] = A[n];
			A[n] = temp;
		}
	}

	public static void selectionSort(Person[] A) {
		for (int n = 0; n < A.length - 1; n++) {
			int minIdx = n;
			for (int j = n + 1; j < A.length; j++) {
				if (A[j].getID() < A[minIdx].getID()) {
					minIdx = j;
				}
			}
			Person temp = A[minIdx];
			A[minIdx] = A[n];
			A[n] = temp;
		}
	}

	public static void insertionSort(int[] A) {
		for (int nn = 1; nn < A.length; nn++) {
			int ii = nn;
			while (ii > 0 && (A[ii - 1] > A[ii])) {
				int temp = A[ii];
				A[ii] = A[ii - 1];
				A[ii - 1] = temp;
				ii--;
			}
		}
	}

	public static void insertionSort(Person[] A) {
		for (int nn = 1; nn < A.length; nn++) {
			int ii = nn;
			while (ii > 0 && (A[ii - 1].getID() > A[ii].getID())) {
				Person temp = A[ii];
				A[ii] = A[ii - 1];
				A[ii - 1] = temp;
				ii--;
			}
		}
	}

	// mergeSort - front-end for kick-starting the recursive algorithm
	// to start the recursive algorithm
	public static void mergeSort(int[] A) {
		printArray(A);
		mergeSortRecurse(A, 0, A.length - 1);

		printArray(A);
		System.out.println("");
	}

	// Merge Sort is known as a divide and conquer algorithm
	private static void mergeSortRecurse(int[] A, int leftIdx, int rightIdx) {
		/*
		* base case to terminate the recursion, it ends when there is the indexes are
		* the same, signaling that the 'cell' size = 1 and there is no further merge to
		* be done
		*/
		if (leftIdx < rightIdx) 
		{
			int middle = (leftIdx + rightIdx) / 2; // finding the midpoint

			mergeSortRecurse(A, leftIdx, middle); // sort the low half
			mergeSortRecurse(A, middle + 1, rightIdx);// sort the top half
			merge(A, leftIdx, middle, rightIdx); // merging the sorted halves
		}
	}

	/* this merge is also known as a two way merge */
	private static void merge(int[] A, int leftIdx, int midIdx, int rightIdx) {
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
			} else {
				A[k] = R[j];
				j++;
			}
			k++;
		}
		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			A[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			A[k] = R[j];
			j++;
			k++;
		}
	}

	public static void quickSortLeft(int[] A)
	{
		A = quickSortLeftRecur(A, 0, A.length-1);
		printArray(A);
	}

	public static int[] quickSortLeftRecur(int[] inArray, int leftIdx, int rightIdx)
    {
        if (leftIdx < rightIdx)
        {
            int pivotIdx = leftIdx; // pivot selection: left
            int newPivotIdx = doPartitioning(inArray, leftIdx, rightIdx, pivotIdx);

            quickSortLeftRecur(inArray, leftIdx, newPivotIdx-1); // sorting left partition
            quickSortLeftRecur(inArray, newPivotIdx+1, rightIdx); // sorting right partition
        }

        return inArray;
    }

	public static void quickSortMedian3(int[] A)
	{
		A = quickSortMedian3Recur(A, 0, A.length-1);
		printArray(A);
	}

    public static int[] quickSortMedian3Recur(int[] inArray, int leftIdx, int rightIdx)
    {
        if (leftIdx < rightIdx)
        {
            int midIdx = (leftIdx + rightIdx) / 2; // pivor selection: middle
            int medianOfThree = calcMedianOfThree(leftIdx, midIdx, rightIdx);

            int pivotIdx = medianOfThree ; // pivot selection: median of 3
            int newPivotIdx = doPartitioning(inArray, leftIdx, rightIdx, pivotIdx);

            quickSortMedian3Recur(inArray, leftIdx, newPivotIdx-1); // sorting left partition
            quickSortMedian3Recur(inArray, newPivotIdx+1, rightIdx); // sorting right partition
        }
        return inArray;
    }

	public static void quickSortRandom(int[] A)
	{
		A = quickSortRandomRecur(A, 0, A.length-1);
		printArray(A);
	}

    public static int[] quickSortRandomRecur(int[] inArray, int leftIdx, int rightIdx)
    {
        if (leftIdx < rightIdx)
        {
            Random rand = new Random();
            int randomIdx = rand.nextInt((rightIdx - leftIdx) + 1) + leftIdx;
            int pivotIdx = randomIdx; // pivot selection: random
            int newPivotIdx = doPartitioning(inArray, leftIdx, rightIdx, pivotIdx);

            quickSortRandomRecur(inArray, leftIdx, newPivotIdx-1); // sorting left partition
            quickSortRandomRecur(inArray, newPivotIdx+1, rightIdx); // sorting right partition
        }

        return inArray;
    }

    private static int calcMedianOfThree(int a, int b, int c)
    {
        int median = 0;
        if ((a > b) != (a > c))
        {
            median = a; 
        }
        if ((b > a) != (b > c))
        {
            median = b;
        }
        else 
        {
            median = c;
        }
        return median;
    }

    private static int doPartitioning(int[] inArray, int leftIdx, int rightIdx, int pivIdx)
    {
        int pivotVal = inArray[pivIdx];
        inArray[pivIdx] = inArray[rightIdx]; // swap with left most element
        inArray[rightIdx] = pivotVal;

        int curIdx = leftIdx;
        for (int i = leftIdx; i < rightIdx; i++)
        {
            if (inArray[i] < pivotVal)
            {
                int temp = inArray[i];
                inArray[i] = inArray[curIdx];
                inArray[curIdx] = temp;
                curIdx++;
            }
        }

        int newPivotIdx = curIdx;
        inArray[rightIdx] = inArray[newPivotIdx]; // set to right side
        inArray[newPivotIdx] = pivotVal;

        return newPivotIdx;
    }

    public static void shellSort(int[] arr)
    {
	int n = arr.length;

	for (int gap = n/2; gap > 0; gap /= 2)
	{
	    for (int i = gap; i < n; i++)
	    {
		int temp = arr[i];

		int j;
		for (j = i; ((j >= gap) && (arr[j-gap] > temp)); j -= gap)
		{
		    arr[j] = arr[j - gap];
		}

		arr[j] = temp;
	    }
	}
    }

    public static void countSort(int[] arr)
    {
	int n = arr.length;
	int[] result = new int[n];
	int largestSize = maxElementInArr(arr);
	

	int[] count = new int[largestSize + 1];

	// init the count array
	for (int i = 0; i < largestSize; i++)
	{
	    count[i] = 0;
	}
	
	// store the count of each number
	for (int i = 0; i < n; ++i)
	{
	    ++count[arr[i]];
	}

	// sum the previous totals
	for (int i = 1; i <= largestSize; ++i)
	{
	    count[i] += count[i-1];
	}

	// creating the result array, going backwards
	for (int i = n-1; i >= 0; i--)
	{
	    result[count[arr[i]] - 1] = arr[i];
	    --count[arr[i]];
	}

	// copy the array
	for (int i = 0; i < n; ++i)
	{
	    arr[i] = result[i];
	}
    }

    private static int maxElementInArr(int[] arr)
    {
	int largestSize = arr[0];
	for (int i = 0; i < arr.length; i++) // iterate to find the largest element in the array
	{
	    if (arr[i] > largestSize) // just update the largest element
	    {
		largestSize = arr[i];
	    }
	}
	return largestSize;
    }

    public static void radixSort(int[] arr)
    {
	int n = arr.length, m = maxElementInArr(arr);

	for (int exp = 1; (m / exp) > 0; exp *= 10) // incrementing by digit (base10)
	{
	    countSortExp(arr, exp);
	}

	printArray(arr);
    }



    public static void countSortExp(int[] arr, int exp)
    {
	int n = arr.length;
	int[] result = new int[n];
	int largestSize = 10; // 10 represents the 10 possible digits
	

	int[] count = new int[largestSize + 1];

	// init the count array
	for (int i = 0; i < largestSize; i++)
	{
	    count[i] = 0;
	}
	
	// store the count of each number
	for (int i = 0; i < n; ++i)
	{
	    // ++count[arr[i]];
	    count[(arr[i] / exp) % 10]++;
	}

	// sum the previous totals
	for (int i = 1; i <= largestSize; ++i)
	{
	    count[i] += count[i-1];
	}

	// creating the result array, going backwards
	for (int i = n-1; i >= 0; i--)
	{
	    //result[count[arr[i]] - 1] = arr[i];
	    //--count[arr[i]];
	    result[count[(arr[i] / exp) % 10] - 1] = arr[i];
	    count[(arr[i] / exp) % 10]--;
	}

	// copy the array
	for (int i = 0; i < n; ++i)
	{
	    arr[i] = result[i];
	}
    }



















	private static void printArray(int[] myArr) {
		for (int i = 0; i < myArr.length; i++) {
			System.out.print(myArr[i] + " ");
		}
		System.out.println("");
	}
}// end Sorts class
