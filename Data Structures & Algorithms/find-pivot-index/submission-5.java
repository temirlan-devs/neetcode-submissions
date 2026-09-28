class Solution {
    public int pivotIndex(int[] nums) {
        int[] prefix = new int[nums.length + 1];

        prefix[0] = 0;
        int sum = 0;
        for (int i = 1; i <= nums.length; i++) {
            sum += nums[i - 1];
            prefix[i] = sum;
        }

        for (int i = 0; i < nums.length; i++) {
            int leftSum = prefix[i];
            int rightSum = prefix[nums.length] - prefix[i + 1];
            if (leftSum == rightSum) return i;
        }

        return -1;
    }
}