/* ***************************************************************************
 * NAME: QuickSort.java
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT: Data Structures and Algorithms (COMP1002)
 * PURPOSE:
 * COMMENT:
 * DATE: 2020-10-22
 * **************************************************************************/
import java.util.*;
import java.util.*;

public class QuickSort
{
    public static void main(String[] args)
    {
        int[] arr = {12, 3, 14, 9, 2, 1, 5, 21, 19};

        int[] yep = quickSortMedian3(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++)
        {
            System.out.println(yep[i]);
        }
    }

    public static int[] quickSortLeft(int[] inArray, int leftIdx, int rightIdx)
    {
        if (leftIdx < rightIdx)
        {
            int pivotIdx = leftIdx; // pivot selection: left
            int newPivotIdx = doPartitioning(inArray, leftIdx, rightIdx, pivotIdx);

            quickSortLeft(inArray, leftIdx, newPivotIdx-1); // sorting left partition
            quickSortLeft(inArray, newPivotIdx+1, rightIdx); // sorting right partition
        }

        return inArray;
    }

    public static int[] quickSortMedian3(int[] inArray, int leftIdx, int rightIdx)
    {
        if (leftIdx < rightIdx)
        {
            int midIdx = (leftIdx + rightIdx) / 2;
            int medianOfThree = calcMedianOfThree(leftIdx, midIdx, rightIdx);

            int pivotIdx = medianOfThree ; // pivot selection: median of 3
            int newPivotIdx = doPartitioning(inArray, leftIdx, rightIdx, pivotIdx);

            quickSortMedian3(inArray, leftIdx, newPivotIdx-1); // sorting left partition
            quickSortMedian3(inArray, newPivotIdx+1, rightIdx); // sorting right partition
        }
        return inArray;
    }

    public static int[] quickSortRandom(int[] inArray, int leftIdx, int rightIdx)
    {
        if (leftIdx < rightIdx)
        {
            Random rand = new Random();
            int randomIdx = rand.nextInt((rightIdx - leftIdx) + 1) + leftIdx;
            int pivotIdx = randomIdx; // pivot selection: random
            int newPivotIdx = doPartitioning(inArray, leftIdx, rightIdx, pivotIdx);

            quickSortRandom(inArray, leftIdx, newPivotIdx-1); // sorting left partition
            quickSortRandom(inArray, newPivotIdx+1, rightIdx); // sorting right partition
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
}
