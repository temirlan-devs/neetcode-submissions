class Solution {
    public int removeElement(int[] nums, int val) {
        
        int k = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {

            if (nums[i] == val) {

                if (i == n - 1) break;
                int t = i + 1;
                while (nums[t] == val) {
                    t++;
                    if (t == n) break;
                }
                if (t == n) break;
                int temp = nums[i];
                nums[i] = nums[t];
                nums[t] = temp;
            } 

        }

        for (int num : nums) {
            if (num == val) break;
            k++;
        }

        return k;

    }
}