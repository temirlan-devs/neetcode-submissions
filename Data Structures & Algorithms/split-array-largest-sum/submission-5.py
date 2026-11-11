class Solution:
    def splitArray(self, nums: List[int], k: int) -> int:
        l, r = max(nums), sum(nums) # Both max and sum operations are O(n) - time

        res = sum(nums) # O(n) - time

        # O(n) - time
        def canSplit(cap: int) -> bool:
            subarray = 1
            curSum = 0
            for n in nums:
                curSum += n
                if curSum > cap:
                    subarray += 1
                    if subarray > k:
                        return False
                    curSum = n
            return True

        # O(log(r - l)). r - l = sum - max and sum - max <= sum (S) -> O(log(S)) - time
        while l <= r:
            m = l + (r - l) // 2

            # O(n)
            if canSplit(m):
                res = m
                r = m - 1
            else:
                l = m + 1

        return res

# Time complexity: O(n * logS)
# Space complexity: O(1)

'''

Test

Case 1:
[1, 2, 3] k = 2

l = 3
r = 6 -> 3 -> 2
m = 4 -> 3
res = 4 -> 3

return 3

Case 2:
[5, 9, 1, 8, 4] k = 4

l = 9
r = 27 -> 17 -> 12 -> 9 -> 8
m = 18 -> 13 -> 10 -> 9
res = 18 -> 13 -> 10 -> 9

return 9

Case 3:
[1, 2] k = 2

l = 2
r = 3 -> 1
m = 2
res = 2

return 2

Case 4:
[1] k = 1

l = 1
r = 1 -> 0
m = 1
res = 1

return 1


'''

