class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            }else if (token.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}


/*

Test

Case 1:
[1, 2, +, 3, 4, -, 5, *, 6, /, *]

for 1
s -> 1

for 2
s ->  1, 2

for +
s -> 3

for 3
s -> 3, 3

for 4, 
s -> 3, 3, 4

for -
s -> 3, -1

for 5
s -> 3, -1, 5

for *
s -> 3, -5

for 6
s -> 3, -5, 6

for /
s -> 3, 0

for *
s -> 0


Case 2:
[1, 2, 3, + -, 4, 5, 6, *, /, +]

for 1
s -> 1

for 2
s -> 1, 2

for 3
s ->  1, 2, 3

for +
s -> 1, 5

for - 
s -> -4

for 4
s -> -4, 4

for 5
s -> -4, 4, 5

for 6
s -> -4, 4, 5, 6

for *
s -> -4, 4, 30

for /
s -> -4, 0

for +
s -> -4

Case 3:
[0, 3, /]

for 0
s -> 0

for 3
s -> 0, 3

for /
s -> 0 (0 / 3)

*/

