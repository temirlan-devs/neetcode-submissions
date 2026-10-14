class Solution {
    public int largestRectangleArea(int[] heights) {
        
        Stack<int[]> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int start = i;

            while (!stack.isEmpty() && heights[i] < stack.peek()[1]) {
                int[] top = stack.pop();
                int area = (i - top[0]) * top[1];
                maxArea = Math.max(maxArea, area);
                start = top[0];
            }
            

            stack.push(new int[]{start, heights[i]});

        }

        while (!stack.isEmpty()) {
            maxArea = Math.max(maxArea, (heights.length - stack.peek()[0]) * stack.pop()[1]);
        }

        return maxArea;

    }
}
