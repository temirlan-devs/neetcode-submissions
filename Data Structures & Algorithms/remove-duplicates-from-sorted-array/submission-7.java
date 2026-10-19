class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 1;

        // O(n)
        for (int r = 1; r < nums.length; r++) {
            if (nums[r] != nums[r - 1]) {
                nums[l] = nums[r];
                l++;
            }
        }

        return l;
    }
}

// Time complexity: O(n). Space complexity: O(1)

/*

Test

Case 1:
[1, 2, 3]

for r = 1 -> 2
2 != 1
nums[1] = nums[1]
l -> 2

for 2 -> 3
3 != 2
nums[2] = nums[2]
l -> 3

Case 2:
[1, 1, 2]

for r = 1 -> 1
1 != 1 false

for r = 2 -> 2
2 != 1
nums[1] = nums[2] = 2
[1, 2, 2]
l -> 2

retrun 2

Case 3:
[1, 1, 1, 2, 2, 3]

for r = 1 -> 1
1 == 1
for r = 2 -> 1
1 == 1

for r = 3
2 != 1
nums[1] = nums[3] = 2
[1, 2, 1, 2, 2, 3]
l -> 2

for r = 4
2 == 2

for r = 5
3 != 2
nums[2] = nums[5] = 3
[1, 2, 3, 2, 2, 3]
l -> 3

return 3

Case 4:
[1]

return 1


*/
