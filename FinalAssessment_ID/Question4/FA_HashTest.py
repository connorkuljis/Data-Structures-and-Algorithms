#
# DSA Final Assessment Question 4 - FA_HashTest.py
#
# Name : 
# ID   :
#
# 
from FA_HashTable import *

print(“\n**** Question 4: Testing Hash Tables ****\n”)

tab = FA_HashTable(20)
data = ["11111112", "11111121", "11111211", "11112111", "11121111", "11211111", "12111111", "21111111"]
print("Table size is: " + str(tab.getArrayLength()) )

for i in range (0, len(data)):
	tab.put(data[i], "O"+data[i])	

tab.display()
print("Load Factor is: " + str(tab.getLoadFactor()) )

print(“\n**** Tests Complete ****\n”)
