class StockSpanner {

    Stack<int[]> stack;
    int i;

    public StockSpanner() {
        this.i = 0;
        this.stack = new Stack<>();
    }
    
    public int next(int price) {
        int temp = i;
        while (!stack.isEmpty() && price >= stack.peek()[1]) {
            stack.pop();
        }

        int result = (stack.isEmpty()) ? (i - (-1)) : (i - stack.peek()[0]);
        stack.push(new int[]{i, price});
        i++;
        return result;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */