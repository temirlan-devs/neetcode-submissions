class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); 
        Arrays.sort(nums); // Time - O(nlogn). Space O(logn) - because it is sorting primitives

        // O(n)
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1;
            int r = nums.length - 1;

            // O(n^2) in total because each iteration it checks 1 less element -> sum of 1 to n -> O(n^2)
            // the O(n^2) is in total though not each iteration
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];

                if (sum > 0) r--;
                else if (sum < 0) l++;
                else {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++; r--;
                    while (l < r && nums[l] == nums[l - 1]) l++;
                }
            }

        }

        return result;

    }
}

/*
Time complexity: O(nlogn) + O(n) + O(n ^ 2) -> O(n^2)
Space complexity: O(n^2)
Auxiliary space complexity (without output list): O(logn) - sorting the array

result list: For every for loop iteration, there is a while, which at every iteartion can find at most 1 triplet. While runs for up to O(n) times, for loop runs for up to O(n) times, so space is O(n^2)
 
*/



/*

Test

Case 1:
[-1, 1, 0]
sort -> [-1, 0, 1]

for i = 0 < 2
-1
l = 1
r = 2
while 1 < 2
sum = 0
res -> {{-1, 0, 1}}
l -> 2 r -> 1

return res -> {{-1, 0, 1}}

Case 2:
[-1, 1, 1]
sort -> [-1, 1, 1]

for i = 0 < 2
-1
l = 1 r = 2
while 1 < 2
sum = 1 > 0 -> r = 1

return res -> empty

Case 3:
[-5, 1, 2, 3, 0, 5, -5, 0, 5]

sort -> [-5, -5, 0, 0, 1, 2, 3, 5, 5]

for i = 0 < 9
-5
l = 1 r = 8
while 1 < 8
sum = -5 < 0 -> l = 2
while 2 < 8
sum = 0
res -> {{-5, 0, 5}} l -> 3 r -> 7
while for repeated l -> 4

while 4 < 7
sum = 1 > 0 -> r -> 6
while 4 < 6
sum = -1 < 0 -> l -> 5
while 5 < 6
sum = 0
res -> {{-5, 0, 5}, {-5, 2, 3}} l -> 6 r -> 5

for i = 1 < 9
-5
-5 == -5 continue

for i = 2 < 9
0
l = 3 r = 8
while 3 < 8
sum = 5 > 0 -> r -> 7
while 3 < 7
sum = 5 > 0 -> r -> 6
while 3 < 6
sum = 3 > 0 -> r -> 5
whule 3 < 5
sum = 2 > 0 -> r -> 4
while 3 < 4
sum = 1 > 0 -> r -> 3

for i = 3 < 9
0
0 == 0 continue

for i = 4 < 9
1 > 0 break

return res -> {{-5, 0, 5}, {-5, 2, 3}}




*/