class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        // O(n)
        while (l < r) {
            while (l < r && !isAlphaNum(s.charAt(l))) l++;
            while (r > l && !isAlphaNum(s.charAt(r))) r--;

            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) return false;

            l++;
            r--;
        }

        return true;
    }

    public boolean isAlphaNum(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}

// Time complexity: O(n). Space complexity: O(1)

/*

Test

Case 1:
[tea,,aet]

l = 0
r = 7

while (0 < 7)
l -> 1 r -> 6

while (1 < 6)
l -> 2 r -> 5

while (2 < 5)
l -> 3 r -> 4

while 3 < 4
lc = ,
while 3 < 4 and nonan 
l -> 4
while 4 > 4 and nonan false, while loop doesn't run
l and r are 4 so they pass check even though it is a non alphanumeric
l -> 5
r -> 3

return true

Case 2:
[teaaet]

while 0 < 5
l -> 1 r -> 4

while 1 < 4
l - > 2 r -> 3

while 2 < 3
l -> 3 r -> 2

return true

Case 3
[c,a,,t,,,ta,,c]

l = 0
r = 13

while 0 < 13
l -> 1 r -> 12

while 1 < 12
lc = ,
while 1 < 12 and nonan
l -> 2
while 12 > 2 and nonan
r -> 11
while 11 > 2 and nonan
r -> 10
a == a
l -> 3 r -> 9

while 3 < 9
lc = ,
while 3 < 9 and nonan
l -> 4
while 4 < 9 and nonan
l -> 5
t == t
l -> 6
r -> 8

while 6 < 8
while 6 < 8 and nonan
l -> 7
while 7 < 8 and nonan
l-> 8
while 8 > 8 and nonan false while loop doesn't runt
l -> 9 r -> 7

return true

Case 4
[sammbs]

while 0 < 5
l -> 1 r -> 4

while 1 < 4
return false

Case 5
[,! ]

while 0 < 2
while 0 < 2 and nonan -> l -> 2
while 2 > 2 and nonan false while loop doesn't run

return true

Case 6
[a]

while 0 < 0
return true

Case 7
[,]

while 0 < 0
return true




*/

