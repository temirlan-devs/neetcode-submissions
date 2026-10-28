class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minstack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minstack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minstack.isEmpty() || val <= minstack.peek()) minstack.push(val);
    }
    
    public void pop() {
        if (stack.pop().equals(minstack.peek())) minstack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {   
        return minstack.peek();
    }
}
