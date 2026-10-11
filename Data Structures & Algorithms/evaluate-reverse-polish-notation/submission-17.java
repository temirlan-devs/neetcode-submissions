class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        // O(n) where n is the number of tokens
        // for loop below runs n times
        for (String token : tokens) {
            // O(1), cause we are comparing to a single char
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            }
            
            // O(1), cause we are comparing to a single char
            else if (token.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } 
            
            // O(1), cause we are comparing to a single char
            else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } 
            
            // O(1), cause we are comparing to a single char
            else if (token.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } 
            

            else {
                // Integer.parseInt() is O(k) where k is the number of digits
                // However as this problem states, the integers are in range
                // of [-200, 200], so 3 digits max -> O(3) -> O(1)
                // And even if the range is just bounded by max value in int
                // then the max is 10 digits (O(10)) which is O(1) anyway
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}


// Time complexity: O(n)
// Space complexity: O(n). Space is the stack. Operands equals to about n/2 of the tokens, and in the worst case (all numbers pushed before operators consume them, e.g. 1 1 1 1 + + +) the stack holds ~n/2 at once -> O(n)


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

