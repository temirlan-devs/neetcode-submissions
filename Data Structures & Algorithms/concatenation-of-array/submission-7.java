class Solution {
    public int[] getConcatenation(int[] nums) {
        
        int n = nums.length;

        int[] ans = new int[2 * n];

        int index = 0;
        for (int i = 0; i < 2 * n; i++) {
            index = i >= n ? i - n : i;
            ans[i] = nums[index];
        }

        return ans;

    }
}