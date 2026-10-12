class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stack = new Stack<>();

        // O(n) where n is the number of numbers in heights array
        for (int i = 0; i < heights.length; i++) {
            int start = i;
            int cur = heights[i];

            // In total O(n). We only push a certain number once and pop once, so you can only pop up to n numbers
            while (!stack.isEmpty() && stack.peek()[1] > cur) {
                int[] top = stack.pop();
                int index = top[0];
                int height = top[1];
                maxArea = Math.max(maxArea, (i - index) * height);
                start = index;
            }

            stack.push(new int[]{start, cur});
        }

        // O(n). Cause stack can hold up to n numbers if it is an increasing histogram
        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            maxArea = Math.max(maxArea, (heights.length - top[0]) * top[1]);
        }

        return maxArea;
    }
}

// Time complexity: O(n)
// Space complexity: O(n)


/*

Test

Case 1:
[1, 2, 3]

for i = 0
start = 0
cur = 1
s -> [0, 1]

for i = 1
start = 1
cur = 2
s -> [0, 1]; [1, 2]

for i = 2
start = 2
cur = 3
s -> [0, 1]; [1, 2]; [2, 3]


while stack
top = [2, 3]  s -> [0, 1]; [1, 2]
maxArea = 3

while stack 
top = [1, 2] s -> [0, 1]
maxArea = 4

while stack
top = [0, 1] s ->
maxArea = 4

return 4



Case 2:
[3, 2, 1]


for i = 0
start = 0
cur = 3
s -> [0, 3]

for i = 1
start = 1
cur = 2
while 3 > 2
top = [0, 3]  s ->
index = 0 height = 3
maxArea = 3
start = 0
s -> [0, 2]

for i = 2
start = 2
cur = 1
while 2 > 1
top = [0, 2] s ->
index = 0 height = 2
maxArea = 4
start = 0
s -> [0, 1]

while stack
top = [0, 1]  s ->
maxArea = 4

return 4


Case 3:
[3, 2, 4, 5, 1, 6]

for i = 0
start = 0
cur = 3
s -> [0, 3]

for i = 1
start = 1
cur = 2
while 3 > 2
top = [0, 3] s ->
index = 0 height = 3
maxArea = 3
start = 0
s -> [0, 2]

for i = 2
start = 2
cur = 4
s -> [0, 2]; [2, 4]

for i = 3
start = 3
cur = 5
s -> [0, 2]; [2, 4], [3, 5]

for i = 4
start = 4
cur = 1
while 5 > 1
top = [3, 5]  s -> [0, 2]; [2, 4]
index = 3 height = 5
maxArea = 5
start = 3
while 4 > 1
top = [2, 4]  s -> [0, 2]
index = 2 height = 4
maxArea = 8
start = 2
while 2 > 1
top = [0, 2]  s ->
index = 0 height = 2
maxArea = 8
start = 0
s -> [0, 1]

for i = 5
start = 5
cur = 6
s -> [0, 1]; [5, 6]

while stack
top = [5, 6]  s -> [0, 1]
maxArea = 8
while stack
top = [0, 1]  s ->
maxArea = 8

return 8

Case 4:
[1]

for i = 0
start = 0
cur = 1
s -> [0, 1]

while stack
top = [0, 1] s ->
maxArea = 1

return 1

Case 5:
[0]

for i = 0
start = 0
cur = 0
s -> [0, 0]

while stack
top = [0, 0] s ->
maxArea = 0

return 0

Case 6:
[0, 1]

for i = 0
start = 0
cur = 0
s -> [0, 0]

for i = 1
start = 1
cur = 1
s -> [0, 0], [1, 1]

while stack
top = [1, 1]  s -> [0, 0]
maxArea = 1

while stack
top = [0, 0]  s ->
maxArea = 1
return 1

Case 7:
[1, 0]

for i = 0
start = 0
cur = 1
s -> [0, 1]

for i = 1
start = 1
while 1 > 0
top = [0, 1] s ->
index = 0 height = 1
maxArea = 1
start = 0
s -> [0, 0]

while stack
top = [0, 0] s ->
maxArea = 1

return 1




*/
