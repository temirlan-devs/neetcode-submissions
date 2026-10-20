class Solution {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        // O(n) - time
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return 
                isPalindrome(s.substring(0, l) + s.substring(l + 1)) // O(n - 1) for time and space and it is only executed once
                ||
                isPalindrome(s.substring(0, r) + s.substring(r + 1)); // O(n - 1) for time and space and it is only executed once
            }
            l++; r--;
        }

        return true;

    }

    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        // O(n)
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++; r--;
        }

        return true;
    }
}

// Time, Space complexity: O(n)

/*

Test

Case 1:
[tat]

l = 0, r = 2

while 0 < 2
l -> 1 r -> 1

return true

Case 2:
[tata]

l = 0, r = 3

while 0 < 3
if t != a
return isPalindrome(ata) -> true

return true

Case 3:
[cata]

l = 0, r = 3

while 0 < 3
c != a
return isPalindrome(ata) -> true

return true

Case 4:
[deat]

l = 0 r = 3

while 0 < 3
d != t
return isPalindrome(eat) -> false || isPalindrome(dea) -> false
return false


Case 5:
[dclaaac]

l = 0 r = 6

while 0 < 6
d != c
return isPalindrome(claaac) -> false isPalindrome(dclaaa) -> false
return false

Case 6:
[a]

l = 0 r = 0

return true

Case 7:
[aa]

l = 0 r = 1 

while 0 < 1
l -> 1 r -> 0

return true

Case 8:
[ab]

l = 0 r = 1

while 0 < 1
a != b
return isPalindrome(b) -> true

return true

Case 9:
[eceec]

while 0 < 4
e != c
return isPalindrome(ceec) -> true
return true




Case 10:
[cdaac]

while 0 < 4
l -> 1 r -> 3

while 1 < 3
d != a
return isPalindrome(caac) -> true
return true

cdaggtdc

while 0 < 7
l -> 1 r -> 6

while 1 < 6
l -> 2 r -> 5

while 2 < 5
a != t
return isPalindrome(cdggtdc) -> false ||| isPalindrome(cdaggdc) -> false
return false





*/