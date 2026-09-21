class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();
        

        for(String str : strs) {

            int[] charArray = new int[26];

            for (char c : str.toCharArray()) {
                charArray[c - 'a']++;
            }

            String key = new String(Arrays.toString(charArray));
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);

        }

        return new ArrayList<>(map.values());

    }
}
