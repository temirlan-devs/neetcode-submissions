class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        String[] patharr = path.split("/");

        for (String p : patharr) {
            if (p.equals("..")) {
                if (!stack.isEmpty()) stack.pop();}
            else if (!p.equals(".") && !p.equals(""))
                stack.push(p);
        }

        return "/" + String.join("/", stack);
    }
}