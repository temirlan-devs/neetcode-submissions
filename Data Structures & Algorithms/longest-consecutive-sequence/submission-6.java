class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        
        int maxLength = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int length = 1;
                while (set.contains(nums[i] + length)) {
                    length++;
                }
                maxLength = Math.max(length, maxLength);
            }
        }

        return maxLength;

    }
}
