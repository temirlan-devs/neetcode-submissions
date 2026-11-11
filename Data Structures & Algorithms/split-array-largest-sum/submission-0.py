class Solution:
    def splitArray(self, nums: List[int], k: int) -> int:
        l, r = max(nums), sum(nums)
        res = sum(nums)

        def canSplit(sum: int) -> bool:
            subarray = 1
            curSum = 0
            for num in nums:
                curSum += num
                if curSum > sum:
                    subarray += 1
                    if subarray > k:
                        return False
                    curSum = num
            return True
                    
        
        while l <= r:
            m = l + (r - l) // 2

            if canSplit(m):
                res = m
                r = m - 1
            else:
                l = m + 1

        return res