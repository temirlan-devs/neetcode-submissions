class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int total = 0;
        int l = 0;
        int count = 0;


        for (int i = 0; i < k - 1; i++) total += arr[i];

        for (int r = k - 1; r < arr.length; r++) {
            total += arr[r];

            int avg = total / k;
            if (avg >= threshold) count++;
            total -= arr[l];
            l++;
        }

        return count;
    }
}

/*
Time complexity: O(n). Both for loops do n works in total
Space complexity: O(1)

*/

/*

Test

Case 1:

[1, 2, 3, 4] k = 2  threshold = 2

1st for loop: total = 1

for 1 < 4
total = 3
avg = 1
total = 2
l -> 1

for 2 < 4
total = 5
avg = 2
count -> 1
total = 3
l -> 2

for 3 < 4
total = 7
avg = 3
count -> 2
total = 4
l -> 3

return 2

Case 2:
[1] k = 1 threshold = 1

1st for loop: total = 0

for 0 < 1
total = 1
avg = 1
count -> 1
total = 0
l -> 1

return 1

Case 3:
[1] k = 1 threshold = 2

1st for loop: total = 0

for 0 < 1
total = 1
avg = 1
total = 0
l -> 1

return 0



*/

