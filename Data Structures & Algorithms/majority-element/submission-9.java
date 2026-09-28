class Solution {
    public int majorityElement(int[] nums) {
        int res = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) res = num;

            count += (num == res) ? 1 : -1;
        }

        return res;
    }
}

// Time complexity: O(n)
// Space complexity: O(1)

/*

Test

Case 1:
[1, 1, 2, 2, 1] n = 5; target = 3

res = 0; count = 0

for 1
count == 0 -> res = 1
1 == 1 -> count = 1

for 1
1 == 1 -> count = 2

for 2
2 != 1 -> count = 1

for 2
2 != 1 -> count = 0

for 1
count == 0 -> res = 1
1 == 1 -> count = 1

retrun 1


Case 2:

[1, 1, 2, 2, 3, 2, 2] n = 7; target = 4

res = 0; count = 0

for 1
count == 0 -> res = 1
1 == 1 -> count = 1

for 1
1 == 1 -> count = 2

for 2
2 != 1 -> count = 1

for 2 
2 != 1 -> count 0

[1, 1, 2, 2, 3, 2, 2]

for 3
count == 0 -> res = 3
3 == 3 -> count = 1

for 2
2 != 3 -> count = 0

for 2
count == 0 -> res = 2
2 == 2 -> count = 1

return 2



Case 3:

[1, 1, 2, 2, 3, 4, 2, 2, 2] n = 9; target = 5

res = 0; count = 0

for 1
count == 0 -> res = 1
1 == 1 -> count = 1

for 1
1 == 1 -> count = 2

for 2
2 != 1 -> count = 1

for 2 
2 != 1 -> count 0

[1, 1, 2, 2, 3, 2, 2]

for 3
count == 0 -> res = 3
3 == 3 -> count = 1

for 4
4 != 3 -> count = 0

for 2
count == 0 -> res = 2
2 == 2 -> count = 1

for 2
2 == 2 -> count = 2

return 2

Case 4:
[1]

res = 0; count = 0

for 1
count == 0 -> res = 1
1 == 1 -> count = 1

return 1

Case 5:
[2, 2]

count = 0; res = 0

for 2
count == 0 -> res = 2
2 == 2 -> count = 1

for 2
2 == 2 -> count = 2

return 2




*/