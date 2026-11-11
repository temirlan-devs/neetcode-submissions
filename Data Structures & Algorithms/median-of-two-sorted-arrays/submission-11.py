class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        A, B = nums1, nums2

        if len(B) < len(A):
            A, B = B, A

        total = len(A) + len(B)
        half = total // 2

        l, r = 0, len(A) - 1
        
        # Time - O(log(min(m, n))), m is the length of nums1 and n is the length of nums2
        while True:
            i = l + (r - l) // 2
            j = half - i - 2

            Aleft = A[i] if i >= 0 else float("-infinity")
            Aright = A[i + 1] if i + 1 < len(A) else float("infinity")
            Bleft = B[j] if j >= 0 else float("-infinity")
            Bright = B[j + 1] if j + 1 < len(B) else float("infinity")

            if Aleft <= Bright and Bleft <= Aright:
                if total % 2:
                    return min(Aright, Bright)
                return ( max(Aleft, Bleft) + min(Aright, Bright) ) / 2
            elif Aleft > Bright:
                r = i - 1
            else:
                l = i + 1
        
# Time complexity: O(log(min(m, n))), m is the length of nums1 and n is the length of nums2
# Space complexity: O(1)
        


'''

Test

Case 1:
[1, 2]
[3, 4]

total = 4
half = 2

l = 0 -> 1
r = 1
i = 0 -> 1
j = 0 -> -1
Aleft = 1 -> 2
Aright = 2 -> inf
Bleft = 3 -> -inf
Bright = 4 -> 3

even -> (2 + 3) / 2 = 2.5
return 2.5


Case 2:
[6]
[1, 2]

total = 3
half = 1

l = 0
r = 0 -> -1
i = 0 -> -1
j = -1 -> 0
Aleft = 6 -> -inf 
Aright = inf -> 6
Bleft = -inf -> 1
Bright = 1 -> 2

odd -> min(6, 2) -> 2

return 2

Case 3:
[]
[1, 2]

total = 2
half = 1

l = 0
r = -1
i = -1
j = 0
Aleft = -inf
Aright = +inf
Bleft = 1
Bright = 2

even -> (1 + 2) / 2 = 1.5

return 1.5



'''

