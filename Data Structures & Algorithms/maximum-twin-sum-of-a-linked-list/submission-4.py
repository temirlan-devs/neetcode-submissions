# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def pairSum(self, head: Optional[ListNode]) -> int:
        slow, fast = head, head
        prev = None

        # reverse the first half
        while fast and fast.next:
            fast = fast.next.next
            
            tmp = slow.next
            slow.next = prev
            prev = slow
            slow = tmp

        # slow is at the second middle (beginning of the second half)
        # prev is at the first middle and now leads to reversed first half

        # calculate max twin sum
        res = 0

        while slow:
            res = max(res, slow.val + prev.val)
            slow = slow.next
            prev = prev.next

        return res


