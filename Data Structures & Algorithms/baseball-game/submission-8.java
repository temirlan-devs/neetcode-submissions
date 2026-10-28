class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for (String o : operations) {
            if (o.equals("+")) {
                int top = stack.pop();
                int newTop = stack.peek() + top;
                stack.push(top);
                stack.push(newTop);
                res += stack.peek();
            }

            else if (o.equals("D")) {
                stack.push(2 * stack.peek());
                res += stack.peek();
            }

            else if (o.equals("C")) {
                res -= stack.pop();
            }

            else {
                stack.push(Integer.parseInt(o));
                res += stack.peek();
            }

        }

        return res;
    }
}