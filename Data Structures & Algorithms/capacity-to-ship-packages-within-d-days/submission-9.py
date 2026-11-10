class Solution:

    def canShip (self, weights: List[int], capacity: int, limit : int) -> boolean:
        days = 1
        remain = capacity
        for w in weights:
            remain -= w
            if remain < 0:
                days += 1
                remain = capacity - w

                if days > limit: 
                    return False
        return True



    def shipWithinDays(self, weights: List[int], days: int) -> int:
        totalWeight = sum(weights)
        maxWeight = max(weights)

        l, r = maxWeight, totalWeight

        while l <= r:
            m = l + (r - l) // 2

            canShip = self.canShip(weights, m, days)

            if canShip:
                r = m - 1
            else:
                l = m + 1

        return l

