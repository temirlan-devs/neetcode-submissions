class Solution {
    public int firstMissingPositive(int[] nums) {
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) nums[i] = 0;
        }

        /*
        [1, 0, 2, 4, 5] n = 5

            
        
        */

        for (int i = 0; i < nums.length; i++) {

            int val = Math.abs(nums[i]);

            if (0 < val && val <= nums.length) {

                int index = val - 1;

                if (nums[index] > 0) {
                    nums[index] = nums[index] * (-1);
                }
                else if (nums[index] == 0) {
                    nums[index] = -1 * (nums.length + 1);
                }

            }
        }

        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] >= 0) return i;
        }

        return nums.length + 1;

    }
}