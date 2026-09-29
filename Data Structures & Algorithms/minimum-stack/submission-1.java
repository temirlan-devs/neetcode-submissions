class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minstack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minstack = new Stack<>();
    }
    
    public void push(int val) {
        int min = (this.stack.isEmpty()) ? val : Math.min(val, this.minstack.peek());
        this.stack.push(val);
        this.minstack.push(min);
    }
    
    public void pop() {
        this.stack.pop();
        this.minstack.pop();
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        return this.minstack.peek();
    }
}
