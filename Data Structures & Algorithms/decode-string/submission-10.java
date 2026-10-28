class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        Stack<Integer> length = new Stack<>();
        StringBuilder cur = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {

            if (Character.isDigit(c)) k = k * 10 + (c - '0');

            else if (c == '[') {
                stack.push(cur.toString());
                length.push(k);
                cur = new StringBuilder();
                k = 0;
            }

            else if (c == ']') {
                String temp = cur.toString();
                cur = new StringBuilder(stack.pop());
                int count = length.pop();

                for (int i = 0; i < count; i++) {
                    cur.append(temp);
                }
            }

            else {
                cur.append(c);
            }

        }

        return cur.toString();

    }
}