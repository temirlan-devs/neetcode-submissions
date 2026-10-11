class Solution {
    public int[] getConcatenation(int[] nums) {
        
        int n = nums.length * 2;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int index = i;
            if (i >= nums.length) index = i - nums.length;
            res[i] = nums[index];
        }

        return res;



    }
}