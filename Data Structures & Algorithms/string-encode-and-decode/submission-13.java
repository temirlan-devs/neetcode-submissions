class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();


        for (String str : strs) {
            sb.append(str.length()).append("#").append(str); // O(n + m) for time and space  where n is the number of strings and m is the number of total charaters in all strings. length and # are appended n times, that's why n is accounted in Big O
        }

        return sb.toString(); // O(n + m)
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>(); // O(m + n) - space

        int i = 0; 

        // All while loops in total go through the whole string -> O(n + m) - time
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + length;

            res.add(str.substring(i, j));

            i = j;
        }

        return res;
    }
}

// Time, space complexity: O(m + n)


/*

Case 1:

input: {"Hello", "World"}

encode():
  5#Hello5#World

decode():
   i = 0
   while 0 < 14
	j = 0
	while != # -> j = 1
	length = 5
	i = 2
	j = 7
	res -> {"Hello"}
	i = 7

	j = 7
	while != # -> j = 8
	length = 5
	i = 9
	j = 14
	res -> {"Hello", "World"}
	i = 14

return res -> {"Hello", "World"}


Case 2:

input: {""}

encode():
	0#

decode():
	i = 0
	while 0 < 2
		j = 0
		while != # -> j = 1
		length = 0
		i = 2
		j = 2
		res -> {""}
		i = 2
return res -> {""}


Case 3:

input: {" "}

encode():
	1#_

decode():
	i = 0
	while 0 < 3
		j = 0
		while != # -> j = 1
		length = 1
		i = 2
		j = 3
		res -> {" "}
		i = 3
 return res -> {" "}


Case 4:

input: {}

encode():
	""

decode():
i = 0
while 0 < 0
return new ArrayList<>()

*/



