class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        int n = position.length;
        Stack<Double> stack = new Stack<>();
        int[][] pair = new int[n][2];

        for (int i = 0; i < n; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));

        for (int p[] : pair) {
            int pos = p[0];
            int sp = p[1];
            double remainingDistance = target - p[0];
            double remainingTime = remainingDistance / sp;

            if (stack.isEmpty() || remainingTime > stack.peek()) stack.push(remainingTime);
        }

        return stack.size();
        

    }
}
