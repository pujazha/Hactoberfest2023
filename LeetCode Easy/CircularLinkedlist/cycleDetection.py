class Node:

	
	def __init__(self, data):
		self.data = data
		self.next = None


class LinkedList:
	def __init__(self):
		self.head = None
	def push(self, new_data):
		new_node = Node(new_data)
		new_node.next = self.head
		self.head = new_node
        
	def printList(self):
		temp = self.head
		while(temp):
			print(temp.data, end=" ")
			temp = temp.next

	def detectLoop(self):
		s = set()
		temp = self.head
		while (temp):

			if (temp in s):
				return True

			s.add(temp)

			temp = temp.next

		return False


llist = LinkedList()
llist.push(20)
llist.push(4)
llist.push(15)

llist.head.next.next.next.next = llist.head

if(llist.detectLoop()):
	print("Loop Found")
else:
	print("No Loop ")

