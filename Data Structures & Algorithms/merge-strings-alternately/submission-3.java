class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        StringBuilder sb = new StringBuilder();

        int r = 0;
        for (; r < Math.min(word1.length(), word2.length()); r++) {
            sb.append(word1.charAt(r));
            sb.append(word2.charAt(r));
        }

        if (r < word1.length()) sb.append(word1.substring(r));
        else sb.append(word2.substring(r));

        return sb.toString();
    }
}