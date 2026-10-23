class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1count = new int[26]; // O(26) -> O(1) - space
        int[] s2count = new int[26]; // O(26) -> O(1) - space

        // O(s1) - time, where s1 is the length of s1
        for (int i = 0; i < s1.length(); i++) {
            s1count[s1.charAt(i) - 'a']++;
            s2count[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        // O(26) -> O(1) - time
        for (int i = 0; i < 26; i++) {
            if (s1count[i] == s2count[i]) matches++;
        }

        int l = 0;

        // O(s2 - s1), where s2 is the length of s2
        for (int r = s1.length(); r < s2.length(); r++) {
            if (matches == 26) return true;

            int index = s2.charAt(r) - 'a';
            s2count[index]++;
            if (s1count[index] == s2count[index]) {
                matches++;
            } else if (s1count[index] + 1 == s2count[index]) {
                matches--;
            }

            index = s2.charAt(l) - 'a';
            s2count[index]--;
            if (s1count[index] == s2count[index]) {
                matches++;
            } else if (s1count[index] - 1 == s2count[index]) {
                matches--;
            }
            l++;

        }

        return matches == 26;

    }
}

/*

Time complexity: O(s1) + O(26) + O(s2 - s1) = O(s1 + s2 - s1) = O(s2)
Space complexity: O(26) -> O(1) 


*/



/*

Test

Case 1:

s1 = ab s2 = hbat

s1count:
a - 1
b - 1

s2count:
h - 0
b - 1
a - 1

matches = 24 -> 25 -> 26 -> true

hba
ba

return true

Case 2:

s1 = ab s2 = dfl

s1count:
a - 1
b - 1

s2count:
d - 0
f - 1
l - 1

matches = 22 -> 21 -> 22 -> false

dfl
fl

return false

Case 3:
s1 = abc s2 = ab

return false

Case 4:
s1 = a s2 = b

s1count:
a - 1

s2count:
b - 1

matches = 24 -> false

return false








*/
