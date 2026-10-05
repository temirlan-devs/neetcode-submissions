class MyQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }
        return s2.pop();
    }
    
    public int peek() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }
        return s2.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

 /*

Time complexity: 
O(1) - push
amortized O(1) - peek/pop

a single pop/peek can be O(n) once it triggers transfer element from s1 to s2. However, that cost is pre-paid by the pushes that were done earlier. pop/peek causes O(n) only if s2 is empty. If it is not, pop/peek is O(1)

Test

push(1)
s1 -> 1

push(2)
s1 -> 1, 2

push(3)
s1 -> 1, 2, 3

pop()
s2 -> 3, 2, 1
s2 -> 3, 2
return 1

pop()
s2 -> 3
return 2

pop()
s2 ->
return 3

push(4)
s1 -> 4

pop()
s2 -> 4
s2 ->
return 4

push(5)
s1 -> 5

push(6)
s1 -> 5, 6

push(7)
s1 -> 5, 6, 7

pop()
s2 -> 7, 6, 5
s2 -> 7, 6
return 5

push(8)
s1 -> 8
s2 -> 7, 6

push(9)
s1 -> 8, 9
s2 -> 7, 6

peek()
return 6

pop()
s1 -> 8, 9
s2 -> 7
return 6

pop()
s1 -> 8, 9
s2 -> 
return 7

pop()
s2 -> 9
return 8

peek()
return 9

pop()
s2 ->
return 9

*/
