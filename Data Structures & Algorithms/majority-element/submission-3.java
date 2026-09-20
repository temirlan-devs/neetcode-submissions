class Solution {
    public int majorityElement(int[] nums) {
        int res = 0, count = 0;

        // O(n)
        for (int num : nums) {
            if (count == 0) res = num;
            count += (num == res) ? 1 : -1;
        }

        return res;
    }
}

// Time complexity: O(n)
// Space complexity: O(1)