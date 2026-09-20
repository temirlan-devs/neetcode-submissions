class Solution {
    public int majorityElement(int[] nums) {
        
        
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > (nums.length / 2)) return num;
        }

        return -1;

    }


}


/*

Test

Case 1:
[1, 1, 2, 3, 1] n = 4

1
map: 1 -> 1

1 
map: 1 -> 2

2
map: 1 -> 2, 2 -> 1

3
map: 1 -> 2, 2 -> 1, 3 -> 1

1
map: 1 -> 3, 2 -> 1, 3 -> 1
if 3 > 2 -> return 1

Case 2:
[2, 2]

2
map: 2 -> 1

2
map: 2 -> 2
if 2 > 1 return 2



*/