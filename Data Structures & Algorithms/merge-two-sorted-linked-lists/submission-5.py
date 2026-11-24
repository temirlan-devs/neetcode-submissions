# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode()
        tail = dummy

        # Worst case: go through each element in both lists -> O(n + m) - time, where n is the number of nodes in list1 and m is the number of nodes in list2
        while list1 and list2:
            if list1.val < list2.val:
                tail.next = list1
                list1 = list1.next
            else:
                tail.next = list2
                list2 = list2.next
            tail = tail.next
        
        tail.next = list1 or list2

        return dummy.next

# Time Complexity: O(n + m)
# Space Complexity: O(1)

'''

Test

Case 1:

list1 = []
list2 = []

dummy = ListNode()
tail = dummy

tail.next = list2 (none) -> dummy.next none

return none

Case 2

list1 = []
list2 = [5, 6, 7]

dummy = ListNode()
tail = dummy

tail.next = list2 -> dummy.next = [5, 6, 7]

return 5 -> 6 -> 7 -> None

Case 3
list1 = [1, 2, 3]
list2 = []

dummy = ListNode()
tail = dummy

tail.next = list1 -> dummy.next = [1, 2, 3]

return 1 -> 2 -> 3 -> None

Case 4:
list1 = [1, 3]
list2 = [2, 4]

dummy = ListNode()
tail = dummy

1st iteration:
tail -> 1 (dummy -> 1 - saved)
list1 = 3
tail = 1

2nd iteration:
1 -> 2
list2 = 4
tail = 2

3rd iteration:
1 -> 2 -> 3
list1 = none
tail = 3

1 -> 2 -> 3 -> 4 -> None

return 1 -> 2 -> 3 -> 4 -> None

Case 5:
list1 = [2]
list2 = [2]

dummy = ListNode()
tail = dummy

tail -> 2 (dummy -> 2 - saved)
list2 = none
tail = 2

2 -> 2 -> None

return 2 -> 2 -> None




'''