#
# DSA Final Assessment Question 3 - MaxHeapTest.py
#
# Name : 
# ID   :
#
# 
from FA_Heap import *

print(“\n**** Question 3: Testing Heaps ****\n”)

testHeap = FA_Heap()
		
for i in range(0, 10):
	testHeap.add(i, i+100)
	print("Added " + str(i))

for i in range(0, 10):
	temp = testHeap.remove()
	print(temp)
    
print(“\n**** Tests Complete ****\n”)
