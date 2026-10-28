class Solution {
    public int largestRectangleArea(int[] heights) {
        
        Stack<int[]> stack = new Stack<>();
        int res = 0;

        for (int i = 0; i < heights.length; i++) {
            int start = i;
            int cur = heights[i];
            while (!stack.isEmpty() && stack.peek()[1] > cur) {
                int[] top = stack.pop();
                start = top[0];
                int h = top[1];
                int w = i - start;
                int area = h * w;
                res = Math.max(res, area);
            }

            stack.push(new int[]{start, cur});
        }

        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            int h = top[1];
            int w = heights.length - top[0];
            int area = h * w;
            res = Math.max(res, area);
        }

        return res;

    }
}
