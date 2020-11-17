#
# DSA Final Assessment Question 4 - FA_StackTest.py
#
# Name : 
# ID   :
#
# 
from FA_Stack import *
from PracExamException import *

print(“\n**** Question 4: Testing Built-in Stack ****\n”)

mystack = FA_Stack()
testPassed = 0
numTests = 0

numTests += 1
print("Test",numTests,"- stack created and starts at count = 0", end="")
if mystack.getCount() == 0:
    testPassed += 1
    print("\t - PASSED")    

numTests += 1
print("Test",numTests,"- starts empty", end="")
if mystack.isEmpty():
    testPassed += 1
    print("\t\t\t\t - PASSED")    

mystack.push(10)
mystack.push(20)
mystack.push(30)

numTests += 1
print("Test",numTests,"- has three values after 3 pushes", end="")
if mystack.getCount() == 3:
    testPassed += 1
    print("\t - PASSED")    
    
numTests += 1
print("Test",numTests,"- stack is not empty", end="")
if not mystack.isEmpty():
    testPassed += 1
    print("\t\t\t - PASSED")    

pop1 = mystack.pop()
pop2 = mystack.pop()

numTests += 1
print("Test",numTests,"- two popped values match (30,20)", end="")
if pop1 == 30 and pop2 == 20:
    testPassed += 1
    print("\t\t - PASSED")    

numTests += 1
print("Test",numTests,"- one value left", end="")
if mystack.getCount() == 1:
    testPassed += 1
    print("\t\t\t\t - PASSED")    

top = mystack.top()

numTests += 1
print("Test",numTests,"- last popped value matches", end="")
if top == 10:
    testPassed += 1
    print("\t\t - PASSED")    

pop3 = mystack.pop()

numTests += 1
print("Test",numTests,"- empty after values popped", end="")
if mystack.isEmpty():
    testPassed += 1
    print("\t\t - PASSED")    
    
for i in range(mystack.getSize()):
    mystack.push(i)

numTests += 1
print("Test",numTests,"- overfills", end="")
try: 
    mystack.push(100)
except PracExamException:
    testPassed += 1
    print("\t\t\t\t - PASSED")    
    
        
print("\nNumber of Tests =     ", numTests)
print("Number Tests Passed = ", testPassed)
print("% Passed = ", testPassed*100/numTests)
print(“\n**** Tests Complete ****\n”)
