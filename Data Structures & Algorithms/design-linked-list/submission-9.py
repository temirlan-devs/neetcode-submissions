class ListNode:
    def __init__(self, val):
        self.val = val
        self.next = None
        self.prev = None

class MyLinkedList:

    # O(1) - time
    def __init__(self):
        self.head = ListNode(0)
        self.tail = ListNode(0)
        self.head.next = self.tail
        self.tail.prev = self.head
        

    # O(n) - time
    def get(self, index: int) -> int:
        cur = self.head.next

        while cur and index > 0:
            cur = cur.next
            index -= 1
        
        if cur and cur != self.tail:
            return cur.val
        
        return -1

    # O(1) - time
    def addAtHead(self, val: int) -> None:
        node, prv, nxt = ListNode(val), self.head, self.head.next

        prv.next = node
        node.prev = prv
        node.next = nxt
        nxt.prev = node

    # O(1) - time
    def addAtTail(self, val: int) -> None:
        node, prv, nxt = ListNode(val), self.tail.prev, self.tail

        prv.next = node
        node.prev = prv
        node.next = nxt
        nxt.prev = node

    # O(n) - time
    def addAtIndex(self, index: int, val: int) -> None:
        cur = self.head.next

        while cur and index > 0:
            cur = cur.next
            index -= 1

        if cur:
            node, prv, nxt = ListNode(val), cur.prev, cur

            prv.next = node
            node.prev = prv
            node.next = nxt
            nxt.prev = node

    # O(n) - time
    def deleteAtIndex(self, index: int) -> None:
        cur = self.head.next

        while cur and index > 0:
            cur = cur.next
            index -= 1

        if cur and cur != self.tail:
            prv, nxt = cur.prev, cur.next
            prv.next = nxt
            nxt.prev = prv

# Time complexity: O(1) for addAtHead(), addAtTail(); O(n) for get(), addAtIndex(), deleteAtIndex()
# Space complexity: O(n), where n is the number of nodes
        


# Your MyLinkedList object will be instantiated and called as such:
# obj = MyLinkedList()
# param_1 = obj.get(index)
# obj.addAtHead(val)
# obj.addAtTail(val)
# obj.addAtIndex(index,val)
# obj.deleteAtIndex(index)
    
'''

Test

0 <-> 0

addAtHead(3):
node = 3
prv = 0
nxt = 0

0 <-> 3 <-> 0

addAtHead(2):
node = 2
prv = 0
nxt = 3

0 <-> 2 <-> 3 <-> 0

addAtHead(1):
node = 1
prv = 0
nxt = 2

0 <-> 1 <-> 2 <-> 3 <-> 0

addAtTail(4):
node = 4
prv = 3
nxt = 0

0 <-> 1 <-> 2 <-> 3 <-> 4 <-> 0

addAtIndex(2, 5):
cur = 1

1st iteration
cur = 2
index = 1

2nd iteration
cur = 3
index = 0

node = 5
prv = 2
nxt = 3

0 <-> 1 <-> 2 <-> 5 <-> 3 <-> 4 <-> 0

addAtIndex(5, 6):
cur = 1

1st itearation
cur = 2
index = 4

2nd iteration
cur = 5
index = 3

3rd iteration
cur = 3
index = 2

4th iteration
cur = 4
index = 1

5th iteration
cur = 0
index = 0

node = 6
prv = 4
nxt = 0

0 <-> 1 <-> 2 <-> 5 <-> 3 <-> 4 <-> 6 <-> 0

addAtIndex(0, 7):
cur = 1
node = 7
prv = 0
nxt = 1

0 <-> 7 <-> 1 <-> 2 <-> 5 <-> 3 <-> 4 <-> 6 <-> 0

addAtIndex(8, 8):
cur = 7

1st iteration
cur = 1
index = 7

2nd iteration
cur = 2
index = 6

3rd iteration
cur = 5
index = 5

4th iteration
cur = 3
index = 4

5th iteration
cur = 4
index = 3

6th iteration
cur = 6
index = 2

7th iteration
cur = 0 
index = 1

8th iteration
cur = null
index = 0

deleteAtIndex(0):
cur = 7

prv = 0
nxt = 1
0 <-> 1 <-> 2 <-> 5 <-> 3 <-> 4 <-> 6 <-> 0

deleteAtIndex(5):
cur = 1
after while: cur = 6, index = 0

prv = 4
nxt = 0
0 <-> 1 <-> 2 <-> 5 <-> 3 <-> 4 <-> 0

deleteAtIndex(5):
cur = 1
after while: cur = 0, index = 0

deleteAtIndex(6):
cur = 1
after while: cur = null, index = 0

deleteAtIndex(7):
cur = 1
after while: cur = null, index = 1

deleteAtIndex(2)
cur = 1
after while: cur = 5

prv = 2
nxt = 3
0 <-> 1 <-> 2 <-> 3 <-> 4 <-> 0

get(0):
cur = 1
return 1

get(3):
cur = 1
after while: cur = 4, index = 0

return 4

get(4):
cur = 1
after while: cur = 0, index = 0

return -1

get(5):
cur = 1
after while: cur = null, index = 0
return -1

get(6):
cur = 1
after while: cur = null, index = 1
return -1

get(2)
cur = 1
after while: cur = 3, index = 0

return 3





'''

