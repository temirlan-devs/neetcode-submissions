# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        slow, fast = head, head

        # O(n / 2) -> O(n) - time. Fast pointers travels two times faster than slow pointer, so the while loop terminates at the n / 2
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        return slow

# Time complexity: O(n)
# Space complexity: O(1)    

'''

Test

Case 1:
[1]

slow, fast = 1, 1

return 1

Case 2:
[1, 2]

slow, fast = 1, 1

1st iteration:
slow = 2
fast = none

return 2

Case 3:
[1, 2, 3]

slow, fast = 1, 1

1st iteration:
slow = 2
fast = 3

return 2

Case 4:
[1, 2, 3, 4]

slow, fast = 1, 1

1st iteration:
slow = 2
fast = 3

2nd iteration:
slow = 3
fast = none

return 3

'''