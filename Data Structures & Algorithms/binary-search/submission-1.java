class Solution {
    public int search(int[] nums, int target) {
        
        int l = 0;
        int r = nums.length - 1;

        // O(logn) - time
        while (l <= r) {
            int mid = (l + r) / 2;

            if (nums[mid] < target) l = mid + 1;
            else if (nums[mid] > target) r = mid - 1;
            else return mid;
        }

        return -1;

    }
}

/*

Time complexity: O(logn)
Space complexity: O(1)


*/

/*

Test

Case 1:
[1, 2, 3, 4]  target = 3

l = 0 -> 2
r = 3
mid = 1 -> 2

return 2

Case 2:
[1, 2, 3] target = 1

l = 0
r = 2 -> 0
mid = 1 -> 0

return 0

Case 3:
[1, 2, 3, 4] target = 5

l = 0 -> 2 -> 3 -> 4
r = 3
mid = 1 -> 2 -> 3

return -1

Case 4:
[1] target = 1

l = 0
r = 0
mid = 0

return 0

Case 5:
[1] target = 2

l = 0 -> 1
r = 0
mid = 0

return -1


*/

