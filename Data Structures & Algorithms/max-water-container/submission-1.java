class Solution {
    public int maxArea(int[] heights) {
        
        int l = 0;
        int r = heights.length - 1;

        int maxArea = 0;


        // O(n)
        while (l < r) {

            int width = r - l;
            int height = Math.min(heights[l], heights[r]);
            int area = height * width;
            maxArea = Math.max(maxArea, area);

            if (heights[l] < heights[r]) l++;
            else if (heights[l] > heights[r]) r--;
            else {
                l++;
                r--;
            }

        }

        return maxArea;

    }
}

// Time complexity: O(n). Space complexity: O(1)

/*

Test

Case 1:

[1, 2, 3]

l = 0 r = 2

while 0 < 2
width = 2
height = 1
area = 2
maxArea = 2
l -> 1

while 1 < 2
width = 1
height = 2
area = 2
maxarea = 2
l -> 2

return 2

Case 2:
[3, 2, 1]

l = 0
r = 2

while 0 < 2
width = 2
height = 1
area = 2
maxarea = 2
r -> 1

while 0 < 1
width = 1
height = 2
area = 2
maxarea = 2
r -> 0

return 2

Case 3:
[1, 4, 5, 3, 6]

l = 0 r = 4

while 0 < 4
width = 4
height = 1
area = 4
maxarea = 4
l -> 1

while 1 < 4
width = 3
height = 4
area = 12
maxarea = 12
l -> 2

while 2 < 4
width = 2
height = 5
area = 10
maxarea = 12
l -> 3

while 3 < 4
width = 1
height = 3
area = 3
maxarea = 12
l -> 4

return 12


Case 4:
[1, 2, 5, 7, 8, 5]


l = 0 r = 5

while 0 < 5
width = 5
height = 1
area = 5
maxarea = 5
l -> 1

while 1 < 5
width = 4
height = 2
area = 8
maxarea = 8
l -> 2

while 2 < 5
width = 3
height = 5
area = 15
maxarea = 15
l -> 3
r -> 4

while 3 < 4
width = 1
height = 7
area = 7
maxarea = 15
l -> 4

return 15

Case 5:
[1, 2, 5, 20, 21, 5]

l = 0 r= 5


while 0 < 5
width = 5
height = 1
area = 5
maxarea = 5
l -> 1

while 1 < 5
width = 4
height = 2
area = 8
maxarea = 8
l -> 2

while 2 < 5
width = 3
height = 5
area = 15
maxarea = 15
l -> 3
r -> 4

while 3 < 4
width = 1
height = 20
area = 20
maxarea = 20
l -> 4

return 20

Case 6:

[1, 2]

l = 0 r = 1

while 0 < 1
width = 1
height = 1
area = 1
maxarea = 1
l -> 1

return 1

Case 7:
[0, 1]

l = 0 r = 1

while 0 < 1
width = 1
height = 0
area = 0
maxarea = 0
l -> 1

return 0

Case 8:
[0, 0]

l = 0 r = 1

while 0 < 1
width = 1
height = 0
area = 0
maxarea = 0
l -> 1 r -> 0

return 0










*/
