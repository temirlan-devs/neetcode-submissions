class NumArray {

    int[] prefix;
    int n;

    public NumArray(int[] nums) {
        this.prefix = new int[nums.length + 1];

        int total = 0;
        for (int i = 1; i < prefix.length; i++) {
            total += nums[i - 1];
            prefix[i] = total;
        }   
    }
    
    public int sumRange(int left, int right) {
        return prefix[right + 1] - prefix[left];
    }
}

/*

[1, 2, 3]
[0, 1, 3, 6]

*/

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */