class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        List<Integer>[] freq = new ArrayList[nums.length + 1];

        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;

        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            for (int num : freq[i]) {
                res[index] = num;
                index++;
                if (index == k) return res;
            }
        }

        return res;

    }
}

/*
Test

Case 1:
[1, 1, 2] k = 1

map: 1 -> 2, 2 -> 1

freq[2] = 1
freq[1] = 2

for i = 3
for i = 2
for num in freq[2]
1
res[0] = 1
index -> 1
index == k == 1 return res [1]


Case 2:
[1, 2, 2, 3, 3, 3] k = 2

map: 1 -> 1, 2 -> 2, 3 -> 3
freq[1] = 1
freq[2] = 2
freq[3] = 3

for i = 6 
for i = 5
for i = 4
for i = 3
for num in freq[3]
3
res[0] = 3
index -> 1

for i = 2
for num in freq[2]
2
res[1] = 2
index -> 2
index == k == 2 -> return res -> [3, 2]

Case 3:
[7] k = 1

map: 7 -> 1
res[1] = 7

for i = 1
for num in freq[1]
7
res[0] = 7
index -> 1
index == k == 1 -> return res -> [7]

Case 3:
[1, 2] k = 1

map: 1->1, 2 -> 1

freq[1] = {1, 2}

for int i = 1
for num in freq
1
res[0] = 1
index -> 1
index == k == 1 -> return res -> return [1]

*/
