# Sorting Prac Findings

## Intro
The practical introduced the three basic sorting algorithms; Bubble, Insertion 
and Selection sort.

The sorts are known as 'in-place' sorting algorithms meaning no extra arrays 
(memory/RAM) is needed.

## Big-O Notation
Big-O notation is intended to describe how an algorithm scales for variable 
size input.

These alogrithms are all O(n^2) in average case. They are n^2 as the use of 
double nested loops. 

This means for each element in the outer loop, there 
could be n times iteration within the inner loop.

## Exploring Run Times
Sample size n=8192	

Results;
Bubble, 84001.333 
Insertion, 10741.000 
Selection, 21785.668

The results are the average of 4 runs for each sort type.

## Conclusion
From the results, Bubble sort performed the slowest, followed by Selection and
similaly Insertion - which was the fastest.

My conclusions is that Bubble sort runs the slowest due to the fact it passes 
over the array many many times. Whereas other sorts can separate out already 
sorted elements - not having to loop over them repeatedly.

Selction sort ran the second best - much better than bubble sort. Again I thin
k this is due to the fact selection sort essentially defines the array into 
segments: sorted and unsorted. Each pass makes the unsorted 'half' smaller and
smaller each time.

Insertion sort ran the best - although not as large of a difference to 
selection when compared to bubble sort. I think the times are similar due to
similar characteristics such as having a 'sorted' and 'unsorted' part of the
array. The values from the unsorted part and picked and placed in the correct
position in the sorted part.


