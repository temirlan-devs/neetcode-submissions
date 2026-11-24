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

'''

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