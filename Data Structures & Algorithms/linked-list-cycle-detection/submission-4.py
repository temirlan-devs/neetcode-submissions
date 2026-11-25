# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        slow, fast = head, head
        
        # O(n) - time. slow never travels more than the number of nodes in cycle which is <= n, where n is the number of nodes in total
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

            if slow == fast:
                return True

        return False

# Time Complexity: O(n)
# Space Complexity: O(1)

'''

Test

Case 1:
[] index = -1

slow, fast = null, null
return False

Case 2:
[1] index  = -1

slow, fast = 1, 1
return False

Case 3:
[1, 2] index = -1

slow, fast = 1, 1

1st iteration
slow = 2
fast = null

return False

Case 4:
[1, 2] index = 0

slow, fast = 1, 1

1st iteration
slow = 2
fast = 1

2nd iteration
slow = 1
fast = 1
return True

Case 5:
[1, 2, 3] index = -1

slow, fast = 1, 1

1st iteration
slow = 2
fast = 3

return False

Case 6:
[1, 2, 3] index = 1

slow, fast = 1, 1

1st iteration
slow = 2
fast = 3

2nd iteration
slow = 3
fast = 3
return True



'''