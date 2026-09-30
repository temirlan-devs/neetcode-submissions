class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int total = 0;

        for (String operation : operations) {
            if (operation.equals("+")) {
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
                total += newTop;
            }
            else if (operation.equals("D")) {
                stack.push(2 * stack.peek());
                total += stack.peek();
            } 
            else if (operation.equals("C")) {
                total -= stack.pop();
            } 
            else {
                stack.push(Integer.parseInt(operation));
                total += stack.peek();
            }
        }

        return total;
    }
}

// Time complexity: O(n)
// Space complexity: O(n)

/*


Test 

Case 1:
[1, 2, +, 3, 4, 5, 6, D, 7, 8, C]

for

1
stack: 1

2
stack: 1, 2

+
temp = 2
sum = 2 + 1 = 3
stack: 1, 2
stack: 1, 2, 3

3
stack: 1, 2, 3, 3

4
stack: 1, 2, 3, 3, 4

5
stack: 1, 2, 3, 3, 4, 5

6
stack: 1, 2, 3, 3, 4, 5, 6

D
stack: 1, 2, 3, 3, 4, 5, 6, 12

7
stack: 1, 2, 3, 3, 4, 5, 6, 12, 7

8
stack: 1, 2, 3, 3, 4, 5, 6, 12, 7, 8

C
stack: 1, 2, 3, 3, 4, 5, 6, 12, 7

while -> 7 + 12 + 6 + 5 + 4 + 3 + 3 + 2 + 1 = 43
return 43


Case 2:
[1]

for

1
stack: 1

while -> 1
return 1

Case 3:
[1, C]

for

1
stack: 1

C
stack:

total = 0
return 0


*/