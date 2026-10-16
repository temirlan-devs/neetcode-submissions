class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = m + n - 1;

        while (m > 0 && n > 0) {
            if (nums2[n - 1] > nums1[m - 1]) {
                nums1[last] = nums2[n - 1];
                n--;
            }

            else {
                nums1[last] = nums1[m - 1];
                m--;
            }

            last--;
        }

        while (n > 0) {
            nums1[last] = nums2[n - 1];
            n--;
            last--;
        }

    }
}

/*
Time complexity: O(m + n). Worst case is when every number in nums1 is greater than every number in nums2
Space complexity: O(1)

*/

/*

Test 

Case 1:

[1, 2, 0, 0]
[3, 4]
res: [1, 2, 3, 4]
m = 2 n = 2 last = 3

while 2 > 0 and 2 > 0
4 > 2
nums1[3] = 4
n -> 1 last -> 2
[1, 2, 0, 4]

while 2 > 0 and 1 > 0
3 > 2
nums1[2] = 3
n -> 0 last -> 1
[1, 2, 3, 4]

Case 2:
[3, 4, 0, 0]
[1, 2]
res: [1, 2, 3, 4]
m = 2 n = 2 last = 3

while 2 > 0 and 2 > 0
2 > 4 false
nums1[3] = 4
m -> 1 last -> 2
[3, 4, 0, 4]

while 1 > 0 and 2 > 0
2 > 3 false
nums1[2] = 3
m -> 0 last -> 1
[3, 4, 3, 4]

while 2 > 0
nums1[1] = 2
n -> 1 last -> 0
[3, 2, 3, 4]

while 1 > 0
nums1[0] = 1
n -> 0 last -> -1
[1, 2, 3, 4]

Case 3:
[5, 0, 0]
[2, 3]
m = 1 n = 2 last = 2

while 1 > 0 and 2 > 0
3 > 5 false
nums1[2] = 5
m -> 0 last -> 1
[5, 0, 5]

while 2 > 0
nums1[1] = 3
n -> 1 last -> 0
[5, 3, 5]

while 1 > 0
nums1[0] = 2
[2, 3, 5]
n -> 0 last -> -1

Case 4:
[3, 4, 5, 0]
[1]
m = 3 n = 1 last = 3

while 3 > 0 and 1 > 0
if 1 > 5 false
nums1[3] = 5
m -> 2 last -> 2
[3, 4, 5, 5]

while 2 > 0 and 1 > 0
if 1 > 4 false
nums1[2] = 4
m -> 1 last -> 1
[3, 4, 4, 5]

while 1 > 0 and 1 > 0
if 1 > 3 false
nums1[1] = 3
m -> 0 last -> 0
[3, 3, 4, 5]

while 1 > 0
nums1[0] = 1
n -> 0 last -> -1
[1, 3, 4, 5]

Case 5:
[0, 0]
[3, 4]

m = 0 n = 2 last = 1

while false

while 2 > 0
nums1[1] = 4
n -> 1 last -> 0
[0, 4]

while 1 > 0
nums1[0] = 3
n -> 0 last -> -1
[3, 4]

Case 6:
[3, 4]
[0, 0]
m = 2 n = 0 last = 1

[3, 4]








*/