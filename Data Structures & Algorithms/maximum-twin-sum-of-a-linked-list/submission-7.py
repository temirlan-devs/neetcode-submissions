# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def pairSum(self, head: Optional[ListNode]) -> int:
        slow, fast = head, head
        
        # find the second middle and reverse the first half
        prev = None
        while fast and fast.next: # n/2 operations -> O(n) - time 
            fast = fast.next.next

            tmp = slow.next
            slow.next = prev
            prev = slow
            slow = tmp

        # slow is at the second middle (beginning of the second half)
        # prev is at the first middle and now leads to reversed first half

        # calculate the max twin sum
        res = 0

        # n/2 opearations -> O(n) - time
        while slow:
            res = max(res, prev.val + slow.val)
            slow = slow.next
            prev = prev.next

        return res

# Time complexity: O(n)
# Space complexity: O(1)


'''

Test

Case 1:
9 -> 10

slow, fast = 9, 9
prev = none

1st iteration
fast = none
tmp = 10
9 -> none
prev = 9
slow = 10

9		10

res = 0

1st iteration
res = 19
slow = none
prev = none

return 19

Case 2:
9 -> 10 -> 11 -> 12

slow, fast = 9, 9
prev = none

1st iteration
fast = 11
tmp = 10
9 -> none
prev = 9
slow = 10

2nd iteration
fast = none
tmp = 11
10 -> 9 -> none
prev = 10
slow = 11

res = 0

10 -> 9			11 -> 12

1st iteration
res = 21
slow = 12
prev = 9

2nd iteration
res = 21
slow = none
prev = none

return 21

Case 3:
[1, 2, 3, 9, 7, 6]

slow, fast = 1, 1
prev = none

1st iteration
fast = 3
tmp = 2
1 -> none
prev = 1
slow = 2

2nd iteration
fast = 7
tmp = 3
2 -> 1 -> none
prev = 2
slow = 3

3rd iteration:
fast = none
tmp = 9
3 -> 2 -> 1 -> none
prev = 3
slow = 9

res = 0

3 -> 2 -> 1 			9 -> 7 -> 6

1st iteration
res = 12
slow = 7
prev = 2

2nd iteration
res = 12
slow = 6
prev = 1

3rd iteration
res = 12
slow = none
prev = none

return 12



'''

