class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        StringBuilder sb = new StringBuilder();
        int l = 0;
        for (;l < Math.min(word1.length(), word2.length()); l++) {
            sb.append(word1.charAt(l));
            sb.append(word2.charAt(l));    
        }

        if (l < word1.length()) sb.append(word1.substring(l));
        else if (l < word2.length()) sb.append(word2.substring(l));

        return sb.toString();
    
    }
}