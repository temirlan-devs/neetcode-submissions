class Solution {

    // O(m + n) - time/space
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder(); // O(m + n) - space

        // O(m + n) where m is the sum of lengths of all strings and n is the number of strings, which are constant work like length and # - time
        for (String str : strs) {
            sb.append(str.length()).append("#").append(str);
        }
        
        // Time/Space - O(m + n)
        return sb.toString(); 
    }

    // O(m + n) - time/space
    public List<String> decode(String str) {
        List<String> res = new ArrayList<>(); // O(m + n) - space

        int i = 0;

        // O(m + n)
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') j++;

            // Two substrings below are O(m + n) in total

            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + length;

            res.add(str.substring(i, j));

            i = j;

        }

        return res;
    }
}


// Time complexity: O(m + n)
// Space complexity: O(m + n)
