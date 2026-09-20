class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;

        int[] res = new int[n];

        int prefix = 1;
        // O(n)
        for (int i = 0; i < n; i++) {
            res[i] = prefix;
            prefix = prefix * nums[i];
        }

        int postfix = 1;
        // O(n)
        for (int i = n - 1; i >= 0; i--) {
            res[i] = postfix * res[i];
            postfix = postfix * nums[i];
        }

        return res;

    }
}  

/*

Time compplexity: O(n)

Space complexity: O(1)

*/
