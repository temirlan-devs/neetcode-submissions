class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        Stack<Integer> stack = new Stack<>();

        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int cur = temperatures[i];

            while (!stack.isEmpty() && cur > temperatures[stack.peek()]) {
                result[stack.peek()] = i - stack.pop();
            }

            stack.push(i);
        }

        return result;

    }
}
