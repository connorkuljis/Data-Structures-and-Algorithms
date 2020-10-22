# Sorting Prac Findings

## Intro
Advanced sorting algorithms
- mergesort
- quicksort

## Big-O Notation
Big-O notation is intended to describe how an algorithm scales for variable 
size input.

(the fastest possible sorting time for a set is O(n))

Previous alogrithms were all O(n^2) in average case. They are n^2 as the use of 
double nested loops. 

Whereas mergesort and quicksort are O(n Log n), as we copy N elements at each level in recursion.
And comparisons can in each level will be less than N. (splitting by logN).
Recurisve splitting is natural log of N (log2N)

Recursive functions can cause increased space complexity on the stack, and are limited by the stack size
After the sorting the stacks are free'd from memory


## Exploring Run Times
Random Values
Sample size n=8192	

Results;
mergesort	68832.33333333333

QuickSort and its Variants
left 		39954.333333333336
median of three 32914.0
random		29826.333333333332

The results are the average of 4 runs for each sort type.

## Conclusion
In conclusion quicksort was much faster than mergesort.
I think mergesort is slower, as no matter the best/worst/avg case 
it is always splitting by natural log of N.

Whereas quicksort while still splitting at log2N levels, can in a best case ignore 
previous pivots if already sorted.

Amongst the different implementations of quicksort pivoting from the left was
the slowest as suspected from the lecture notes, followed by median of three 
and similarly random, which was the fastest.

Left pivot is relatively slow as splits can be uneven.
Median was second slowest, maybe due to having the calculate the median each time.
Random was the most efficient, but this can vary depending on the order


