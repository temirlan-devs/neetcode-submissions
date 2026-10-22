class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();

        int l = 0;
        int count = 0;

        for (int r = 0; r < s.length(); r++) {

            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);

            while ( (r - l + 1) - Collections.max(map.values()) > k ) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }

            count = Math.max(count, r - l + 1);
        }

        return count;

    }
}


/*

n - k

(n - 1) - (k - 1)

n - 1 - k + 1 -> n - k
*/