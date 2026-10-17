class Solution {

    int[] nums;

    public void rotate(int[] nums, int k) {
        this.nums = nums;

        k %= nums.length;
        if (k == 0) return;
        reverse(0, nums.length - 1);
        reverse(0, k - 1);
        reverse(k, nums.length - 1);    
    }

    private void reverse(int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++; r--;
        }
    }
}