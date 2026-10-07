class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();

        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        // O(n)
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                if (map.get(stack.peek()) != c) return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)

/*

Test

Case 1:
[({[]})]
map: (), {}, []

for 

(
stack -> (

{
stack -> (, {

[
stack -> (, {, [

]
stack -> (, {

}
stack -> (

)
stack -> 

stack is empty -> return true

Case 2:
([){
map: (), {}, []

for

(
stack -> (

[
stack -> (, [

)
] != ) -> return false


Case 3:
)(
map: (), {}, []

for
)
stack is empty -> return false

Case 4:
(
map: (), {}, []

for 

(
stack -> (

stack is not empty return false

*/