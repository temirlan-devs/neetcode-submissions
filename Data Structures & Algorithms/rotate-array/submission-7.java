class Solution {

    int[] nums;

    public void rotate(int[] nums, int k) {
        if (k != 0 || nums.length > 1) {
this.nums = nums;
        k = k % nums.length;
        reverse(0, nums.length - 1);
        reverse(0, k - 1);
        reverse(k, nums.length - 1);
        }
        
    }

    private void reverse(int l, int r) {
        // O(n)
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++; r--;
        }
    }
}

// Time complexity: O(n). Space complexity: O(1)

/*

Case 1:

[1, 2, 3, 4] k = 2
expected: [3, 4, 1, 2]

k = 2
[4, 3, 2, 1]
[3, 4, 1, 2]

Case 2:
[1, 2, 3, 4] k = 3
expected: [2, 3, 4, 1]

k = 3
[4, 3, 2, 1] 
[2, 3, 4, 1]
[2, 3, 4, 1]

Case 3:
[1, 2, 3] k = 1
expected: [3, 1, 2]

k = 1
[3, 2, 1]
[3, 2, 1]
[3, 1, 2]

Case 4:
[1, 2, 3] k = 4
expected: [3, 1, 2]

k = 4 -> 1
[3, 2, 1]
[3, 2, 1]
[3, 1, 2]

Case 5:
[1, 2, 3] k = 0
expected: [1, 2, 3]

k = 0
[3, 2, 1]
[3, 2, 1]
[1, 2, 3]

Case 6:
[1] k = 3
expected: [1]

k = 0
[1]
[1]
[1]




*/
