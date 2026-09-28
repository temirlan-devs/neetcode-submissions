class NumArray {

    int[] prefix;

    public NumArray(int[] nums) {
        this.prefix = new int[nums.length + 1];

        for (int i = 1; i < nums.length + 1; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        for (int num : prefix) {
            System.out.print(num + ", ");
        }
        System.out.println();
    }
    
    public int sumRange(int left, int right) {
        int rightVal = prefix[right + 1];
        int leftVal = prefix[left];

        System.out.println(rightVal);
        System.out.println(leftVal);
        System.out.println();
        return rightVal - leftVal;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */