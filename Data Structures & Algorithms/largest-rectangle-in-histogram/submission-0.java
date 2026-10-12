class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            int start = i;
            int cur = heights[i];
            while (!stack.isEmpty() && stack.peek()[1] > cur) {
                int[] top = stack.pop();
                int index = top[0];
                int height = top[1];
                maxArea = Math.max(maxArea, height * (i - index));
                start = index;
            }
            stack.push(new int[]{start, cur});
        }

        while (!stack.isEmpty()) {
            maxArea = Math.max(maxArea, (heights.length - stack.peek()[0]) * stack.pop()[1]);
        }

        return maxArea;

    }
}
