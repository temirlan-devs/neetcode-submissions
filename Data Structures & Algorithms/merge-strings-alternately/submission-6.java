class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();

        int l = 0;

        for (;l < Math.min(word1.length(), word2.length()); l++) {
            sb.append(word1.charAt(l));
            sb.append(word2.charAt(l));
        }

        sb.append(word1.substring(l));
        sb.append(word2.substring(l));

        return sb.toString();

    }
}

// Time complexity: O(n + m), where n and is the number of characters in the word1 and m is the number of characters in the word2. For loop does work for part of the words and rest code does work for the rest character of the words
// Space complexity: O(n + m). For the reason above

/*

Test

Case 1:
[tim, cal]

for l = 0 < 3
sb -> tc

for l = 1 < 3
sb -> tcia

for l = 2 < 3
sb -> tciaml
l = 3

return tciaml

Case 2:
[abc, abcd]

for  l = 0 < 3
sb -> aa

for l = 1 < 3
sb -> aabb

for l = 2 < 3
sb -> aabbcc
l = 3

l < 4
sb -> aabbccd

return aabbccd

Case 3:
[a, b]

for r = 0 < 1
sb -> ab

return ab




*/