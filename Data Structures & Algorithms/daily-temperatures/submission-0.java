class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> stack = new Stack<>();

        int[] result = new int[temperatures.length];

        // O(n)
        for (int i = 0; i < temperatures.length; i++) {
            int cur = temperatures[i];
            while (!stack.isEmpty() && cur > temperatures[stack.peek()]) { // You can only pop n elements, so in total while loop is O(n)
                result[stack.peek()] = i - stack.pop(); 
            }
            stack.push(i);
        }

        return result;

    }
}


// Time complexity: O(n)
// Space complexity: O(n)