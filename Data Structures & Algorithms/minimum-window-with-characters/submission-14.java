class Solution {
    public String minWindow(String s, String t) {

        if (t.length() > s.length()) return "";
        
        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) countT.put(c, countT.getOrDefault(c, 0) + 1);

        int have = 0, need = countT.size();
        int[] res = new int[2];
        int resLen = Integer.MAX_VALUE;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char cur = s.charAt(r);
            window.put(cur, window.getOrDefault(cur, 0) + 1);
            if (countT.containsKey(cur) && window.get(cur).equals(countT.get(cur))) have++;

            while (have == need) {
                if (r - l + 1 < resLen) {
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

    }
}
