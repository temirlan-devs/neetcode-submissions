class Solution {

    int[] nums;

    public void sortColors(int[] nums) {
        this.nums = nums;
        int i = 0, l = 0, r = nums.length - 1;

        while (i <= r) {
            if (nums[i] == 0) {
                swap(l, i);
                l++;
            }
            else if (nums[i] == 2) {
                swap(i, r);
                r--;
                i--;
            }
            i++;
        }

    }

    public void swap (int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}