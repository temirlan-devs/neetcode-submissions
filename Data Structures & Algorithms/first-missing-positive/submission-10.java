class Solution {
    public int firstMissingPositive(int[] nums) {
        
        for (int i = 0; i < nums.length; i++) {
             if (nums[i] < 0)
                nums[i] = 0;
        }
           
        
           

        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);

            if (1 <= val && val <= nums.length) {
                int index = val - 1;

                if (nums[index] == 0) {
                    nums[index] = (nums.length + 1) * -1;
                } else {
                    nums[index] = Math.abs(nums[index]) * (-1);
                }
            }
        }

        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] >= 0) return i;
        }

        return nums.length + 1;
        

    }
}