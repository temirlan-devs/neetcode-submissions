class ListNode:
    def __init__(self, val):
        self.val = val
        self.next = None
        self.prev = None

class MyLinkedList:

    def __init__(self):
        self.head = ListNode(0)
        self.tail = ListNode(0)
        self.head.next = self.tail
        self.tail.prev = self.head
        

    def get(self, index: int) -> int:
        cur = self.head.next

        while cur and index > 0:
            cur = cur.next
            index -= 1
        
        if cur and cur != self.tail:
            return cur.val
        
        return -1

    def addAtHead(self, val: int) -> None:
        node, prv, nxt = ListNode(val), self.head, self.head.next

        prv.next = node
        node.prev = prv
        node.next = nxt
        nxt.prev = node

    def addAtTail(self, val: int) -> None:
        node, prv, nxt = ListNode(val), self.tail.prev, self.tail

        prv.next = node
        node.prev = prv
        node.next = nxt
        nxt.prev = node

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


    def deleteAtIndex(self, index: int) -> None:
        cur = self.head.next

        while cur and index > 0:
            cur = cur.next
            index -= 1

        if cur and cur != self.tail:
            prv, nxt = cur.prev, cur.next
            prv.next = nxt
            nxt.prev = prv
        


# Your MyLinkedList object will be instantiated and called as such:
# obj = MyLinkedList()
# param_1 = obj.get(index)
# obj.addAtHead(val)
# obj.addAtTail(val)
# obj.addAtIndex(index,val)
# obj.deleteAtIndex(index)