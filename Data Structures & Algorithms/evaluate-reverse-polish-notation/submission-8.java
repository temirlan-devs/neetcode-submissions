class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                int temp = stack.pop();
                stack.push(stack.pop() - temp);
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();

                System.out.println(temp1);
                System.out.println(temp2);
                stack.push(temp2 / temp1);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}

/*

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






*/

