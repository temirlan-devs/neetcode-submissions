class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int res = nums[0];

        // O(logn)
        while (l <= r) {
            if (nums[l] < nums[r]) {
                res = Math.min(res, nums[l]);
                break;
            }

            int m = l + (r - l) / 2;

            res = Math.min(res, nums[m]);
            if (nums[l] <= nums[m]) l = m + 1;
            else r = m - 1;
        }

        return res;
    }
}

// Time complexity: O(logn). Space complexity: O(1)


/*

Test

Case 1:
[1, 2, 3]

l = 0
r = 2
res = 1

return 1

Case 2:
[3, 1, 2]

l = 0 -> 1
r = 2 -> 0
m = 1 -> 0
res = 3 -> 1

return 1

Case 3:
[2, 3, 1]

l = 0 -> 2 -> 3
r = 2
m = 1 -> 2
res = 2 -> 1

return 1

Case 4:
[2, 1]

l = 0 -> 1 -> 2
r = 1
m = 0 -> 1
res = 2 -> 1

return 1

Case 5:
[2]

l = 0 -> 1
r = 0
m = 0
res = 2

return 2

Case 6:
[7, 8, 9, 3, 4, 5, 6]

l = 0
r = 6 -> 2
m = 3
res = 7 -> 3

return 3

Case 7:
[6, 7, 8, 9, 3, 4, 5]

l = 0 -> 4
r = 6
m = 3
res = 6 -> 3

return 3






*/