class Solution {
    public int firstMissingPositive(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        // O(n)
        for (int num : nums) set.add(num);

        int i = 1;

        // O(n) where n is the number of items in nums
        // stops when the first smallest integer is not found
        // worst case if nums have a sequence up until Integer.MAX_VALUE
        while (i <= Integer.MAX_VALUE) {
            if (!set.contains(i)) return i;
            i++;
        }

        return -1;

    }
}

// Time complexity: O(n)
// Space complexity: O(n). Auxiliary space complexity: O(1)