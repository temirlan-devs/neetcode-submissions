class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = 1;

        for (int i = 0; i < n - 1; i++) {
            prefix[i + 1] = prefix[i] * nums[i];
        }

        int[] postfix = new int[n];
        postfix[n - 1] = 1;
        for (int i = n - 1; i >= 1; i--) {
            postfix[i - 1] = postfix[i] * nums[i];
        }

        int[] output = new int[n];

        for (int i = 0; i < n; i++) {
            output[i] = prefix[i] * postfix[i];
        }

        return output;

    }
}  
