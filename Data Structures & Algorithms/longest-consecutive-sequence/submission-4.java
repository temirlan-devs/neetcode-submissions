class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        int maxLength = 0;

        for (int num : nums) set.add(num);

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int length = 1;
                while (set.contains(nums[i] + length)) {
                    length++;
                }
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;

    }
}
