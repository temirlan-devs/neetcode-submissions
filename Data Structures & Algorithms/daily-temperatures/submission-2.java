class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> stack = new Stack<>();

        int[] result = new int[temperatures.length];

        // O(n)
        for (int i = 0; i < temperatures.length; i++) {
            int cur = temperatures[i];
            while (!stack.isEmpty() && cur > temperatures[stack.peek()]) { // You can only pop n elements, so in total while loop is O(n).
                result[stack.peek()] = i - stack.pop(); 
            }
            stack.push(i);
        }

        return result;

    }
}


// Time complexity: O(n)
// Space complexity: O(n). In worst case, there are is no warmer temperature for after any day

/*

Test

Case 1:
[1, 2, 3, 4, 5]

for i = 0
cur = 1
s -> 0

for i = 1
cur = 2
while
2 > 1
res[0] = 1 - 0 = 1
s -> 
s -> 1

for i = 2
cur = 3
while
3 > 2
res[1] = 2 - 1 = 1
s -> 
s -> 2

for i = 3
cur = 4
while
4 > 3
res[2] = 3 - 2 = 1
s -> 
s -> 3

for i = 4
cur = 5
while
5 > 4
res[3] = 4 - 3 = 1
s -> 
s -> 4

res = [1, 1, 1, 1, 0]
return res;


Case 2:
[3, 2, 1]

for i = 0
cur = 3
s -> 0

for i = 1
cur = 2
while
2 > 3 false
s -> 0, 1

i = 2
cur = 1
while
1 > 2 false
s -> 0, 1, 2

return res -> [0, 0, 0]


Case 3:
[10, 9, 8, 11, 15, 12, 11, 10, 20]

for i = 0
cur = 10
s -> 0

for i = 1
cur = 9
while
9 > 10 false
s -> 0, 1

for i = 2
cur = 8
while
8 > 9 false
s -> 0, 1, 2

for i = 3
cur = 11
while
11 > 8
res[2] = 3 - 2 = 1
s -> 0, 1
while
11 > 9
res[1] = 3 - 1 = 2
s -> 0
while
11 > 10
res[0] = 3 - 0 = 3
s ->
s -> 3

for i = 4
cur = 15
while 15 > 11
res[3] = 4 - 3 = 1
s ->
s -> 4

[10, 9, 8, 11, 15, 12, 11, 10, 20]

for i = 5
cur = 12
while
12 > 15 false
s -> 4, 5

for i = 6
cur = 11
while 11 > 12 false
s -> 4, 5, 6

for i = 7
cur = 10
while 
10 -> 11 false
s -> 4, 5, 6, 7

for i = 8
cur = 20
while
20 > 10
res[7] = 8 - 7 = 1
s -> 4, 5, 6
while
20 >  11
res[6] = 8 - 6 = 2
s -> 4, 5
while
20 > 12
res[5] = 8 - 5 = 3
s -> 4
while
20 > 15
res[4] = 8 - 4 = 4
s ->
s -> 8

return res -> [3, 2, 1, 1, 4, 3, 2, 1, 0]

Case 4:
[1]

for i = 0
cur = 1
s -> 0

return result -> [0]





*/