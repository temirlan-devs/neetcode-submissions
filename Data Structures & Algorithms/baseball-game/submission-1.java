class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int total = 0;

        // O(n)
        for(int i = 0; i < operations.length; i++) {
            if (operations[i].equals("+")) {
                int temp = stack.pop();
                int sum = temp + stack.peek();
                stack.push(temp);
                stack.push(sum);
                total += sum;
            } else if (operations[i].equals("D")) {
                int toadd = 2 * stack.peek();
                stack.push(toadd);
                total += toadd;
            } else if (operations[i].equals("C")) {
                total -= stack.pop();
            } else {
                int num = Integer.parseInt(operations[i]);
                stack.push(num);
                total += num;
            }
        }

        return total;
    }
}

// Time complexity: O(n)
// Space complexity: O(n)

/*

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

