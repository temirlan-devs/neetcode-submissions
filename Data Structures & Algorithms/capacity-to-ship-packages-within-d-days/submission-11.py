class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        l, r = max(weights), sum(weights)

        def canShip(capacity: int) -> bool:
            d = 1
            cur = 0
            for w in weights:
                cur += w
                if cur > capacity:
                    d += 1
                    if d > days:
                        return False
                    cur = w
            return True


        while l <= r:
            m = l + (r - l) // 2

            if canShip(m):
                r = m - 1
            else:
                l = m + 1

        return l