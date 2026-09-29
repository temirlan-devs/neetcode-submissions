class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minstack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minstack = new Stack<>();
    }
    
    public void push(int val) {
        this.stack.push(val);
        if (this.minstack.isEmpty() || val <= this.minstack.peek())
            this.minstack.push(val);
    }
    
    public void pop() {
        int top = this.stack.pop();
        if (top == this.minstack.peek())
            this.minstack.pop();
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        return this.minstack.peek();
    }
}
