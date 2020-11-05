# Prac 11 - DSA IN PRACTICE Findings

## Intro
Advanced sorting algorithms
- shellsort
- countsort
- radixsort

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
The results are the average of 4 runs for each sort type.

## Results
* Mergesort		68832.33333333333
* QuickSort		-
    left 		39954.333333333336
    median of three  	32914.0
    random		29826.333333333332



## Conclusion


