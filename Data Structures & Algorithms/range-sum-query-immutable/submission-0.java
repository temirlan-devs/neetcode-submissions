class NumArray {

    int[] prefix;

    public NumArray(int[] nums) {
        this.prefix = new int[nums.length];
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            prefix[i] = total;
        }
    }
    
    public int sumRange(int left, int right) {
        int prevLeftVal = left > 0 ? this.prefix[left - 1] : 0;
        int rightVal = this.prefix[right];
        int sum = rightVal - prevLeftVal;
        return sum;
    }
}

/*
Time complexity: O(n) to create the prefix
O(1) each sumRange(call)

Space complexity: O(n) to store prefix sums

Test 

Case 1:
[1, 2, 3]
prefix -> [1, 3, 6]

sumRange(1, 2)
prevLeftVal = 1
rightVal = 6
sum = 6 - 1 = 5

sumRange(0, 1)
prevLeftVal = 0
rightVal = 3
sum = 3 - 0 = 3

Case 2:
[1]
prefix -> 1

sumRange(0, 0)
prevLeft = 0
rightVal = 0
sum = 0



*/


/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */