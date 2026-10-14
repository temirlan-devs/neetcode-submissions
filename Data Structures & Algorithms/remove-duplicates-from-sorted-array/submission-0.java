class Solution {
    public int removeDuplicates(int[] nums) {
        
        int k = 1;
        int duplicate = nums[nums.length - 1] + 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) duplicate = nums[i];
            if (nums[i] != duplicate) {
                nums[k] = nums[i];  
                k++;
            }
        }

        return k;

    }
}