class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxLength = 0;

        // O(n)
        for (int num : nums) set.add(num);

        // O(n)
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int length = 1;
                // while loop visits each number once in total
                while (set.contains(num + length)) length++;
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
}

// Time complexity: O(n)
// Space complexity: O(n)

/*

Case 1:
[3, 2, 9, 1, 4, 5]

set: 3, 2, 9, 1, 4, 5

for 3
for 2
for 1
 length = 1
 while -> length = 5 
 maxlength = 5
for 4
for 5

return 5


Case 2:
[1, 3, 5]

set:  {1, 3, 5}

for 1
 length = 1
 maxLength = 1
for 3
 length = 1
 maxLength = 1
for 5
 length = 1
 maxlength = 1

return 1

Case 3:
[]
return 0



*/
