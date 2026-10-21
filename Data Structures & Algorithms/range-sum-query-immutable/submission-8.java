class NumArray {

    int[] prefix;

    public NumArray(int[] nums) {
        this.prefix = new int[nums.length + 1];
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            this.prefix[i + 1] = total;
        }
    }

    /*
    [1, 2, 3]
    [0, 1, 3, 6]
    */
    
    public int sumRange(int left, int right) {
        int res = prefix[right + 1] - prefix[left];
        return res;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */