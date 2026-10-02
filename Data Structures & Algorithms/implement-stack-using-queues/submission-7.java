class MyStack {

    Queue<Integer> queue;

    public MyStack() {
        this.queue = new LinkedList<>();
    }
    
    public void push(int x) {
        int n = queue.size();
        queue.offer(x);

        for (int i = 0; i < n; i++) {
            queue.offer(queue.poll());
        }
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

 // Time complexity: O(n) - push. O(1) - rest operations
 // Space complexity: O(n)

 /*

Test

push(1)
n = 0
q -> 1

push(2)
n = 1
q -> 1, 2

for i = 0 < 1
q -> 2, 1

push(3)
n = 2
q -> 2, 1, 3

for i = 0 < 2
q -> 1, 3, 2

for i = 1 < 2
q -> 3, 2, 1

pop()
q -> 2, 1
return 3

peek()
return 2

empty()
return false

poll()
q -> 1
return 2

poll()
q -> 
return 1

empty()
true

*/