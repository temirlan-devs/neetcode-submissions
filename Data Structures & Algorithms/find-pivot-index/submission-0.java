class Solution {
    public int pivotIndex(int[] nums) {
        int left = 0;
        int n = nums.length;

        int[] prefix = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += nums[i];
            prefix[i] = total;
        }

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

*/