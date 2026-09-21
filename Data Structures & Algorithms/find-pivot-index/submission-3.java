class Solution {
    public int pivotIndex(int[] nums) {

        int n = nums.length;
        int answer = -1;
        
        int[] result = new int[n];

        result[0] = 0;
        for (int i = 0; i < n - 1; i++) {
            result[i + 1] = result[i] + nums[i];
        }

        int postfix = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (postfix == result[i]) answer = i;
            postfix += nums[i];
        }

        return answer;

    }
}