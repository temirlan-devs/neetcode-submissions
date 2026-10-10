class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        String[] patharr = path.split("/");

        for (String p : patharr) {

            if (p.equals("") || p.equals(".")) continue;

            if (p.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
                continue;
            } 

            stack.push(p);
        }

        sb.append("/");

        for (String str : stack) {
            sb.append(str);
            if (!str.equals(stack.peek())) sb.append("/");
        }
        
        return sb.toString();


    }
}