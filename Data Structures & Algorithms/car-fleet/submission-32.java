class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        int[][] pair = new int[n][2]; // O(2 * n) -> O(n) - space 

        // O(n) - time
        for (int i = 0; i < n; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }   

        // O(nlogn) - time. O(n) - space
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));
        
        Stack<Double> stack = new Stack<>(); // O(n) - space. Worst case: no cars catchup with each other

        // O(n) - time
        for (int[] p : pair) {
            stack.push((double) (target - p[0]) / p[1]);
            if (stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)) stack.pop();
        }
        return stack.size();
    }
}

// Time complexity: O(nlogn)
// Space complexity: O(n)


/*

Test

Case 1:
position [1, 2, 3]
speed	 [1, 2, 3]
target = 10

pair: [[1, 1], [2, 2], [3, 3]]

sort -> [[3, 3], [2, 2], [1, 1]]

for [3, 3]
s -> 2.3

for [2, 2]
s -> 2.3, 4

for [1, 1]
s -> 2.3, 4, 9

return 3

Case 2:

position [1, 2, 4]
speed    [5, 4, 3]
target = 10

pair after sorting: [[4, 3], [2, 4], [1, 5]]

for [4, 3]
s -> 2

for [2, 4]
s -> 2, 2
if 2 <= 2
s -> 2

for [1, 5]
s -> 2, 1.8
if 1.8 <= 2
s -> 2

return 1

Case 3:
position [2, 4, 9]
speed [4, 3, 1]
target = 10

pair after sorting: [[9, 1], [4, 3], [2, 4]]

for [9, 1]
s -> 1

for [4, 3]
s -> 1, 2

for [2, 4]
s -> 1, 2, 2
if 2 <= 2
s -> 1, 2

return 2


*/
