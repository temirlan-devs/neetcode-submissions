class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        
        for (int i = 0; i < strs.length; i++) {
            String curString = strs[i];

            int[] charsArr = new int[26];
            for (char c : curString.toCharArray()) {
                charsArr[c - 'a']++;
            }
            String key = Arrays.toString(charsArr);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(curString);
        }

        return new ArrayList<>(map.values());

    }
}
