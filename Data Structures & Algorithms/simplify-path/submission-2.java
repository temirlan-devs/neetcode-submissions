class Solution {
    public String simplifyPath(String path) {
        String[] patharr = path.split("/");

        Stack<String> stack = new Stack<>();

        for (String p : patharr) {
            if (p.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            }
            else if (!p.equals(".") && !p.equals(""))
                stack.push(p);
        }

        return "/" + String.join("/", stack);
    }
}