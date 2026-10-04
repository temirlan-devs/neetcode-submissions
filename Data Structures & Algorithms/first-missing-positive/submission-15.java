class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) if (nums[i] < 0) nums[i] = 0;

        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);

            if (1 <= val && val <= n) {
                int index = val - 1;

                if (nums[index] > 0) {
                    nums[index] *= -1;
                }
                else if (nums[index] == 0) {
                    nums[index] = (n + 1) * -1;
                }
            }
        }

        for (int i = 1; i <= n; i++) 
            if (nums[i - 1] >= 0) return i;

        return n + 1;

    }
}