class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];

        for(int i = 0; i < 2 * n; i++) {
            int index = i;
            if (i >= n) {
                index = i - n;
            }
            ans[i] = nums[index];
        }
        return ans;
    }
}

/*
Time and space complexity -> O(n)

Test case:
[1, 4, 1, 2]
ans -> [0, 0, 0, 0, 0, 0, 0, 0]

i = 0 -> 3
ans -> [1, 4, 1, 2, 0, 0, 0, 0]

i = 4
index = 0
ans[4] = nums[0] -> [1, 4, 1, 2, 1, 0, 0, 0]

i = 5
index = 1
[1, 4, 1, 2, 1, 4]

i = 6
index = 2
[1, 4, 1, 2, 1, 4, 1]

i = 7
index = 3
[1, 4, 1, 2, 1, 4, 1, 2]

*/