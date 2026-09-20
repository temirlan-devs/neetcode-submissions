class Solution {
    public int removeElement(int[] nums, int val) {
        
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;

    }
}

/*

Time complexity: O(n)
Space complexity: O(1)

Test

Case 1:
[1, 2, 3, 2] val = 2

k = 0

i = 0; 1
1 != 2
[1, 2, 3, 2]
k -> 1

i = 1; 2
do nothing

i = 2; 3
3 != 2
[1, 3, 3, 2]
k -> 2

i = 3; 2
do nothing

return 2


Case 2:

[3, 3, 3, 4, 5, 6, 3, 8] val = 3

k = 0

i = 0; 3
do nothing
i = 1; 3
do nothing
i = 2; 3
do nothing

i = 3; 4
[4, 3, 3, 4, 5, 6, 3, 8]
k -> 1

i = 4; 5
[4, 5, 3, 4, 5, 6, 3, 8]
k -> 2

i = 5; 6
[4, 5, 6, 4, 5, 6, 3, 8]
k -> 3

i = 6; 3
do nothing

i = 7; 8
[4, 5, 6, 8, 5, 6, 3, 8]
k -> 4

return 4

Case 3:
[3, 3] val = 3

k = 0

i = 0; 3
do nothing
i = 1; 3
do nothing

Case 4:
[1, 2] val = 3

k = 0

i = 0; 1
[1, 2]
k -> 1

i = 1; 2
[1, 2]
k -> 2

return 2

Case 5:
[]

return 0


*/