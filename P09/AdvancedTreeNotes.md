# Advanced Trees

# Types of Advanced Trees
* Red-Black Trees
* 2-3-4 Trees
* B Trees

# Recap
Binary Search Trees run in O(log n) time. ( fast )
They can degrade to O(n) "linear time", depending on the data. ( slow down )
Eg: input of [12,13,14,17] will degrade a BST as they stack on the right, as elements are increasing in value.
- To traverse to '14' it will take n(3) aka the height of '14' in the tree.
- This is called a degenerate tree.
- But we want a balanced/complete/semi-complete tree.

# Red-Black Trees

# 2-3-4 Trees
- Each node can store 1,2 or 3 entries
- Number of children is equal to number of entries + 1, else its zero

# Answers 
using the example data = [10,5,50,35,40]
1. The height of threes trees are smaller bst = 4
2.
