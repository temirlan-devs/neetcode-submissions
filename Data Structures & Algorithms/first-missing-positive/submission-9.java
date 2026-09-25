
class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int n = nums.length; 

        // O(n)
        for (int i = 0; i < n; i++) 
            if (nums[i] < 0) nums[i] = 0;

        // O(n)
        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);

            if (1 <= val && val <= n) {
                if (nums[val - 1] > 0) {
                    nums[val - 1] *= -1;
                }
                else if (nums[val - 1] == 0) {
                    nums[val - 1] = (n + 1) * -1;
                }
            }
        }

        // O(n)
        for (int i = 1; i <= n; i++) 
            if (nums[i - 1] >= 0) return i;

        return n + 1;

    }
}

// Time complexity: O(n)
// Space complexity: O(1)


/*

Test

Case 1:
[1, 2, 3] n = 3

1st for loop:
[1, 2, 3]

2nd for loop:
i = 0
val = 1
[-1, 2, 3]

i = 1
val = 2
[-1, -2, 3]

i = 2
val = 3
[-1, -2, -3]

3rd for loop:
i = 1
nums[0] = -1

i = 2
nums[1] = -2

i = 3
nums[2] = -3

return 3 + 1 = 4


Case 2:
[1, 2, 4, 5] n = 4

1st for loop:
[1, 2, 4, 5]

2nd for loop:
i = 0
val = 1
[-1, 2, 4, 5]

i = 1
val = 2
[-1, -2, 4, 5]

i = 2
val = 4
[-1, -2, 4, -5]

i = 3
val = 5
out of bounds

3rd for loop:
i = 1
val = -1

i = 2
val = -2

i = 3
val = 4
return 3

Case 3:
[5, 6, 7, 2] n = 4

1st for loop:
[5, 6, 7, 2]

2nd for loop:
i = 0
val = 5
out of bounds

i = 1
val = 6
out of bounds

i = 2
val = 7
out of bounds

i = 3
val = 2
[5, -6, 7, 2]

3rd for loop:
i = 1
val = 5 
return 1


Case 4:

[-1, -2, -3, 4, 5] n = 5

1st for loop:
[0, 0, 0, 4, 5]

2nd for loop:
i = 0
val = 0

i = 1
val = 0

i = 2
val = 0

i = 3
val = 4
[0, 0, 0, -4, 5]

i = 4
val = 5
[0, 0, 0, -4, -5]

3rd for loop:
i = 1
val = 0 -> return 1


Case 5:
[-4, -5, -6, 3, 4] n = 5

1st for loop:
[0, 0, 0, 3, 4]

2nd for loop:
i = 0
val = 0

i = 1
val = 0

i = 2
val = 0

i = 3
val = 3
[0, 0, -6, 3, 4]

i = 4
val = 4
[0, 0, -6, -3, 4]

3rd for loop:
i = 1
val = 0  
return 1


*/