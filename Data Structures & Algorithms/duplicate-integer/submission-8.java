class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }

        return false;
    }
}

/* 
Time, space complexity: O(n)

Test

Case 1:
[1, 2, 3, 3]

set -> 1
set -> 1, 2
set -> 1, 2, 3
return true

Case 2:
[1, 2, 3]
set -> 1
set -> 1, 2
set -> 1, 2, 3
return false

Case 3:
[]
return false



*/