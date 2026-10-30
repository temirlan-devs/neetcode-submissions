class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (nums[m] == target) return true;

            if (nums[l] < nums[m]) { // left portion
                if (nums[l] <= target && target < nums[m]) r = m - 1;
                else l = m + 1;
            }

            else if (nums[l] > nums[m]) { // right portion
                if (nums[m] < target && target <= nums[r]) l = m + 1;
                else r = m - 1;
            }

            else {
                l++;
            }
        }

        return false;
    }
}

/*

Time complexity:
Average - O(logn). Usually when there are little amount of duplicates then it is O(logn)
Worst - O(n). Worst case is when all values are equal

Space complexity: O(1)

*/

/*

Test

Case 1:
[1, 2, 3] target = 3

l = 0 -> 2
r = 2
m = 1 -> 2

return true


Case 2:
[3, 1, 1, 1, 2] target = 2

l = 0 -> 3 -> 4
r = 4
m = 2 -> 3 -> 4

return true

Case 3:
original: [2, 2, 2, 2, 2, 3, 4] 
[2, 3, 4, 2, 2, 2, 2] target = 4

l = 0 -> 1 -> 2
r = 6 -> 2
m = 3 -> 3 -> 1 -> 2

return true

Case 4:
original: [0, 1, 1, 1, 1] 
[1, 0, 1, 1, 1] target = 2

l = 0 -> 1 -> 3 -> 4 -> 5
r = 4
m = 2 -> 2 -> 3 -> 4

return false

Case 5:
[1] target = 1

l = 0
r = 0
m = 0

return true

Case 6:
[1] target = 2

l = 0 -> 1
r = 0
m = 0

return false

*/


