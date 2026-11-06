class Solution:

    def getSqrt(self, x: int) -> int:
        return x * x

    def mySqrt(self, x: int) -> int:
        l, r = 1, x

        while l <= r:
            m = l + (r - l) // 2

            res = self.getSqrt(m)

            if res == x: return m

            if res > x: 
                r = m - 1
            else:
                l = m + 1

        return r



    
