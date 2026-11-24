class Solution:
    def findInMountainArray(self, target: int, mountainArr: 'MountainArray') -> int:
        length = mountainArr.length()

        # find peak
        l, r = 1, length - 2

        # O(logn) - time, where n is the length of the input
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

        # Two while loops below together -> O(logn) - time

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

# Time complexity: O(logn)
# Space complexity: O(1)



'''

Test

Case 1:
[1, 2, 1] target = 1

# find peak
l = 1
r = 1
m = 1

peak = 1

# search the left
l = 0
r = 0
m = 0

return 0

Case 2:
[1, 2, 3, 4, 5, 4, 3]     target = 5

# find peak
l = 1 -> 4
r = 5
m = 3 -> 4

peak = 4

# search the left
l = 0 -> 2 -> 3 -> 4
r = 3
m = 1 -> 2 -> 3

# search the right
l = 4
r = 6 -> 4
m = 5 -> 4

return 4

Case 3:
[9, 10, 8, 7, 6, 5] target = 3

# find peak
l = 1
r = 4 -> 1
m = 2 -> 1

peak = 1

# search the left
l = 0
r = 0 -> -1
m = 0

# search the right
l = 1 -> 4 -> 5 -> 6
r = 5
m = 3 -> 4 -> 5

return -1



'''
