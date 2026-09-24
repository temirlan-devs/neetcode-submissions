class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) set.add(num);

        int maxSequence = 0;

        for (int i = 0; i < nums.length; i++) {

            if (set.isEmpty()) break;
            if (!set.contains(nums[i])) continue;

            int sequence = 1;

            set.remove(nums[i]);
            int curNum = nums[i] - 1;
            while (set.contains(curNum)) {
                sequence++;
                set.remove(curNum);
                curNum--;
            }

            curNum = nums[i] + 1;
            while (set.contains(curNum)) {
                sequence++;
                set.remove(curNum);
                curNum++;
            }

            maxSequence = Math.max(maxSequence, sequence);
        }

        return maxSequence;
    }
}
