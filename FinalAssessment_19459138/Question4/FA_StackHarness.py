#
# DSA Final Assessment Question 4 - FA_StackTest.py
#
# Name : 
# ID   :
#
# 
from stack import *

print("\n --- FA Stack Test Harness ---")

mystack = FA_Stack()
testPassed = 0
numTests = 0

numTests += 1
if mystack.getCount() == 0:
    testPassed += 1

numTests += 1
if mystack.isEmpty():
    testPassed += 1

mystack.push(10)
mystack.push(20)
mystack.push(30)

numTests += 1
if mystack.getCount() == 3:
    testPassed += 1
    
numTests += 1
if not mystack.isEmpty():
    testPassed += 1

pop1 = mystack.pop()
pop2 = mystack.pop()

numTests += 1
if pop1 == 20 and pop2 == 30:
    testPassed += 1

numTests += 1
if mystack.getCount() == 1:
    testPassed += 1

pop3 = mystack.pop()

numTests += 1
if pop3 == 10 and mystack.isEmpty():
    testPassed += 1
    
print("Number of Tests =     ", numTests)
print("Number Tests Passed = ", testPassed)
print("% Passed = ", testPassed*100/numTests)