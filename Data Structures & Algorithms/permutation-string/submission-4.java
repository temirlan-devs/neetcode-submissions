class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> s1map = new HashMap<>();
        Map<Character, Integer> s2map = new HashMap<>();

        for (char c : s1.toCharArray()) s1map.put(c, s1map.getOrDefault(c, 0) + 1);

        int l = 0;
        for (int r = 0; r < s2.length(); r++) {
            s2map.put(s2.charAt(r), s2map.getOrDefault(s2.charAt(r), 0) + 1);

            if ( (r - l + 1) >= s1.length() ) {
                if (s2map.equals(s1map)) return true;
                s2map.put(s2.charAt(l), s2map.get(s2.charAt(l)) - 1);
                if (s2map.get(s2.charAt(l)) == 0) s2map.remove(s2.charAt(l));
                l++;
                 
            }
        }

        return false;
    }
}
