#
# DSA Final Assessment Question 5 - FA_Graph.py
#
# Name : 
# ID   :
#
# 
class FA_ListNode():
    def __init__(self, val):
        self.val = val
        self._next = None
    
    def __str__(self):
        return str(self.val)
    
class FA_LinkedList():
    def __init__(self):
        self.head = None
        self.tail = None
        self.count = 0
        
    def insertLast(self, value):
        self.count = self.count + 1
        if self.head == None:
            self.head = FA_ListNode(value)
            self.tail = self.head
        else:    
            self.tail._next = FA_ListNode(value)
            self.tail = self.tail._next
        
    def __str__(self):
        returnStr = ""
        for l in self:
            thisone = l.label
            ##print(thisone)
            returnStr = returnStr + " " + thisone
        return returnStr
        
    def __iter__(self):
        self.cursor = self.head
        return self
        
    def __next__(self):
        curval = None
        if self.cursor == None:
            raise StopIteration()
        else: 
            curval = self.cursor.val  # dumb error was here
            self.cursor = self.cursor._next
        return curval
  
        
class FA_Vertex():
    def __init__(self, label):
        self.links = FA_LinkedList()
        self.label = label
        self.count = 0
        #self.contents = contents
        self.visited = False

    def getLabel(self):
        return self.label
    
    def getValue(self):
        return self.contents
    
    def getAdjacent(self):
        return self.links
    
    def addEdge(self, vertex):
        self.links.insertLast(vertex)
        
    def getVisited(self):
        return self.visited

    def setVisited(self):
        self.visited = True

    def clearVisited(self):
        self.visited = False
    
    def __str__(self):
        return self.label + " links: " + str(self.links)
    
        
class FA_Graph():

    def __init__(self):
        self.vertices = FA_LinkedList()
        self.count = 0

    def addVertex(self, label):
        if not self.hasVertex(label):
            self.vertices.insertLast(FA_Vertex(label))

    def addEdge(self, label1, label2):
        self.addVertex(label1)  # won't add if already there
        self.addVertex(label2)
        v1 = self.getVertex(label1)
        v2 = self.getVertex(label2)
        v1.addEdge(v2)
        #v2.addEdge(v1)
        
    def getVertex(self, label):   ## Not on slides
        returnval = None
        for v in self.vertices:
            if v.label == label:
                returnval = v
        return returnval
        
    def hasVertex(self, label):
        returnval = False
        for v in self.vertices:
            if v.label == label:
                returnval = True
        return returnval
        
    def getVertexCount(self):
        return self.vertices.count
    

    def displayAsMatrix(self): 
        ...
            
    def displayWeightMatrix(self):
        ...
        
