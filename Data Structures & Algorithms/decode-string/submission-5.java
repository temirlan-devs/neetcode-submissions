class Solution {
    public String decodeString(String s) {
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        StringBuilder cur = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {

            if (Character.isDigit(c)) k = (k * 10) + (c - '0');

            else if (c == '[') {
                stringStack.push(cur.toString());
                countStack.push(k);
                cur = new StringBuilder();
                k = 0;
            }

            else if (c == ']') {
                String temp = cur.toString();
                cur = new StringBuilder(stringStack.pop());
                int count = countStack.pop();
                for (int i = 0; i < count; i++) {
                    cur.append(temp);
                }
            }

            else cur.append(c);
        }

        return cur.toString();
    }
}

// Time/Space complexity: O(n + M), where n is the number of characters in the input and M is the number of characters in the output

/*

Test

Case 1:
abc

for a
cur -> a
for b
cur -> ab
for c
cur -> abc

return abc

Case 2:

2[a]3[b]

for 2
k = 2

for [
s -> ""
c -> 2
cur = new sb
k = 0

for a
cur -> a

for ]
temp = a
cur = ""; s ->
count = 2; c ->
cur -> aa

for 3
k = 3

for [
s -> aa
c -> 3
cur = new sb
k = 0

for b
cur -> b

for ]
temp = b
cur = aa; s ->
count = 3; c ->
cur -> aabbb

return aabbb

Case 3:

2[a]3[b]c

for 2
k = 2

for [
s -> ""
c -> 2
cur = new sb
k = 0

for a
cur -> a

for ]
temp = a
cur = ""; s ->
count = 2; c ->
cur -> aa

for 3
k = 3

for [
s -> aa
c -> 3
cur = new sb
k = 0

for b
cur -> b

for ]
temp = b
cur = aa; s ->
count = 3; c ->
cur -> aabbb

for c
cur -> aabbbc

return aabbbc

Case 4:
2[a]b3[c]

for 2
k = 2

for [
s -> ""
c -> 2
cur = new sb
k = 0

for a
cur -> a

for ]
temp = a
cur = ""; s ->
count = 2; c ->
cur = aa

for b
cur -> aab

for 3
k = 3

for [
s -> aab
c -> 3
cur = new sb
k = 0

for c
cur -> c

for ]
temp = c
cur = aab; s ->
count = 3; c ->
cur = aabccc


Case 5:
2[x3[y]]

for 2
k = 2

for [
s -> ""
c -> 2
cur = new sb
k = 0

for x
cur -> x

for 3
k = 3

for [
s -> "", x
c -> 2, 3
cur = new sb
k = 0

for y
cur -> y

for ]
temp = y
cur = x; s -> ""
count = 3; c -> 2
cur -> xyyy


for ]
temp = xyyy
cur = ""; s -> 
count = 2; c ->
cur -> xyyyxyyy

return xyyyxyyy



Case 6:
2[a3[b4[c]]]

for 2
k = 2

for [
s -> ""
c -> 2
cur = new sb
k = 0

for a
cur -> a

for 3
k = 3

for [
s -> "", a
c -> 2, 3
cur = new sb
k = 0

for b
cur -> b

for 4
k = 4

for [
s -> "", a, b
c -> 2, 3, 4
cur = new sb
k = 0

for c
cur -> c

2[a3[b4[c]]]


for ]
temp = c
cur = b; s -> "", a
count = 4; c -> 2, 3
cur -> bcccc

for ]
temp = bcccc
cur = a; s -> ""
count = 3; c -> 2
cur -> abccccbccccbcccc

for ]
temp = abccccbccccbcccc
cur = ""; s ->
count = 2; c ->
cur -> abccccbccccbccccabccccbccccbcccc

return abccccbccccbccccabccccbccccbcccc










*/
