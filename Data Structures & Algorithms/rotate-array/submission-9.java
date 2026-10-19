class Solution {

    int[] nums;

    public void rotate(int[] nums, int k) {

        k = k % nums.length;

        this.nums = nums;

        reverse(0, nums.length - 1);
        reverse(0, k - 1);
        reverse(k, nums.length - 1);

    }

    public void reverse (int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++; r--;
        }
    }
}