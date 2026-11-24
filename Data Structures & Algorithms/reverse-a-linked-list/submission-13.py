# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        cur, prev = head, None

        # O(n)
        while cur:
            nxt = cur.next
            cur.next = prev
            prev = cur
            cur = nxt

        return prev

# Time complexity: O(n), where n is the number of nodes
# Space complexity: O(1)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        cur, prev = head, None

        while cur:
            nxt = cur.next
            cur.next = prev
            prev = cur
            cur = nxt
        
        return prev

'''

Test

Case 1:
[]

cur = none
prev = none

return none

Case 2:
[1]

cur = 1
prev = none

nxt = none
1 -> none
prev = 1
cur = none

return 1 -> none

Case 3:
[1, 2]

cur = 1
prev = none

1st iteration:
nxt = 2
1 -> none
prev = 1
cur = 2

2nd itration
nxt = none
2 -> 1 -> none
prev = 2
cur = none

return 2 -> 1 -> none

Case 4:
[1, 2, 3]

cur = 1
prev = none

1st iteration:
nxt = 2
1 -> none
prev = 1
cur = 2

2nd iteration:
nxt = 3
2 -> 1 -> none
prev = 2
cur = 3

3rd iteration
nxt = none
3 -> 2 -> 1 -> none
prev = 3
cur = none


return 3 -> 2 -> 1 -> none






'''




'''

Recursive approach:



# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return None

        newHead = head
        if head.next:
            newHead = self.reverseList(head.next)
            head.next.next = head
        head.next = None

        return newHead

# Time complexity: O(n), where n is the number of nodes
# Space complexity: O(n) - calls stack


Test

Case 1:
[]

return none

Case 2:
[1]

r(1):
  newHead = 1
  1 -> none
  return 1 -> none

Case 3:
[1, 2]

r(1):
  newHead = 1
  newHead = r(2): 2 -> none
		newHead = 2
		2 -> none
                return 2 -> none
  2 -> 1 -> None
  return 2 -> 1 -> none

Case 4:
[1, 2, 3]

r(1):
  newHead = 1
  newHead = r(2): 3 -> 2 -> none
	        newHead = 2
		newHead = r(3): 3 -> none
		             newHead = 3
		             3 -> none
			     return 3 -> none
		3 -> 2 -> none
		return 3 -> 2 -> none
  3 -> 2 -> 1 -> none
  return 3 -> 2 -> 1 -> none
  


'''