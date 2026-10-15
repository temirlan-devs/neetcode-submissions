class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 0, r = 0;

        // O(n). The outer + inner while loops do n works in total, nothing get rescanned, they work with the same r
        while (r < nums.length) {
            int count = 1;

            while (r + 1 < nums.length && nums[r] == nums[r + 1]) {
                r++;
                count++;
            }

            // O(2)
            for (int i = 0; i < Math.min(2, count); i++) {
                nums[l] = nums[r];
                l++;
            }
            r++;
        }

        return l;

    }
}

// Time complexity: O(n). Space complexity: O(1)

/*

Test

Case 1:
[1, 2, 3]

l = 0 r = 0
while 0 < 3
count = 1
while 
for 0 < 1
nums[0] = nums[0]
l -> 1
r -> 1

while 1 < 3
count = 1
while
for 0 < 1
nums[1] = nums[1]
l -> 2
r -> 2

while 2 < 3
count = 1
for i = 0 < 1
nums[2] = nums[2]
l -> 3
r -> 3

return 3


Case 2:
[1, 1, 1, 2, 2]

l = 0 r = 0

while 0 < 5
count = 1
while 1 == 1
r -> 1
count -> 2
while 1 == 1
r -> 2
count -> 3
while 1 != 2
for i = 0 < 2
nums[0] = nums[2]
l -> 1
for i = 1 < 2
nums[1] = nums[2]
l -> 2
r -> 3

while 3 < 5
count = 1
while 2 == 2
r -> 4
count -> 2
for i = 0 < 2
nums[2] = nums[4] = 2
l -> 3
for i = 1 < 2
nums[3] = nums[4] = 2
l -> 4
[1, 1, 2, 2, 2]

return 4 


Case 3:
[1, 1, 1, 2, 2, 2]

l = 0 r = 0

while 0 < 6
count = 1
while 1 == 1
r -> 1 count -> 2
while 1 == 1 
r -> 2 count -> 3
while 1 != 2
for i = 0 < 2
nums[0] = nums[2] = 1
l -> 1
for i = 1 < 2
nums[1] = nums[2] = 1
l -> 2
r -> 3

while 3 < 6
count = 1
while 2 == 2
r -> 4 count -> 2
while 2 == 2
r -> 5 count -> 3
for i = 0 < 2
nums[2] = nums[5] = 2
l -> 3
for i = 1 < 2
nums[3] = nums[5] = 2
[1, 1, 2, 2, 2, 2]
l -> 4
r -> 6

return 4



Case 4:
[1, 1, 1, 2, 2, 2, 3]

l = 0 r = 7

while 0 < 7
count = 1
while 1 == 1
r -> 1 count -> 2
while 1 == 1
r -> 2 count -> 3
while 1 != 2
for i = 0 < 2
nums[0] = nums[2] = 1
l -> 1
for i = 1 < 2
nums[1] = nums[2] = 1
l -> 2
r -> 3

while 3 < 7
count = 1
while 2 == 2
r -> 4 count -> 2
while 2 == 2
r -> 5 count -> 3
while 2 != 3
for i = 0 < 2
nums[2] = nums[5] = 2
l -> 3
for i = 1 < 2
nums[3] = nums[5] = 2
l -> 4
[1, 1, 2, 2, 2, 2, 3]
r -> 6

while 6 < 7
count = 1
while 7 < 7
for i = 0 < 1
nums[4] = nums[7] = 3
l -> 5
[1, 1, 2, 2, 3, 2, 3]


return 5

Case 5:
[1, 1, 2, 2]

l = 0 r = 0

while 0 < 4
count = 1
while 1 == 1
r -> 1 count -> 2
while 1 != 2
for i = 0 < 2
nums[0] = nums[1] = 1
l -> 1
for i = 1 < 2
nums[1] = nums[1] = 1
l -> 2
r -> 2

while 2 < 4
count = 1
while 2 == 2
r -> 3 count -> 2
while 4 < 4
for i = 0 < 2
nums[2] = nums[3] = 2
l -> 3
for i = 1 < 2
nums[3] = nums[3] = 2
l -> 4

return 4

Case 6:
[1, 2]

l = 0 r = 2

while 0 < 2
count = 1
while 1 != 2
for i = 0 < 1
nums[0] = nums[1] = 1
l -> 1
r -> 1

while 1 < 2
count = 1
while 2 < 2
for i = 0 < 1
nums[1] = nums[1] = 2
l -> 2
r -> 3

return 2

Case 8:
[1]

l = 0 r = 0
while 0 < 1
count = 1
while 1 < 1
for i = 0 < 1
nums[0] = nums[1] = 1
l -> 1
r -> 1

return 1

Case 9:
[0, 0, 1, 1, 1, 1, 2, 3, 3]

l = 0 r = 0

while 0 < 9
count = 1
while 0 == 0
r -> 1 count -> 2
while 0 != 1
for i = 0 < 2
nums[0] = nums[1] = 0
l -> 1
for i = 1 < 2
nums[1] = nums[1] = 0
l -> 2
r -> 2

while 2 < 9
count = 1
while 1 == 1
r -> 3 count -> 2
while 1 == 1
r -> 4 count -> 3
while 1 == 1
r -> 5 count -> 4
while 1 != 2
for i = 0 < 2
nums[2] = nums[5] = 1
l -> 3
for i = 1 < 2
nums[3] = nums[5] = 1
l -> 4
r -> 6

while 6 < 9
count = 1
while 2 != 3
for i = 0 < 1
nums[4] = nums[6] = 2
[0, 0, 1, 1, 2, 1, 2, 3, 3]
l -> 5
r -> 7

while 7 < 9
count = 1
while 3 == 3
r -> 8 count -> 2
while 9 < 9
for i = 0 < 2
nums[5] = nums[8] = 3
l -> 6
for i = 1 < 2
nums[6] = nums[8] = 3
l -> 7
[0, 0, 1, 1, 2, 3, 3, 3, 3]

return 7







*/