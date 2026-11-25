# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def pairSum(self, head: Optional[ListNode]) -> int:
        slow, fast = head, head
        prev = None
        while fast and fast.next:
            fast = fast.next.next

            tmp = slow.next
            slow.next = prev
            prev = slow
            slow = tmp

        res = 0

        # n / 2 operations -> O(n) - time
        while slow:
            res = max(res, prev.val + slow.val)
            slow = slow.next
            prev = prev.next

        return res