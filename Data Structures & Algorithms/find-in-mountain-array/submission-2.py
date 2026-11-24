class Solution:
    def findInMountainArray(self, target: int, mountainArr: 'MountainArray') -> int:
        length = mountainArr.length()

        # find peak
        l, r = 1, length - 2

        while l <= r:
            m = l + (r - l) // 2

            left, mid, right = mountainArr.get(m - 1), mountainArr.get(m), mountainArr.get(m + 1)

            # increasing portion
            if left < mid < right:
                l = m + 1
            # decreasing portion    
            elif left > mid > right:
                r = m - 1
            # m is peak: left < mid > right    
            else:
                break
        peak = m

        # search the left (increasing) portion
        l, r = 0, peak - 1

        while l <= r:
            m = l + (r - l) // 2

            value = mountainArr.get(m)

            if value > target:
                r = m - 1
            elif value < target:
                l = m + 1
            else:
                return m

        # search the right (decreasing) portion
        l, r = peak, length - 1

        while l <= r:
            m = l + (r - l) // 2

            value = mountainArr.get(m)

            if value > target:
                l = m + 1
            elif value < target:
                r = m - 1
            else:
                return m

        # nothing found
        return -1
