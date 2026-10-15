class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int l = 0;
        int r = numbers.length - 1;

        // O(n)
        while (l < r) {
            if (numbers[l] + numbers[r] > target) r--;
            else if (numbers[l] + numbers[r] < target) l++;
            else return new int[]{l + 1, r + 1};
        }

        return new int[0];

    }
}

// Time Complexity: O(n). Space complexity: O(1)

/*

Test

Case 1:
[1, 2, 3] target  = 3

while 0 < 2
1 + 3 = 4
r -> 1

while 0 < 1
1 + 2 = 3
return [1, 2]

Case 2:
[4, 5, 6, 7] target = 12

while 0 < 3
4 + 7 = 11
l -> 1

while 1 < 3
5 + 7  = 12
return [2, 4]

Case 3:
[1, 2] target = 3

while 0 < 1
1 + 2 = 3
return [1, 2]


*/

