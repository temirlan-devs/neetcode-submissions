class Solution {
    public int pivotIndex(int[] nums) {
        
        int total = 0;
        // O(n)
        for (int num : nums) {
            total += num;
        }

        int leftSum = 0;
        // O(n)
        for (int i = 0; i < nums.length; i++) {
            int rightSum = total - leftSum - nums[i];
            if (rightSum == leftSum) return i;
            leftSum += nums[i]; 
        }

        return -1;
        
    }
}

/*

Time complexity: O(n)
Space complexity: O(1)

Case 1:
[7, 2, 3, 4]

total = 16
leftsum = 0

i = 0
rightsum = 16 - 0 - 7 = 9
leftsum = 7

i = 1
rightsum = 16 - 7 - 2 = 7
return 1

Case 2:
[1, 2, 3]

total = 6
leftSum = 0

i = 0
rightsum = 5
leftsum = 1

i = 1
rightsum = 6 - 1 - 2 = 3
leftsum = 3

i = 2
rightsum = 6 - 3 - 3 = 0
leftsum = 6

return -1


*/



/* 

Precomputed prefix sums approach:

class Solution {
    public int pivotIndex(int[] nums) {
        int left = 0;
        int n = nums.length;

        int[] prefix = new int[n];
        int total = 0;

        // O(n)
        for (int i = 0; i < n; i++) {
            total += nums[i];
            prefix[i] = total;
        }

        // O(n)
        while (left < n) {
            int sumBeforeLeft = left > 0 ? prefix[left - 1] : 0;
            int sumAfterLeft = prefix[n - 1] - prefix[left];

            if (sumBeforeLeft == sumAfterLeft) return left;

            left++; 
        }

        return -1;
    }
}


/*

Time complexity: O(n)
Space complexity: O(n)


Test

Case 1:
[7, 2, 3, 4]
[7, 9, 12, 16]

left = 0
sbl = 0
sal = 9

left = 1
sbl = 7
sal = 16 - 9 = 7
return 1


Case 2:
[1, 2, 3]
[1, 3, 6]

left = 0
sbl = 0
sal = 6

left = 1
sbl = 1
sal = 3

left = 2
sbl = 3
sal = 6 - 6 = 0


return -1

Case 3:
[1]

left = 0
sbl = 0
sal = 0

return 0



Case 4:
[2, 1, -1]
[2, 3, 2]

left = 0
sbl = 0
sal = 0

return 0


[7, 2, 3, 4]
[7, 9, 12, 16]

i = 0
rightsum = 16 - 0 - 7 = 9
leftSum = 7

i = 1
rightSum = 16 - 7 - 2 = 7
return 1
leftSum = 9

i = 2
rightSum = 16 - 9 - 3 = 4


*/


