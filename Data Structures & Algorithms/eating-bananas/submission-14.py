class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        l, r = 1, max(piles)

        def getHours(k: int) -> int:
            hours = 0
            for p in piles:
                hours += math.ceil(p / k)
            return hours


        while l <= r:
            m = l + (r - l) // 2

            res = getHours(m)

            if res > h:
                l = m + 1
            else:
                r = m - 1

        return l