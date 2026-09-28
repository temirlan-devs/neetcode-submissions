class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int total = 0;

        for (String operation : operations) {
            if (operation.equals("+")) {
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
                total += newTop;
            }
            else if (operation.equals("D")) {
                stack.push(2 * stack.peek());
                total += stack.peek();
            } 
            else if (operation.equals("C")) {
                total -= stack.pop();
            } 
            else {
                stack.push(Integer.parseInt(operation));
                total += stack.peek();
            }
        }

        return total;
    }
}