class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) return false;

        int l = 0, r = 0;
        Set<Integer> set = new HashSet<>();

        while (r < nums.length) {
            if (r - l > k) {
                set.remove(nums[l]);
                l++;
            }

            if (set.contains(nums[r])) return true;
            set.add(nums[r]);
            r++;
        }

        return false;
    }
}