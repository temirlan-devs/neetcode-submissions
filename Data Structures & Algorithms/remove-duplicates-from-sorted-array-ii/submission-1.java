class Solution {
    public int removeDuplicates(int[] nums) {
        
        int l = 1;
        int counter = 1;

        for (int r = 1; r < nums.length; r++) {
            if (nums[r] != nums[r - 1]) {
                nums[l] = nums[r];
                l++;
                counter = 1;
            } else if (counter < 2) {
                nums[l] = nums[r];
                l++;
                counter++;
            }
        }

        return l;

    }
}