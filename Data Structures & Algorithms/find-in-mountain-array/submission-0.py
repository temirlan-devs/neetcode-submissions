class Solution:
    def findInMountainArray(self, target: int, mountainArr: 'MountainArray') -> int:
        length = mountainArr.length()

        l, r = 1, length - 2

        # Find a peak
        while l <= r:
            m = l + (r - l) // 2

            left, mid, right = mountainArr.get(m - 1), mountainArr.get(m), mountainArr.get(m + 1)

            # increasing portion
            if left < mid < right:
                l = m + 1
            # decreasing portion
            elif left > mid > right:
                r = m - 1
            # m is at peak: left < m (peak) > right    
            else:
                break
        
        peak = m

        l, r = 0, peak - 1

        while l <= r:
            m = l + (r - l) // 2

            value = mountainArr.get(m)

            if value < target:
                l = m + 1
            elif value > target:
                r = m - 1
            else:
                return m

        l, r = peak, length - 1

        while l <= r:
            m = l + (r - l) // 2

            value = mountainArr.get(m)

            if value < target:
                r = m - 1
            elif value > target:
                l = m + 1
            else:
                return m

        return -1
