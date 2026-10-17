class Solution {
    public int largestRectangleArea(int[] heights) {
        
        Stack<int[]> stack = new Stack<>();
        int maxarea = 0;

        for (int i = 0; i < heights.length; i++) {
            int cur = heights[i];
            int start = i;
            while (!stack.isEmpty() && cur < stack.peek()[1]) {
                int[] top = stack.pop();
                int area = (i - top[0]) * top[1];
                maxarea = Math.max(maxarea, area);
                start = top[0];
            }
            stack.push(new int[]{start, cur});
        }

        while(!stack.isEmpty()) {
            maxarea = Math.max(maxarea, (heights.length - stack.peek()[0]) * stack.pop()[1]);
        }

        return maxarea;

    }
}
