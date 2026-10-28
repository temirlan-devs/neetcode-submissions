class Solution {

    int x;  

    public int mySqrt(int x) {
        this.x = x;
        int r = x;
        int l = 1;

        // O(logn)
        while (l <= r) {
            int m = l + (r - l) / 2;

            if (isCorrect(m) > 0) l = m + 1;
            else if (isCorrect(m) < 0) r = m - 1;
            else return m;
        }

        return r;

    }

    public int isCorrect(long val) {
        if (val * val < x) return 1;
        else if (val * val > x) return -1;
        else return 0;
    }
}

// Time complexity: O(logn). Space complexity: O(1)

/*

Test

Case 1:
[1, 2, 3, 4] x = 4

l = 1
r = 4
m = 2

return 2

Case 2:
[1, 2, 3, 4, 5] x = 5

l = 1 -> 2 -> 3
r = 5 -> 2
m = 3 -> 1 -> 2

return 2

Case 3:
x = 0

l = 1
r = 0

return 0

Case 4:
[1] x = 1

l = 1
r = 1
m = 1

return 1




*/