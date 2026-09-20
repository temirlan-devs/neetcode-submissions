class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int total = 0;
        int counter = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            total += num;

            int diff = total - k;
            if (map.containsKey(diff)) counter += map.get(diff);

            map.put(total, map.getOrDefault(total, 0) + 1);
        }

        return counter;
    }
}

/*

Test 

Case 1:

[1, 2, 3] k = 3

map -> 0: 1

num = 1; total = 1; diff = -2
if map contains -2
map -> 0: 1, 1: 1

num = 2; total = 3; diff = 0
if map contains 0 -> counter = 1
map -> 0: 1, 1: 1, 3: 1

num = 3; total = 6; diff = 3
if map contains 3-> counter = 2

return 2


Case 2:
[2, 2] k = 2

map -> 0: 1

num = 2; total = 2; diff = 0
if map contains 0 -> counter = 1
map -> 0: 1, 2: 1

num = 2; total = 4; diff = 2
if map contains 2 -> counter = 2

return 2

Case 3:
[1, 2] k = 4

map -> 0: 1

num = 1; total = 1; diff = -3
if map contains -1
map -> 0: 1, 1: 1

num = 2; total = 3; diff = -1
if map contains -1

return 0

*/