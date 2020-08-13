public class MergeSort
{
    public static void main(String[] args)
    {
	int[] A = {27, 56, 2, 12, 32, 65, 128, 15};
	System.out.println("Given Array: "); 
	printArray(A);

	mergeSort(A, 0, A.length-1);

	System.out.println("Sorted Array: "); 
	printArray(A);
    }

    public static void mergeSort(int[] A, int left, int right)
    {
	if (left < right) /* if the left is less than the right, the array is 
			     large and still needs to be recusively split */
	{
	    int mid = (left + right) / 2;

	    mergeSort(A, left, mid); /* first recursive method to be placed on
					the stack */
	    mergeSort(A, mid+1, right); 
	    merge(A, left, mid, right);
	}
    }

    /* merge is post-order traversal (binary trees) */
    public static void merge(int[] A, int left, int mid, int right)
    {
	/* declaring sizes of sub arrays */
	int n1 = (mid - left) + 1;
	int n2 = (right - mid);

	int L[] = new int[n1];
	int R[] = new int[n2];

	for (int i = 0; i < n1; i++)
	{
	    L[i] = A[left + i];

	}
	for (int j = 0; j < n2; j++)
	{
	    R[j] = A[mid + 1 + j];
	}

	/* reset indexes for loops */
	int i = 0;
	int j = 0;

	int k = left;
	while (i < n1 && j < n2)
	{
	    if (L[i] <= R[j])
	    {
		A[k] = L[i];
		i++;
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

    public static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
}
