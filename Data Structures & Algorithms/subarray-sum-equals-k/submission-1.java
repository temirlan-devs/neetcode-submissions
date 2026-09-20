class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int total = 0;
        int counter = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            total += num;

            if (map.containsKey(total - k)) counter += map.get(total - k);

            map.put(total, map.getOrDefault(total, 0) + 1);
        }

        return counter;

    }
}

/*

Test

Case 1:
[2, -1, 1, 2] k = 2

num = 2; total = 2
map -> 2: 1
if map has 0 -> counter = 1

num = -1; total = 1
map -> 2: 1, 1: 1
if map has -1 

num = 1; total = 2
map -> 2: 1, 1: 1
if map has 0 -> counter = 2

num = 2; total = 4
map: 2: 1, 1: 1
if map has 2 -> counter = 4


Case 2:
[2, 2, 2] k = 2

num = 2; total = 2
map: 2: 1
if map has 0 -> counter = 1

num = 2; total = 4
map: 2:1, 4: 1
if map has 2 -> counter = 2

num = 2; total = 6
map: 2:1, 4:1, 6: 1
if map has 4 -> counter = 3

Case 3
[2] k = 2

num = 2 total = 2
map: 2: 1
if map has 0 -> counter = 1

Case 4:
[1, 2] k =4

counter = 0




*/