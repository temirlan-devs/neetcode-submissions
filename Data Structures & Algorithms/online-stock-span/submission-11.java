class StockSpanner {

    Stack<int[]> stack;

    public StockSpanner() {
        this.stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        // O(n) in total for all next() calls
        while (!stack.isEmpty() && stack.peek()[1] <= price) {
            span += stack.pop()[0];
        }
        stack.push(new int[]{span, price});
        return span;
    }
}

// Time complexity: O(n)
// Space complexity: O(n)

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

/*

Test 

next(10):
s -> [1, 10]
return 1

next(11)
while 11 <= 10
span = 2
s -> [2, 11]
return 2

next(12)
while 11 <= 12
span = 3
s -> [3, 12]

next(9)
s -> [3, 12], [1, 9]
return 1

next(10)
while 9 <= 10
span = 2
s -> [3, 12], [2, 10]
return 2

next(7)
s -> [3, 12], [2, 10], [1, 7]
return 1

next(6)
s -> [3, 12], [2, 10], [1, 7], [1, 6]
return 1

next(20)
while 6 <= 20
span = 2
s -> [3, 12], [2, 10], [1, 7]
while 7 <= 20
span = 3
s -> [3, 12], [2, 10]
while 10 <= 20
span = 5
s -> [3, 12]
while 12 <= 20
span = 8
s ->
s -> [8, 20]
return 8




*/