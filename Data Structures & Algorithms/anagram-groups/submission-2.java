class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            char[] sortedchars = str.toCharArray();
            Arrays.sort(sortedchars);
            String sortedString = new String(sortedchars);

            if (!map.containsKey(sortedString)) 
                map.put(sortedString, new ArrayList<>());

            map.get(sortedString).add(str);
        }

        List<List<String>> result = new ArrayList<>(map.values());

        /*
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }
        */
        return new ArrayList<>(map.values());
    }
}


/*
["tea", "eat", "aet", "hey", "car"]



*/
