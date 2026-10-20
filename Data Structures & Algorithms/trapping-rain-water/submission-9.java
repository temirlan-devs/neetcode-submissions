class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int lm = height[l], rm = height[r];
        int res = 0;

        // O(n)
        while (l < r) {
            if (lm < rm) {
                l++;
                lm = Math.max(lm, height[l]);
                res += lm - height[l];
            } else {
                r--;
                rm = Math.max(rm, height[r]);
                res += rm - height[r];
            }
        }

        return res;

    }
}

// Time complexity: O(n). Space complexity: O(1)


/*

Test

Case 1:
[0, 2, 0, 3, 1, 3, 2, 1]

l = 0, r = 7
lm = 0, rm = 1

up to date: lm = 3, rm = 3

while 0 < 7
l -> 1
lm = 2
res -> 0

while 1 < 7
r -> 6
rm = 2
res -> 0

while 1 < 6
r -> 5
rm = 3
res -> 0

while 1 < 5
l -> 2
lm = 2
res -> 2

while 2 < 5
l -> 3
lm = 3
res -> 2

while 3 < 5
r -> 4
rm = 3
res -> 4

while 3 < 4
r -> 3
rm = 3
res -> 4

return 4

Case 2:
[1]

l = 0, r = 0
lm = 1, rm = 1

return 0

Case 3:
[1, 2]

l = 0, r = 1
lm = 1, rm = 2

while 0 < 1
l -> 1
lm = 2
res -> 0

return 0

Case 4:
[2, 1]
l = 0, r = 1
lm = 2, rm = 1

while 0 < 1
r -> 0
rm = 2
res -> 0

return 0






*/



