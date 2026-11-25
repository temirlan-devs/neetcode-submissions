# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def pairSum(self, head: Optional[ListNode]) -> int:
        slow, fast = head, head
        
        # find the middle node and reverse the 1st half
        prev = None
        while fast and fast.next:
            fast = fast.next.next

            tmp = slow.next
            slow.next = prev
            prev = slow
            slow = tmp

        # slow is at the second middle (beginning of the second half)
        # prev is at the first middle, which now leads to reversed first half

        # calculate the max twin sum
        res = 0

        while slow:
            res = max(res, prev.val + slow.val)
            slow = slow.next
            prev = prev.next

        return res

