class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        

        int l = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;

        // O(n)
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];

            // O(n) in total
            while (sum >= target) {
                res = Math.min(res, r - l + 1);
                sum -= nums[l];
                l++;
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;

    }
}

// Time complexity: O(n). Space complexity: O(1)

/*

Test

Case 1:

[1, 2, 3, 5, 1] target = 6

sum = 0 -> 1 -> 3 -> 6 -> 5 -> 10 -> 8 -> 5 -> 6
res = integer max -> 3 -> 2

return 2

Case 2:
[1, 2, 3] target = 7

sum = 0 -> 1 -> 3 -> 6
res = integer max

return 0

Case 3:
[1] target = 2

sum = 0 -> 1
res = integer max

return 0

Case 4:
[1] target = 1

sum = 0 -> 1
res = integer max -> 1

return 1


*/