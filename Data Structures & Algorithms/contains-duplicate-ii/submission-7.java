class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) return false;

        Set<Integer> set = new HashSet<>();

        int l = 0, r = 0;

        // O(n)
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

// Time complexity: O(n). Space complexity: O(k)
/*

Test

Case 1:
[1, 2, 3] k = 1

l, r = 0

while 0 < 3
set -> 1
r -> 1

while 1 < 3
set -> 1, 2
r -> 2

while 2 < 3
set -> 1, l -> 1
set -> 3
r -> 3

return false

Case 2:
[1, 1] k = 1

l, r = 0

while 0 < 2
set -> 1
r -> 1

while 1 < 2
set contains 1 -> return true


Case 3:
[1, 2, 3] k = 0

return false


*/