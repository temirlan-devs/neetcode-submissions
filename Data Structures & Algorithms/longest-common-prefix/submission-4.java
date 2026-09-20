class Solution {
    public String longestCommonPrefix(String[] strs) {
        

        // O(m) - where m is the length of the shortest string, because our loop terminates early once it exceeds the length of the shortest string
        for (int i = 0; i < strs[0].length(); i++) {

            // O(n) - where n is the number of strings
            for (String str : strs) {
                if (i == str.length() || str.charAt(i) != strs[0].charAt(i)) {
                    return str.substring(0, i); // O(k) where k is the number of characters in a substring, but it only gets executed once because it is a return statement
                }
            }

        }

        return strs[0];
    }
}

 /*
 
 Time Complexity: O(m * n)
 Space complexity: O(1) since we did not use extra space

 */

 
/*
Test 
Case 1:
[flo, flower, flosk]

i = 0
flo
flower; f = f
flosk; f = f

i = 1
flo
flower; l = l
flosk; l = l

i = 2
flo
flower; o = 0
flosk; o = 0

return flo

Case 2:
[set, sep, sek]

i = 0
set
sep; s = s
sek; s = s

i = 1
set
sep; e = e
sek; e = e

i = 2
set
sep; p != t; return se

Case 3:
[apex, ape]

i = 0
apex;
ape; a = a

i = 1
apex
ape; p = p

i = 2
apex
ape; e = e

i = 3
apex
ape; 3 = 3 -> return ape


Case 4:
["neet", "feet"]

i = 0
neet
feet; n != f; -> return ""

*/