class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();

        // O(m) times outer for loop runs where m is the num of strings
        for (String str : strs) {
            int[] count = new int[26];

            // O(n) time inner for loop runs where n is the num of chars
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            // Runs for O(26) times each iterations
            // Space complexity: O(26) -> O(1)
            String key = Arrays.toString(count);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values()); // at the end it stores O(m * n)
                                              // where m is the number of strings
                                              // and n is the number of chars

    }
}

/*

Time complexity: O(m * n)
Space complexity: O(m * n)

Test

Case 1:
[tea, eat, aet, ban, kan, nab]

tea
aet
map: aet -> tea

eat
aet
map: aet-> tea, eat

aet
aet
map: aet -> tea, eat, aet

ban
abn
map: aet -> tea, eat, aet; abn -> ban

kan
akn
map: aet -> tea, eat, aet; abn -> ban; akn -> kan

nab
abn
map: aet -> tea, eat, aet; abn -> ban, nab; akn -> kan

return [[tea, eat, aet], [ban, nab], [kan]


Case 2:
[abc, def]

abc
abc
map: abc -> abc

def
def
map: abc -> abc; def -> def

return [[abc], [def]]

Case 3:
[""]

""
""
map: "" -> ""

return [[""]]
 

*/
