class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        // O(logn)
        while (l <= r){
            int m = l + (r - l) / 2;

            if (nums[m] == target) return m;

            if (nums[l] <= nums[m]) {
                if (nums[l] <= target && target < nums[m]) r = m - 1;
                else l = m + 1;
            }
            else {
                if (nums[m] < target && target <= nums[r]) l = m + 1;
                else r = m - 1;
            }

        }

        return -1;
    }
}

// Time complexity: O(logn). Space complexity: O(1)

/*

Test

Case 1:
[1, 2, 3, 4] target = 3

l = 0 -> 2
r = 3
m = 1 -> 2

return 2

Case 2:
[4, 1, 2, 3] target = 2

l = 0 -> 2
r = 3
m = 1 -> 2

return 2

Case 3:

[2, 3, 1] target = 2

l = 0
r = 2 -> 0
m = 1 -> 0

return 0

Case 4:
[3, 4, 5, 1, 2] target = 6

l = 0 -> 3 -> 4 -> 5
r = 4
m = 2 -> 3 -> 4

return -1

Case 5:
[1] target = 1

l = 0
r = 0
m = 0

return 0

Case 6
[1] target = 2

l = 0 -> 1
r = 0
m = 0

return -1

*/
