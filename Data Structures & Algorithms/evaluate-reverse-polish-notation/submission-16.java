class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack<>();
        int total = 0;

        for (String token : tokens) {

            if (token.equals("+")) stack.push(stack.pop() + stack.pop());

            else if (token.equals("-")) {
                int top = stack.pop();
                int newTop = stack.pop() - top;
                stack.push(newTop);
            }

            else if (token.equals("*")) stack.push(stack.pop() * stack.pop());

            else if (token.equals("/")) {
                int top = stack.pop();
                int newTop = stack.pop() / top;
                stack.push(newTop);
            }

            else {
                stack.push(Integer.parseInt(token));
            }

        }

        return stack.pop();

    }
}
