class Solution:

    

    def getHours(self, k: int, piles: List[int]) -> int:
        hours = 0
        for pile in piles:
            hours += math.ceil(pile / k)
        return hours

    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        maxPile = max(piles)

        l, r = 1, maxPile

        while l <= r:
            m = l + (r - l) // 2

            hours = self.getHours(m, piles)

            if hours > h:
                l = m + 1
            else:
                r = m - 1

        return l