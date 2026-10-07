class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        // O(n)
        for (int a : asteroids) {

            // collision: -><-  +-
            while (!stack.isEmpty() && a < 0 && stack.peek() > 0) { // while loop runs n in total
                int diff = a + stack.peek();

                if (diff < 0) stack.pop();
                else if (diff > 0) a = 0;
                else {
                    stack.pop();
                    a = 0;
                }
            }

            if (a != 0) stack.push(a);

        }

        return stack.stream().mapToInt(i->i).toArray(); // Time complexity: O(n). Space complexity: O(n) for new array
    }
}

// Time compleixty: O(n)
// Overall Space complexity: O(n) + O(n) = O(n)  (stack + new array)
// Auxiliary Space complexity: O(n) (just stack)


/*

Test

Case 1:

[1, 2, 3, 4, 5]


for 1
s -> 1

for 2 
s -> 1, 2
for 3
s -> 1, 2, 3
for 4
s -> 1, 2, 3, 4
for 5
s -> 1, 2, 3, 4, 5

return [1, 2, 3, 4, 5]



Case 2:
[1, -1, 2, -2, 3, -3]

for 1
s -> 1

for -1
while
diff = 0
s ->
a = 0

for 2
s -> 2

for -2
while
diff = 0
s -> 
a = 0

for 3
s -> 3

for - 3
while 
diff = 0
s ->
a = 0

return new int[0]




Case 3:
[5, 6, -1, -3, 7, -7, -4, -2, -6, -8, -10, -7]

for 5
s -> 5
for 6
s -> 5, 6

for -1
while
diff = -1 + 6 = 5
a = 0

for -3
while
diff = -3 + 6 = 3
a = 0

for 7
s -> 5, 6, 7

for -7
while
diff = 0
s -> 5, 6
a = 0

for -4
while
diff = -4 + 6 = 2
a = 0

for -2
while
diff = -2 + 6 = 4
a = 0

for -6
while
diff = 0
s -> 5
a = 0

for -8
while
diff = -3
s ->
a != 0 -> s -> -8

for -10
s -> -8, -10

for -8
s -> -8, -10, -7

return [-8, -10, -7]


Case 4:
[10, 2, -5]

for 10
s -> 10

for 2
s -> 10, 2

for -5
while
diff = -5 + 2 = -3
s -> 10

while
diff = 5
a = 0


return [10]




*/