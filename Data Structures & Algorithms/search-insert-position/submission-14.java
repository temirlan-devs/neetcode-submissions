class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        // O(logn)
        while (l <= r) {
            int m = l + (r - l) / 2;

            if (nums[m] < target) l = m + 1;
            else if (nums[m] > target) r = m - 1;
            else return m;
        }

        return l;
    }
}

// Time complexity: O(logn). Space complexity: O(1)

/*

Test 

Case 1:

[1, 2, 3] target = 4

l = 0 -> 2 -> 3
r = 2
m = 1 -> 2

return 3

Case 2:
[7, 8, 9] target = 6

l = 0
r = 2 -> 0 -> -1
m = 1 -> 0

return 0

Case 3:
[1, 2, 3, 4, 6] target = 5

l = 0 -> 3 -> 4
r = 4 -> 3
m = 2 -> 3 -> 4

return 4

Case 4:
[1] target = 2

l = 0 -> 1
r = 0
m = 0

return 1



*/