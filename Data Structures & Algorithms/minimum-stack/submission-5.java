class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minstack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minstack = new Stack<>();
    }
    
    public void push(int val) {
        this.stack.push(val);
        if (this.minstack.isEmpty() || val <= this.minstack.peek()) {
            this.minstack.push(val);
        }
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

// All operatios are O(1)
// Time complexity: O(1)
// Space complexity: O(n) to store numbers in stacks

/*

Test:


push 1
stack -> 1
minstack -> 1

push 2
stack -> 1, 2
minstack -> 1

push 3
stack -> 1, 2, 3
minstack -> 1

getmin
return 1

pop
stack -> 1, 2
minstack -> 1

pop
stack -> 1
minstack -> 1

pop
stack -> 
minstack ->

push 3
stack -> 3
minstack -> 3

push 2
stack -> 3, 2
minstack-> 3, 2

push 1
stack -> 3, 2, 1
minstack-> 3, 2, 1

getmin
return 1

pop 
stack -> 3, 2
minstack -> 3, 2

getmin
return 2

peek
return 2

pop
stack -> 3
minstack -> 3

getmin
return 3

peek
return 3

pop
stack -> 
minstack -> 


push -2
stack -> -2
minstack -> -2

push 0
stack -> -2, 0
minstack -> -2

push 3
stack -> -2, 0, 3
minstack -> -2

getmin
return -2

pop
stack -> -2, 0
minstack -> -2

peek
return 0

getmin
return -2

push -2
stack -> -2, 0, -2
minstack -> -2, -2

getmin
return -2

pop
stack -> -2, 0
minstack -> -2


*/
