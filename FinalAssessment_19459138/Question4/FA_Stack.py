#
# DSA Final Assessment Question 4 - FA_Stack.py
#
# Name : 
# ID   :
#
# 
import numpy as np
from PracExamException import *


class FA_Stack:

    def __init__(self, capacity=50):
        self.stack = np.empty(capacity, object)
        self.count = 0

    def getCount(self):
        return self.count
        
    def getSize(self):
        return len(self.stack)
    
    def isEmpty(self):
        return self.count == 0

    def isFull(self):
        return self.count == len(self.stack)

    def push(self, value):
        if self.isFull():
            raise PracExamException
        else:
            self.stack[self.count] = value
            self.count += 1

    def top(self):
        if self.isEmpty():
            raise PracExamException
        else:
            topval = self.stack[self.count - 1]
        return topval

    def pop(self):
        topval = self.top()
        self.count += -1
        return topval
