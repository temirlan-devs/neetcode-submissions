class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();

        int l = 0, count = 0, maxF = 0;

        for (int r = 0; r < s.length(); r++) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            maxF = Math.max(maxF, map.get(s.charAt(r)));

            if ( (r - l + 1) - maxF > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }

            count = Math.max(count, r - l + 1);
        }

        return count;
    }
}

/*

Test

Case 1:
AAABA k = 1

count = 0 -> 1 -> 2 -> 3 -> 4 -> 5
maxF = 0 -> 1 -> 2 -> 3 -> 4

map:
A - 4
B - 1

return 5

Case 2:
AABXYKKK k = 2

count = 0 -> 1 -> 2 -> 3 -> 4 -> 5
maxF = 0 -> 1 -> 2 -> 3

map:
A - 0
B - 1
X - 1
Y - 1
K - 3

return 5

Case 3:
AB k = 0

count = 0 -> 1
maxF = 0 -> 1

map:
A - 0
B - 1

return 1

Case 4:
A k = 1

count = 0 -> 1
maxF = 0 -> 1

map:
A - 1

return 1







*/

