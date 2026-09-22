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

/*

Test

Case 1:

["Hello", "Bye"]

encode()
Hello
sb -> 5#Hello
Bye
sb -> 5#Hello3#Bye

return sb

decode(5#Hello3#Bye)

i = 0
while 0 < 12
j = i = 0
j -> 1
length = 5
i = 2
j = 7
res -> {Hello}
i = 7

while 7 < 12
j = i = 7
j -> 8
length = 3
i = 9
j = 12
res -> {Hello, Bye}
i = 12

return res -> {Hello, Bye}



Case 2:
[""]

encode()
""
sb -> 0#
return sb

decode (0#)
i = 0
while 0 < 2
j = i = 0
j -> 1
length = 0
i = 2
j = 2
res -> {""}
j = 2

return res -> {""}


Case 3:
[]

encode()
return ""

decode("")
return new ArrayList<>();

Case 4:
[He, B#e]

encode()
He
sb -> 2#He
B#e
sb -> 2#He3#B#e

decode (2#He3#B#e)

i = 0
while 0 < 9
j = 0
j - > 1
length = 2
i = 2
j = 4
res -> {He}
i = 4

4 < 9
j = 4
j -> 5
length = 3
i = 6
j = 9
res -> {He, B#e}
i = 9

return res -> {He, B#e}

*/
