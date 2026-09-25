class Solution {

    int[] nums;

    public void sortColors(int[] nums) {
        this.nums = nums;
        int i = 0, l = 0, r = nums.length - 1;

        while (i <= r) {
            if (nums[i] == 0) {
                swap(l, i);
                l++;
            } 
            else if (nums[i] == 2) {
                swap(i, r);
                r--;
                i--;
            }
            i++;
        }
    }

    public void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


/*

Time complexity: O(n). Single pass
Space complexity: O(1)

Test

Case 1:
[2, 1, 0]

i = 0, l = 0, r = 2

while 0 <= 2
n[0] = 2; [0, 1, 2]; r -> 1

while 1 <= 2
n[1] = 1; i -> 2

while 2 <= 2
n[2] = 2; [0, 1, 2]; r -> 1

Case 2:
[1, 2, 0]

i = 0, l = 0, r = 2

while 0 <= 2
n[0] = 1; i -> 1

while 1 <= 2
n[1] = 2; [1, 0, 2]; r -> 1

while 1 <= 1
n[1] = 0; [0, 1, 2]; l -> 1, i -> 2

Case 3:
[0, 2, 1]

i = 0, l = 0, r = 2

while 0 <= 2
n[0] = 0; [0, 2, 1]; l -> 1; i -> 1

while 1 <= 2
n[1] = 2; [0, 1, 2]; r -> 1

while 1 <= 1
n[1] = 2; [0, 1, 2]; r -> 0

Case 4:
[2, 0, 1, 1, 1, 2, 1]

i = 0, l = 0, r = 6

while 0 <= 6
n[0] = 2; [1, 0, 1, 1, 1, 2, 2]; r -> 5

while 0 <= 5
n[0] = 1; i -> 1

while 1 <= 5
n[1] = 0; [0, 1, 1, 1, 1, 2, 2]; l -> 1, i -> 2

while 2 <= 5
n[2] = 1; i -> 3

while 3 <= 5
n[3] = 1; i -> 4

while 4 <= 5
n[4] = 1; i - > 5

while 5 <= 5
n[5] = 2; [0, 1, 1, 1, 1, 2, 2]; r -> 4

Case 5:
[0]

i = 0, l = 0, r = 0

while 0 <= 0
n[0] = 0; [0]; l -> 1; i => 1

*/