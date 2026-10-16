class Solution {
    public int maxArea(int[] heights) {
        
        int l = 0, r = heights.length - 1;
        int maxarea = 0;

        while (l < r) {
            int width = r - l;
            int height = Math.min(heights[l], heights[r]);
            int area = width * height;
            maxarea = Math.max(maxarea, area);

            if (heights[l] < heights[r]) l++;
            else r--;
        }

        return maxarea;

    }
}
