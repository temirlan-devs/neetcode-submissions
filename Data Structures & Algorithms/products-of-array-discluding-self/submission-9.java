class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;

        int[] output = new int[n];

        output[0] = 1;
        for (int i = 0; i < n - 1; i++) {
            output[i + 1] = output[i] * nums[i];
        }

        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            output[i] = output[i] * postfix;
            postfix *= nums[i];
        }

        return output;

    }
}  
