class Solution:
    def splitArray(self, nums: List[int], k: int) -> int:
        l = max(nums)
        r = sum(nums)

        def canSplit(m: int) -> bool:
            counter = 1
            total = 0
            for num in nums:
                total += num
                if total > m:
                    counter += 1
                    if counter > k:
                        return False
                    total = num
            return True

        while l <= r:
            m = l + (r - l) // 2

            if canSplit(m):
                r = m - 1
            else:
                l = m + 1

        return l