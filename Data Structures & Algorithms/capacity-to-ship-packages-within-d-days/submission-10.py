class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        l, r = max(weights), sum(weights)

        def canShip (capacity: int) -> bool:
            cur = capacity
            d = 1
            for w in weights:
                cur -= w
                if cur < 0:
                    d += 1
                    if d > days:
                        return False
                    cur = capacity - w
            return True

        while l <= r:
            m = l + (r - l) // 2

            can = canShip(m)

            if can:
                r = m - 1
            else:
                l = m + 1
        
        return l