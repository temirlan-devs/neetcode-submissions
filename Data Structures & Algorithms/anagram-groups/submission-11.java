class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>(); // O(m * n) -> O(m * 100) -> O(m)

        


        // O(m) where m is the number of strings in strs
        for (String str : strs) {

            char[] charsinstr = str.toCharArray(); // // O(100) -> O(1)
            char[] alphabet = new char[26]; // O(26) -> O(1)

            // O(n) is the number of chars in charsinstr. O(100) -> O(1)
            for (char c : charsinstr) {
                alphabet[c - 'a']++;
            }

            // O(26) -> O(1)
            String key = new String(alphabet);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());

    }
}
 

// Time, space: O(m)