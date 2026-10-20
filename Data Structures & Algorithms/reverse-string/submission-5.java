class Solution {
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;

        // O(n)
        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;

            l++; r--;
        }
    }
}

// Time complexity: O(n). Space complexity: O(1)
/*

Test

Case 1:

[s, o, n, g]

while 0 < 3
[g, o, n, s]
l -> 1 r -> 2

while 1 < 2
[g, n, o, s]
l -> 2 r -> 1

Case 2:
[h, e, l, l, o]

while 0 < 4
[o, e, l, l, h]
l -> 1 r- -> 3

while 1 < 3
[o, l, l, e, h]
l -> 2 r -> 2

Case 3:
[w]

l = 0 r = 0





*/