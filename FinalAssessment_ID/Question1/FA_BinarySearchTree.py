#
# DSA Final Assessment Question 1 - FA_BinarySearchTree.py
#
# Name : 
# ID   :
#
# 
class FA_TreeNode():
	def __init__(self, value):
		self.value = value
		self.left = None
		self.right = None

class FA_BinarySearchTree():

	def __init__(self):
		self.root = None
	
	def insert(self, val):
		if (self.isEmpty()):
			self.root = FA_TreeNode(val)
		else:
			self.root = self.insertRec(val, self.root)

	def isEmpty(self):
		return self.root == None

	def insertRec(self, inVal, cur):
		if (cur == None):
			cur = FA_TreeNode(inVal)
		else:
			if (inVal < cur.value):
				cur.left = self.insertRec(inVal, cur.left)
			else:
				cur.right = self.insertRec(inVal, cur.right)
		return cur
		
			
