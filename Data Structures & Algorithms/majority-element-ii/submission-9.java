class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        // O(n)
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

            if (map.size() <= 2) continue;

            Map<Integer, Integer> new_map = new HashMap<>(); 
            // O(3) -> O(1)
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > 1) {
                    new_map.put(entry.getKey(), entry.getValue() - 1);
                }
            }
            map = new_map;

        }

        List<Integer> res = new ArrayList<>();
        // O(2) -> O(1)
        for (int key : map.keySet()) {
            int counter = 0;
            // O(n)
            for (int num : nums) {
                if (key == num) counter++;
            }
            if (counter > (nums.length / 3)) res.add(key);
        }

        return res;

    }
}

// Time complexity: O(n)
// Space complexity: O(3) -> O(1). At peak map holds 3 elements

/*
Test

Case 1:
[1, 1, 1, 2, 2, 2, 3, 3, 3, 1] n = 10; more than 3 times

for 1
map: 1 -> 1
for 1
map: 1 -> 2
for 1
map: 1 -> 3
for 2
map: 1 -> 3, 2 -> 1
for 2
map: 1 -> 3, 2 -> 2
for 2
map: 1 -> 3, 2 -> 3

for 3
map: 1 -> 3, 2 -> 3, 3 -> 1
size > 2
map: 1 -> 2,  2 -> 2

for 3
map: 1 -> 2,  2 -> 2, 3 -> 1
size > 2
map: 1 -> 1,  2 -> 1

for 3
map: 1 -> 1,  2 -> 1, 3 -> 1
size > 2
map: 

for 1
map: 1 -> 1

verify: 
for 1
counter -> 4
4 > 3 -> res: {1}

return {1}



Case 2:

[1, 2, 3, 4, 1] n = 5; more than 1 time

for 1
map: 1 -> 1
for 2
map: 1 -> 1, 2 -> 1

for 3
map: 1 -> 1, 2 -> 1, 3 -> 1
size > 2
map: 

for 4
map: 4 -> 1
for 1
map: 4 -> 1, 1 -> 1

verify:
for 4
counter -> 1
if 1 > 1 false

for 1
counter -> 2
if 2 > 1 -> res: {1}

return {1}


Case 3:
[1, 2, 3, 4] n = 4 more than 1 time

for 1
map: 1->1

for 2
map: 1->1, 2->1

for 3
map: 1->1, 2->1,  3->1
size > 2
map: 

for 4
map: 4->1

verify:
for 4
counter -> 1
if 1 > 1 false

return {}

Case 4:
[1, 1, 1, 2, 2, 2, 3, 4] n = 8 more than 2 times

for 1
map: 1->1
for 1
map: 1->2
for 1
map: 1->3
for 2
map: 1->3, 2->1
for 2
map: 1->3, 2->2
for 2
map: 1->3, 2->3

for 3
map: 1->3, 2->3, 3->1
size > 2
map: 1->2, 2->2

for 4:
map: 1->2, 2->2, 4->1
size > 2
map: 1->1, 2->1

verify:
for 1
counter -> 3
if 3 > 2 -> res: {1}

for 2
counter -> 3
if 3 > 2 -> res: {1, 2}

return {1, 2}

Case 5:
[3] n = 1 more than 0 times

for 3
map: 3 -> 1

verify:
for 3
counter -> 1
1 > 0 -> res: {1}

return {1}







*/