class Solution {
    public String minWindow(String s, String t) {
        // for case when t can be empty. In this particular problem t cannot be empty
        if (t.isEmpty()) return ""; 
        if (t.length() > s.length()) return "";

        Map<Character, Integer> countT = new HashMap<>(); // O(52) -> O(1) - space. Let's say O(k)
        Map<Character, Integer> window = new HashMap<>(); // O(52) -> O(1) - space. Let's say O(k)

        // O(t) - time, where t is number of characters in string t
        for (char c : t.toCharArray()) countT.put(c, countT.getOrDefault(c, 0) + 1);

        int have = 0, need = countT.size();
        int[] res = new int[2]; // O(2) -> O(1) - space
        int resLen = Integer.MAX_VALUE;
        int l = 0;

        // O(s) - time, where r is the number of characters in string s
        for (int r = 0; r < s.length(); r++) {
            
            char cur = s.charAt(r);
            window.put(cur, window.getOrDefault(cur, 0) + 1);

            if (countT.containsKey(cur) && window.get(cur).equals(countT.get(cur))) have++;

            // O(s) in total
            while (have == need) {
                if ( (r - l + 1) < resLen ) {
                    res[0] = l;
                    res[1] = r;
                    resLen = r - l + 1;
                }

                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);
                if (countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)) have--;
                l++;
            }

        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1); 
        // O(s) - time and space for substring function
    }
}


/*
Time complexity: O(t) + O(s) + O(s) -> O(s + t).
Space cmoplexity: O(s + k). Auxiliary: O(k), where k is the number of unique characters in s and t

*/



/*

Test

Case 1:

s = "ABCTYDECDE" t = "CDE"

countT:
C - 1
D - 1
E - 1

window:
C - 1 -> 0 -> 1
D - 1 -> 0 -> 1
E - 1 -> 0 -> 1

have = 0 -> 1 -> 0 -> 1 -> 0 -> 1 -> 0 -> 1
need = 3
l = 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
resLen = max -> 7 -> 6 -> 5 -> 4 -> 3
res = [5, 7]

return DEC

Case 2:

s = "AABCD"    t = "AABC"

count:
A - 2
B - 1
C - 1

window:
A - 1 -> 2 -> 1
B - 1
C - 1

have = 0 -> 1 -> 2 -> 3 -> 2
need = 3
l = 0 -> 1
resLen = max -> 4
res = [0, 3]

return AABC

Case 3:
s = "ABC" t = "ABCD"

return ""




*/

